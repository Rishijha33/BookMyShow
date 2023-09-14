package repositories;

import models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);
    // find all the showseats by Ids


    @Override
    ShowSeat save(ShowSeat showSeat);
    //save ---> Update + Insert
    //If the Showseat obj is not there in the DB then insert it
    // and if there, update it in the DB

}
