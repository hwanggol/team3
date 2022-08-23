package team.domain;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="bookRentals", path="bookRentals")
public interface BookRentalRepository extends PagingAndSortingRepository<BookRental, Long>{

}
