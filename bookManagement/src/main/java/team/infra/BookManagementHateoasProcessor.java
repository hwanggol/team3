package team.infra;
import team.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class BookManagementHateoasProcessor implements RepresentationModelProcessor<EntityModel<BookManagement>>  {

    @Override
    public EntityModel<BookManagement> process(EntityModel<BookManagement> model) {

        
        return model;
    }
    
}
