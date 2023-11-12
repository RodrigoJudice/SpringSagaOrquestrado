package com.git.judice.inventory.config.kafka;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.git.judice.inventory.adapters.out.message.SaleMessage;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaProducerConfig {

  @Bean
  ProducerFactory<String, SaleMessage> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProps.put(GROUP_ID_CONFIG, "inventory");
    configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  KafkaTemplate<String, SaleMessage> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

}