package team.infra;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="bookLists", path="bookLists")
public interface BookListRepository extends PagingAndSortingRepository<BookList, Long> {

    

    

    // keep

}
