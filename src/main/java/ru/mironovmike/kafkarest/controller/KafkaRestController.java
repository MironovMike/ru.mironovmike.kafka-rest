package ru.mironovmike.kafkarest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mironovmike.kafkarest.schema.GeneralMessage;
import ru.mironovmike.kafkarest.service.KafkaService;

@RestController
@RequestMapping(value = "v1")
@RequiredArgsConstructor
public class KafkaRestController {
    @Autowired
    private final KafkaService kafkaService;
    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public ResponseEntity<String> postMessage(@PathVariable("topic") String topic, @RequestBody String body) {
        GeneralMessage message = new GeneralMessage();
        message.setData(body);
        kafkaService.sendMessage(topic, message);

        //kafkaService.produceMessage(message);

        return ResponseEntity.ok("Success");
    }
}
