package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Registered extends AbstractEvent {

    private Long id;
    private String bookName;

    public Registered(BookManagement aggregate){
        super(aggregate);
    }
    public Registered(){
        super();
    }
    // keep

}
