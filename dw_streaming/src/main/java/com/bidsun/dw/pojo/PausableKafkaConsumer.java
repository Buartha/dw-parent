package com.bidsun.dw.pojo;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;

import java.io.Serializable;
import java.util.Properties;

public class PausableKafkaConsumer<T> extends FlinkKafkaConsumer010<T> implements Serializable {

    public PausableKafkaConsumer(String topic, DeserializationSchema<T> valueDeserializer, Properties props) {
        super(topic, valueDeserializer, props);
    }


    public PausableKafkaConsumer(String topic, KafkaDeserializationSchema<T> valueDeserializer, Properties props) {
        super(topic, valueDeserializer, props);
    }
}
