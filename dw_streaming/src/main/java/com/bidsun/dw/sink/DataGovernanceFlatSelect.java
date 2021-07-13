package com.bidsun.dw.sink;

import com.bidsun.dw.pojo.BaseBusinessPro;
import org.apache.flink.cep.PatternFlatSelectFunction;
import org.apache.flink.util.Collector;

import java.util.List;
import java.util.Map;

/**
 * @author Niuxy
 * @className DataGovernanceFlatSelect
 * @description 数据治理结果输出到mysql
 * @date 2021/6/16 13:43
 */
public class DataGovernanceFlatSelect implements PatternFlatSelectFunction<BaseBusinessPro, BaseBusinessPro> {
    private static final long serialVersionUID = -3029589950677623844L;

    @Override
    public void flatSelect(Map<String, List<BaseBusinessPro>> pattern, Collector<BaseBusinessPro> collector) throws Exception {
        System.out.println("flatSelect" + pattern.get("indoor"));
        collector.collect(new BaseBusinessPro());
    }
}

