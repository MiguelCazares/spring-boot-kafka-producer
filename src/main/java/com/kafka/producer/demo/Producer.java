package com.kafka.producer.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Producer {
    private static Producer producer;
    private KafkaProducer<String, String> kafkaProducer;
    private static final String TOPIC = "mi-topico";
    private static final Integer PARTITION = 0;
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private Producer() {
        try {
            var conf = new Properties();
            conf.load(new FileReader("src/main/resources/producer.properties"));

            this.kafkaProducer = new KafkaProducer<>(conf);
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
        }
    }

    public void send(String key, String value) {
        try {
            var record = new ProducerRecord<String, String>(TOPIC, PARTITION, key, value);
            this.kafkaProducer.send(record);
        } catch (KafkaException e) {
            logger.error(e.getMessage());
            this.close();
        }
    }

    public void close() {
        this.kafkaProducer.close();
    }

    public static Producer getInstance() {
        if (Objects.isNull(producer)) {
            producer = new Producer();
        }
        return producer;
    }
}
