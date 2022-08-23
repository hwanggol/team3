package team.domain;

import team.domain.PointsUsed;
import team.domain.PointsReturned;
import team.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Point_table")
@Data

public class Point  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String pointQty;
    
    
    
    
    
    private String userId;

    @PostPersist
    public void onPostPersist(){


        PointsUsed pointsUsed = new PointsUsed(this);
        pointsUsed.publishAfterCommit();



        PointsReturned pointsReturned = new PointsReturned(this);
        pointsReturned.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }




    public static void refundPoint(Canceled canceled){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointsReturned pointsReturned = new PointsReturned(point);
        pointsReturned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointsReturned pointsReturned = new PointsReturned(point);
            pointsReturned.publishAfterCommit();

         });
        */

        
    }
    public static void usePoint(Reserved reserved){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointsUsed pointsUsed = new PointsUsed(point);
        pointsUsed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reserved.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointsUsed pointsUsed = new PointsUsed(point);
            pointsUsed.publishAfterCommit();

         });
        */

        
    }


}
