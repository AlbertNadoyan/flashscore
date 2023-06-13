package am.itspace.flashscore;

import am.itspace.flashscore.repository.TeamPlayerInfoRepository;
import am.itspace.flashscore.service.ScraperService;
import am.itspace.flashscore.service.impl.ScraperServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlashscoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashscoreApplication.class, args);
    }

}
