package com.bidsun.dw.streaming.bi;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Niuxy
 * @className KafkaWriter
 * @description TODO
 * @date 2021/5/11 19:30
 */
public class KafkaWriter {
    //本地的kafka机器列表
    public static KafkaProducer<String, String> register_Kafka() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "47.117.34.236:9092");//xxx服务器ip
        props.put("acks", "all");//所有follower都响应了才认为消息提交成功，即"committed"
        props.put("retries", 0);//retries = MAX 无限重试，直到你意识到出现了问题:)
        props.put("batch.size", 16384);//producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
        //batch.size当批量的数据大小达到设定值后，就会立即发送，不顾下面的linger.ms
        props.put("linger.ms", 1);//延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
        props.put("buffer.memory", 33554432);//producer可以用来缓存数据的内存大小。
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
    return producer;
    }

    public static void writeToKafka(String userActionJson,KafkaProducer<String, String> producer,String topic) throws Exception {


        //包装成kafka发送的记录
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("catalog_main_data", null,
                null, userActionJson);
        //发送到缓存
        producer.send(record);
        System.out.println("向kafka发送数据:" + userActionJson);
        //立即发送
        producer.flush();

    }

    public static void main(String[] args) {
        while (true) {
            try {
                //每1秒写一条数据
                TimeUnit.SECONDS.sleep(1);
               // writeToKafka();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
