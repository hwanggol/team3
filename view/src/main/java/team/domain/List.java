package team.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="List_table")
@Data
public class List {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long bookId;
        private String bookStatus;
        private String bookName;


}