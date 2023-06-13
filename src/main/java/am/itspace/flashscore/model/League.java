package am.itspace.flashscore.model;

import am.itspace.flashscore.model.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "league")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Country country;
    private String logo;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    @OneToOne
    @JoinColumn(name = "sport_league_video_id")
    private SportLeagueVideo sportLeagueVideo;
}
