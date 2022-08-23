package team.domain;

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
        // Get request from BookManagement
        //team.external.BookManagement bookManagement =
        //    Application.applicationContext.getBean(team.external.BookManagementService.class)
        //    .getBookManagement(/** mapping value needed */);

    }

    public static BookRentalRepository repository(){
        BookRentalRepository bookRentalRepository = BookRentalApplication.applicationContext.getBean(BookRentalRepository.class);
        return bookRentalRepository;
    }



    public void rent(){
        Rented rented = new Rented(this);
        rented.publishAfterCommit();

    }
    public void reserve(){
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();

    }
    public void returnBook(){
        Returned returned = new Returned(this);
        returned.publishAfterCommit();

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
