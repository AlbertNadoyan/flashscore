package am.itspace.flashscore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "team_player_info_id")
    private TeamPlayerInfo teamPlayerInfo;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
    @Column(name = "match")
    private LocalDateTime match;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player players;

}
