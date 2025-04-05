package local.snehal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Producer {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    //@Autowired
    //KafkaTemplate<String, JsonMessage> kafkaJsonTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void sendStringMessageToKafka(String message) {
        kafkaTemplate.send("snehal_string_topic_1", message);
    }

    public void sendJsonMessageToKafka(JsonMessage message) {
        try {
            String jsonString = objectMapper.writeValueAsString(message);
            kafkaTemplate.send("snehal_json_topic_1", jsonString);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

