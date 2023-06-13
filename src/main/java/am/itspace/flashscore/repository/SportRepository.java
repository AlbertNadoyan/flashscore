package am.itspace.flashscore.repository;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
    List<Sport> findTop8ByOrderById();

    List<Sport> findAllBySportNames(String name);

}
