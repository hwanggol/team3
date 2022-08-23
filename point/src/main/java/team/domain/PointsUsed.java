package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PointsUsed extends AbstractEvent {

    private Long id;
    private String pointQty;
    private String userId;

    public PointsUsed(Point aggregate){
        super(aggregate);
    }
    public PointsUsed(){
        super();
    }
    // keep

}
