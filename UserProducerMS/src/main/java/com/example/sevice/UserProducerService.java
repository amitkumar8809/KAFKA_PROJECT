package com.example.sevice;

import com.example.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducerService {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserProducerService.class);
    public void publishMessage(User user){
        logger.info("publish Message  method Start");
        kafkaTemplate.send("myTopic",user);

        logger.info("User details send to Controller {} ",user.toString());
        logger.info("Publish message method End");

    }
}
