package am.itspace.flashscore.service.impl;

import am.itspace.flashscore.model.Sport;
import am.itspace.flashscore.repository.SportRepository;
import am.itspace.flashscore.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;

    @Override
    public List<Sport> getEightSport() {
        return sportRepository.findTop8ByOrderById();
    }

    @Override
    public List<Sport> getAllSport() {
        return sportRepository.findAll();
    }

    @Override
    public List<Sport> getSportByName(String name) {
        return sportRepository.findAllBySportNames(name);
    }

}
