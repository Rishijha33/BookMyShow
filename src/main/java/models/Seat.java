package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String name;

    private int row;

    private int col;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

}
