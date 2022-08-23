package team.domain;

import team.domain.Registered;
import team.BookManagementApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="BookManagement_table")
@Data

public class BookManagement  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String bookName;

    @PostPersist
    public void onPostPersist(){


        Registered registered = new Registered(this);
        registered.publishAfterCommit();

    }

    public static BookManagementRepository repository(){
        BookManagementRepository bookManagementRepository = BookManagementApplication.applicationContext.getBean(BookManagementRepository.class);
        return bookManagementRepository;
    }






}
