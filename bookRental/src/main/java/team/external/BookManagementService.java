package team.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="bookManagement", url="${api.url.bookManagement}")
public interface BookManagementService {
    @RequestMapping(method= RequestMethod.GET, path="/bookManagements/{id}")
    public BookManagement getBookManagement(@PathVariable("id") Long id);

    // keep

}

