package team.domain;

import team.infra.AbstractEvent;
import lombok.Data;
import java.util.Date;

@Data
public class Registered extends AbstractEvent {

    private Long id;
    private String bookName;
}
