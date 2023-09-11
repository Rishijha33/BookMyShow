package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class Booking extends BaseModel{ //Ticket class
    @ManyToOne
    private User user;

    @ManyToMany // As one user can cancel a ShowSeat and other can book the same seat
    private List<ShowSeat> showSeats;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private Date bookedDate;

    @OneToMany
    private List<Payment> payments;

}

/*
Cardinalities
1       -----> 1
Booking ------ User m:1
m  <--------- 1

1       ------> m
Booking ------ ShowSeat m:m   This could be the case in case of cancellation
m       <------- 1
1     ------> M
Booking------Payment
    q   <------ 1
 */
