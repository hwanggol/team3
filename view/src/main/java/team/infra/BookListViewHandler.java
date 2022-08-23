package team.infra;

import team.domain.*;
import team.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookListViewHandler {


    @Autowired
    private BookListRepository bookListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistered_then_CREATE_1 (@Payload Registered registered) {
        try {

            if (!registered.validate()) return;

            // view 객체 생성
            BookList bookList = new BookList();
            // view 객체에 이벤트의 Value 를 set 함
            bookList.setId(registered.getId());
            bookList.setBookName(registered.getBookName());
            // view 레파지 토리에 save
            bookListRepository.save(bookList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_UPDATE_1(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;
                // view 객체 조회
            Optional<BookList> bookListOptional = bookListRepository.findById(reserved.getBookId());

            if( bookListOptional.isPresent()) {
                 BookList bookList = bookListOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setBookStatus("예약됨");    
                // view 레파지 토리에 save
                 bookListRepository.save(bookList);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_UPDATE_2(@Payload Rented rented) {
        try {
            if (!rented.validate()) return;
                // view 객체 조회
            Optional<BookList> bookListOptional = bookListRepository.findById(rented.getBookId());

            if( bookListOptional.isPresent()) {
                 BookList bookList = bookListOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setBookStatus("대여됨");    
                // view 레파지 토리에 save
                 bookListRepository.save(bookList);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_3(@Payload Canceled canceled) {
        try {
            if (!canceled.validate()) return;
                // view 객체 조회
            Optional<BookList> bookListOptional = bookListRepository.findById(canceled.getBookId());

            if( bookListOptional.isPresent()) {
                 BookList bookList = bookListOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setBookStatus("예약취소됨");    
                // view 레파지 토리에 save
                 bookListRepository.save(bookList);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_4(@Payload Returned returned) {
        try {
            if (!returned.validate()) return;
                // view 객체 조회
            Optional<BookList> bookListOptional = bookListRepository.findById(returned.getBookId());

            if( bookListOptional.isPresent()) {
                 BookList bookList = bookListOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookList.setBookStatus("반납됨");    
                // view 레파지 토리에 save
                 bookListRepository.save(bookList);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // keep

}

