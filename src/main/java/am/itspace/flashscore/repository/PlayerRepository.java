package am.itspace.flashscore.repository;

import am.itspace.flashscore.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "SELECT p.* " +
            "FROM player p " +
            "JOIN team t ON t.player_id = p.id " +
            "WHERE t.id = :teamId", nativeQuery = true)
    List<Player> findPlayersByTeamId(@Param("teamId") int teamId);

}
