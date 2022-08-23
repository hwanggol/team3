package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rented extends AbstractEvent {

    private Long id;
    private String bookName;
    private String userId;
    private Integer point;
    private String rentalStartTime;
    private String rentalEndTime;
    private String rentalStatus;
    private Long bookId;

    public Rented(BookRental aggregate){
        super(aggregate);
    }
    public Rented(){
        super();
    }
    // keep

}
