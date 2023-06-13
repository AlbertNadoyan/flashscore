package am.itspace.flashscore.repository;

import am.itspace.flashscore.model.Player;
import am.itspace.flashscore.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT t.* FROM team t " +
            "JOIN team_player_info tpi ON t.team_player_info_id = tpi.id " +
            "JOIN league l ON t.league_id = l.id " +
            "WHERE l.id = :leagueId", nativeQuery = true)
    List<Team> findTeamsByLeague(@Param("leagueId") int leagueName);

    @Query("SELECT t FROM Team t WHERE t.id = :teamId")
    List<Team> findById(@Param("teamId") int teamId);

//    @Query(value = "SELECT p.* " +
//            "FROM player p " +
//            "JOIN team t ON t.player_id = p.id " +
//            "WHERE t.id = :teamId", nativeQuery = true)
//    List<Player> findPlayersByTeamId(@Param("teamId") int teamId);
}
