package team.domain;

import team.domain.Rented;
import team.domain.Returned;
import team.BookRentalApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="BookRental_table")
@Data

public class BookRental  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long bookId;
    
    
    
    
    
    private String bookName;
    
    
    
    
    
    private String userId;
    
    
    
    
    
    private Integer point;
    
    
    
    
    
    private String rentalStartTime;
    
    
    
    
    
    private String rentalEndTime;
    
    
    
    
    
    private String rentalStatus;

    @PostPersist
    public void onPostPersist(){


        Rented rented = new Rented(this);
        rented.publishAfterCommit();



        Returned returned = new Returned(this);
        returned.publishAfterCommit();

        // Get request from BookManagement
        //team.external.BookManagement bookManagement =
        //    Application.applicationContext.getBean(team.external.BookManagementService.class)
        //    .getBookManagement(/** mapping value needed */);

    }

    public static BookRentalRepository repository(){
        BookRentalRepository bookRentalRepository = BookRentalApplication.applicationContext.getBean(BookRentalRepository.class);
        return bookRentalRepository;
    }



    public void reserve(){
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();

    }
    public void cancel(){
        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();

    }

    public static void reserveBook(PointsUsed pointsUsed){

        /** Example 1:  new item 
        BookRental bookRental = new BookRental();
        repository().save(bookRental);

        */

        /** Example 2:  finding and process
        
        repository().findById(pointsUsed.get???()).ifPresent(bookRental->{
            
            bookRental // do something
            repository().save(bookRental);


         });
        */

        
    }


}
