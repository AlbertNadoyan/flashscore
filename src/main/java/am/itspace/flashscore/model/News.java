package am.itspace.flashscore.model;

import am.itspace.flashscore.model.enums.SportNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
    @DateTimeFormat(pattern = "dd MMMM yyyy")
    private LocalDate date;
}
