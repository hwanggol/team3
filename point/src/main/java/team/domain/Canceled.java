package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private Long bookId;
    private String bookName;
    private String userId;
    private Integer point;
    private String rentalStartTime;
    private String rentalEndTime;
    private String rentalStatus;

// keep

}


