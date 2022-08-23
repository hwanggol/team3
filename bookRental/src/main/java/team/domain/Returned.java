package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Returned extends AbstractEvent {

    private Long id;
    private Long bookId;
    private String bookName;
    private String userId;
    private Integer point;
    private String rentalStartTime;
    private String rentalEndTime;
    private String rentalStatus;

    public Returned(BookRental aggregate){
        super(aggregate);
    }
    public Returned(){
        super();
    }
    // keep

}
