package team.infra;
import team.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class BookRentalHateoasProcessor implements RepresentationModelProcessor<EntityModel<BookRental>>  {

    @Override
    public EntityModel<BookRental> process(EntityModel<BookRental> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/rent").withRel("rent"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/reserve").withRel("reserve"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/returnbook").withRel("returnbook"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cancel").withRel("cancel"));

        
        return model;
    }
    
}
