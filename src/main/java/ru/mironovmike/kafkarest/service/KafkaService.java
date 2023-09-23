package ru.mironovmike.kafkarest.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.mironovmike.kafkarest.schema.GeneralMessage;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaService {
//    @Autowired
//    private Processor processor;

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, GeneralMessage> kafkaTemplate;
    public void sendMessage(String topicName, GeneralMessage message) {
        //byte[] data = serializeAvroMessageJSON(message);
        CompletableFuture<SendResult<String, GeneralMessage>> future = kafkaTemplate.send(topicName, message);
//        future.whenComplete((result, ex) -> {
//
//            if (ex == null) {
//                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata()
//                        .offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
//            }
//        });
    }

//    private byte[] serializeAvroMessageJSON(Message message) {
//        SpecificDatumWriter<Message> writer = new SpecificDatumWriter<>(Message.class);
//        byte[] data = new byte[0];
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        Encoder jsonEncoder;
//        try {
//            jsonEncoder = EncoderFactory.get().jsonEncoder(Message.getClassSchema(), stream);
//            writer.write(message, jsonEncoder);
//            jsonEncoder.flush();
//            data = stream.toByteArray();
//        } catch (IOException e) {
//            logger.error("Serialization error: " + e.getMessage());
//        }
//        return data;
//    }

//    public void produceCrmContact(String username, Long phone, Integer age) {
//        CrmContact contact = new CrmContact();
//        contact.setUsername(username);
//        contact.setPhone(phone);
//        contact.setAge(age);
//
//        Message<CrmContact> message = MessageBuilder.withPayload(contact).build();
//
//        processor.output()
//                .send(message);
//    }
//
//    public void produceMessage(String data) {
//        ru.mironovmike.kafkarest.schema.Message message = new ru.mironovmike.kafkarest.schema.Message();
//        message.setData(data);
//
//        Message<ru.mironovmike.kafkarest.schema.Message> kafkaMessage = MessageBuilder.withPayload(message).build();
//
//        processor.output()
//                .send(kafkaMessage);
//    }
}
