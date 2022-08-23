package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PointsUsed extends AbstractEvent {

    private Long id;
    private String pointQty;
    private String userId;

// keep

}


