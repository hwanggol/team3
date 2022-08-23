package team.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="BookList_table")
@Data
public class BookList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String bookStatus;
        private String bookName;


}