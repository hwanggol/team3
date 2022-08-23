package team.domain;

import team.infra.AbstractEvent;
import lombok.Data;
import java.util.Date;

@Data
public class Canceled extends AbstractEvent {

    private Long id;
    private Long bookId;
    private String bookName;
    private String userId;
    private Integer point;
    private String rentalStartTime;
    private String rentalEndTime;
    private String rentalStatus;
}
