package local.snehal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/rest/api")
public class SpringApplication {

    @Autowired
    Producer producer;

    @Autowired
    ObjectMapper objectMapper;


    @GetMapping("/producerStringMessage")
    public String getStringMessageFromClient(@RequestParam("message") String message) {
        producer.sendStringMessageToKafka(message);
        return "String Message received successfully!";

    }

    @PostMapping("/producerJsonMessage")
    public String getJsonMessageFromClient(@RequestBody String StringJsonMessage) {

        try {
            JsonMessage jsonMessage = objectMapper.readValue(StringJsonMessage, JsonMessage.class);
            System.out.println("Received Message : " + jsonMessage.getName());
            System.out.println("Received Message : " + jsonMessage.getMessage());
            producer.sendJsonMessageToKafka(jsonMessage);
            return "Json Message received successfully!";
        }catch(Exception e) {
            e.printStackTrace();
            return "Server Error in handling Json Message!";
        }


    }

}
