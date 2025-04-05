package local.snehal;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "snehal_string_topic_1", groupId = "snehal_topic_1_group")
    public void listenToStringKafka(String message) {
        System.out.println("Received string message is : " +  message);
    }

    @KafkaListener(topics = "snehal_json_topic_1", groupId = "snehal_topic_1_group")
    public void listenToJsonKafka(String message) {

        System.out.println("Received Json message is : " +  message);
    }

}