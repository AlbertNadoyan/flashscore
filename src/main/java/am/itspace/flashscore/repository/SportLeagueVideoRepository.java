package am.itspace.flashscore.repository;

import am.itspace.flashscore.model.League;
import am.itspace.flashscore.model.SportLeagueVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SportLeagueVideoRepository extends JpaRepository<SportLeagueVideo, Integer> {
    @Query(value = "SELECT l.*, v.video FROM league l JOIN sport_league_video v ON l.sport_league_video_id = v.id WHERE l.id = :leagueId ", nativeQuery = true)
    List<SportLeagueVideo> findLeagueAndVideoById(@Param("leagueId") int leagueId);
}
