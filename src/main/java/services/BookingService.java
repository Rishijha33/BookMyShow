package services;

import controllers.BookingController;
import exceptions.InvalidShowException;
import exceptions.InvalidUserException;
import exceptions.ShowSeatNotAvailableException;
import models.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ShowRepository;
import repositories.ShowSeatRepository;
import repositories.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository, ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService)
    {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE) //Anything inside this method will be in the lock
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws ShowSeatNotAvailableException {
        //---------ACQUIRE THE LOCK--------


        //Implement the movie booking Logic
        //Steps to book movie ticket








        //9. Save the booking to DB
        //10. Return the booking

        //-------RELEASE THE LOCK----------

        //As discussed the second approach is better but acquiring lock in the middle of a method is tough, so will
        //learn this in backend project module


        //1. Get the User from the userId from DB
        Optional<User> optionalUser = userRepository.findById(userId);  //Optional signifies the user might not be there
        if(optionalUser.isEmpty())
        {
            throw new InvalidUserException("Invalid UserId");
        }

        User bookedBy = optionalUser.get();

        //2. Get the Show from the showId from DB
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty())
        {
            throw new InvalidShowException("Invalid ShowId");
        }
        Show bookedShow = optionalShow.get();
        //3. Get the List of showSeats from the List of showSeatIds from the DB
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        //4. Check  if all the seats are available or not
        //5. If not, throw an exception
        for(ShowSeat showSeat : showSeats)
        {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new ShowSeatNotAvailableException("The following seat is not available", showSeat.getId());
            }
        }

        //6. If yes mark the status as BLOCKED
        for(ShowSeat showSeat : showSeats)
        {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //7. Save the status of seat in the DB as well
            showSeatRepository.save(showSeat);
        }

        //8. Create the Booking object
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setBookedDate(new Date());
        booking.setCreatedAt(new Date());
        booking.setUser(bookedBy);
        booking.setShowSeats(showSeats);
        //calculate the amount from the showseattype class and set the amount here
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, bookedShow));

        return booking;

    }

}
