package com.example.song.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    public void receiveMessage(Object message) {
        LOGGER.info("Received message" + message.toString());
    }
}
