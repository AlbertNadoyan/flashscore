package am.itspace.flashscore.model;

import am.itspace.flashscore.model.enums.SportNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    private String position;
    private String biography;
    private String image;
}
