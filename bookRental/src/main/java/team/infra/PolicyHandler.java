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
    @Autowired BookRentalRepository bookRentalRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PointsUsed'")
    public void wheneverPointsUsed_ReserveBook(@Payload PointsUsed pointsUsed){

        PointsUsed event = pointsUsed;
        System.out.println("\n\n##### listener ReserveBook : " + pointsUsed + "\n\n");


        

        // Sample Logic //
        BookRental.reserveBook(event);
        

        

    }

    // keep

}


