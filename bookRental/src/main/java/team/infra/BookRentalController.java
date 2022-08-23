package team.infra;
import team.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/bookRentals")
@Transactional
public class BookRentalController {
    @Autowired
    BookRentalRepository bookRentalRepository;




    @RequestMapping(value = "bookRentals/{id}/reserve",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public BookRental reserve(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /bookRental/reserve  called #####");
            Optional<BookRental> optionalBookRental = bookRentalRepository.findById(id);
            
            optionalBookRental.orElseThrow(()-> new Exception("No Entity Found"));
            BookRental bookRental = optionalBookRental.get();
            bookRental.reserve();
            
            bookRentalRepository.save(bookRental);
            return bookRental;
            
    }
    




    @RequestMapping(value = "bookRentals/{id}/cancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public BookRental cancel(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /bookRental/cancel  called #####");
            Optional<BookRental> optionalBookRental = bookRentalRepository.findById(id);
            
            optionalBookRental.orElseThrow(()-> new Exception("No Entity Found"));
            BookRental bookRental = optionalBookRental.get();
            bookRental.cancel();
            
            bookRentalRepository.save(bookRental);
            return bookRental;
            
    }
    



    // keep
}
