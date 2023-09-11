package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;

    private SeatType seatType;

    private int price;
}

/*
Cardinalities

    1        ------->   1
ShowSeatType ------- Show
         M    <------ 1
 */
