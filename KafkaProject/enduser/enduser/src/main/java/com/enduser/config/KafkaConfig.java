package com.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics= AppConstant.LOCATION_UPDATED_TOPIC, groupId = AppConstant.GROUP_ID)
    public void updatedLocation(String value)
    {
       System.out.println(value);
    }

}
