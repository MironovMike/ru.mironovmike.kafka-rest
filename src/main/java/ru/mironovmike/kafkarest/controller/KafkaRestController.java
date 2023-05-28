package ru.mironovmike.kafkarest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "v1")
public class KafkaRestController {
    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public ResponseEntity<String> postMessage(@PathVariable("topic") String topic) {
        return ResponseEntity.ok("hello v0.0.1");
    }
}
