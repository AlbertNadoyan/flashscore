package am.itspace.flashscore.service;

import am.itspace.flashscore.model.Sport;
import am.itspace.flashscore.service.impl.SportServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SportService {

    List<Sport> getEightSport();
    List<Sport> getAllSport();

    List<Sport> getSportByName(String name);

}
