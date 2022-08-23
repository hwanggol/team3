package team.infra;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="lists", path="lists")
public interface ListRepository extends PagingAndSortingRepository<List, Long> {

    List<List> findByBookId(Long bookId);


    

    // keep

}
