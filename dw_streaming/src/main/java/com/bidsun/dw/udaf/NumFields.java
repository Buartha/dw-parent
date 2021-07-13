package com.bidsun.dw.udaf;


import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.udf.generic.AbstractGenericUDAFResolver;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.io.LongWritable;

public class NumFields extends AbstractGenericUDAFResolver {
    //static final Log LOG = LogFactory.getLog(SumUDAF.class.getName());

    @Override
    public GenericUDAFEvaluator getEvaluator(TypeInfo[] info) throws SemanticException {
        if (info.length > 2)
            throw new UDFArgumentException();
        return new GenericEvaluate();
    }

    //实现真实逻辑的类
    public static class GenericEvaluate extends GenericUDAFEvaluator {

        private LongWritable result;
        private PrimitiveObjectInspector inputOI1;
        private PrimitiveObjectInspector inputOI2;


        //主要进行变量类型的初始化,Mode来判断步骤执行到哪里了，不同的步骤使用不同的方法
        //在map阶段和reduce阶段都要执行，只初始化一次
        //map阶段,parameters长度与UDAF输入的参数个数有关,每个元素代表一个输入参数
        //reduce阶段,parameters的长度为1，为统计量
        @Override
        public ObjectInspector init(Mode m, ObjectInspector[] parameters) throws HiveException {
            super.init(m, parameters);

            result = new LongWritable();
            if (parameters.length > 1) {
                inputOI1 = (PrimitiveObjectInspector) parameters[0];
                inputOI2 = (PrimitiveObjectInspector) parameters[1];
            } else {
                inputOI1 = (PrimitiveObjectInspector) parameters[0];
            }

            return PrimitiveObjectInspectorFactory.writableLongObjectInspector;
        }

        //缓存计算结果,比如map、merge的中间结果等，以便再对中间结果进行操作
        @Override
        public AggregationBuffer getNewAggregationBuffer() throws HiveException {
            CountAgg agg = new CountAgg();
            reset(agg);
            return agg;
        }


        //读每条数据进行操作
        @Override
        public void iterate(AggregationBuffer agg, Object[] parameters) throws HiveException {
            if (parameters == null || parameters[0] == null || parameters[1] == null) {
                return;
            }

            String requiredFieldStr = parameters[0].toString();
            String filledFieldStr = parameters[1].toString();
            String[] arr1 = requiredFieldStr.split(",");
            String[] arr2 = filledFieldStr.split(",");

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {

                    if (arr1[i].equals(arr2[j])) {
                        ((CountAgg) agg).count++;
                        break;
                    }
                }
            }
        }

        //返回部分结果的
        @Override
        public Object terminatePartial(AggregationBuffer agg) throws HiveException {
            result.set(((CountAgg) agg).count);
            return result;
        }

        //合并,partial是terminatePartial返回的对象
        @Override
        public void merge(AggregationBuffer agg, Object partial) throws HiveException {
            if (partial != null) {
                Long p = PrimitiveObjectInspectorUtils.getLong(partial, inputOI1);
                ((CountAgg) agg).count += p;
            }
        }

        //返回最终结果的
        @Override
        public Object terminate(AggregationBuffer agg) throws HiveException {
            result.set(((CountAgg) agg).count);
            return result;
        }

        public static class CountAgg implements AggregationBuffer {
            Long count;
        }

        //对内存进行重置
        @Override
        public void reset(AggregationBuffer countAgg) throws HiveException {
            CountAgg agg = (CountAgg) countAgg;
            agg.count = 0L;
        }
    }
}