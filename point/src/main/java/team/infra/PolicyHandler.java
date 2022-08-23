package team.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import team.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import team.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired PointRepository pointRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Canceled'")
    public void wheneverCanceled_RefundPoint(@Payload Canceled canceled){

        Canceled event = canceled;
        System.out.println("\n\n##### listener RefundPoint : " + canceled + "\n\n");


        

        // Sample Logic //
        Point.refundPoint(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Reserved'")
    public void wheneverReserved_UsePoint(@Payload Reserved reserved){

        Reserved event = reserved;
        System.out.println("\n\n##### listener UsePoint : " + reserved + "\n\n");


        

        // Sample Logic //
        Point.usePoint(event);
        

        

    }

    // keep

}


