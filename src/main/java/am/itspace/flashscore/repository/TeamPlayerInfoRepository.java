package am.itspace.flashscore.repository;

import am.itspace.flashscore.model.TeamPlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamPlayerInfoRepository extends JpaRepository<TeamPlayerInfo, Integer> {

}
