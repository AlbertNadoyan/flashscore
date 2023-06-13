package am.itspace.flashscore.controller;

import am.itspace.flashscore.model.Sport;
import am.itspace.flashscore.service.SportService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SportController {

    @Value("${flashscore.spring.images.folder}")
    private String folderPathImages;
    private final SportService sportService;
    @GetMapping("/sports")
    public String sportPage(ModelMap modelMap){
        List<Sport> findAllSport = sportService.getAllSport();
        modelMap.addAttribute("sport", findAllSport);
        return "sport";
    }

    @GetMapping("/sport/{name}")
    public String currentSport(@PathVariable("name") String name, ModelMap modelMap){
        List<Sport> findCurrentSport = sportService.getSportByName(name);
        modelMap.addAttribute("sport", findCurrentSport);
        return "currentSport";
    }

    @GetMapping("/sport/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImages + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }
}
