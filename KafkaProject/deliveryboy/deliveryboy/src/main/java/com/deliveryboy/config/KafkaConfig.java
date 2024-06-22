package com.deliveryboy.config;

import com.deliveryboy.service.KafkaService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic()
    {
        return TopicBuilder
                .name(AppConstant.LOCATION_TOPIC_NAME)
      //          .partitions()
       //         .replicas()
                .build();
    }
//    @Bean
//    public KafkaService kafkabean()
//    {
//        return new KafkaService();
//    }

}
