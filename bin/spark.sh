/usr/hdp/2.2.0.0-2041/spark/bin/spark-submit \
--class com.boc.streaming.main.IPPSStreamingProcess \
--master yarn \
--driver-memory 1g \
--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
--executor-memory 1g \
--conf spark.executor.userClassPathFirst=true \
./BocStreaming-1.0.jar