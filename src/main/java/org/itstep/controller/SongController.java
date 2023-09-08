package org.itstep.controller;

import org.itstep.model.Song;
import org.itstep.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/songs")
    public String showSongs(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/add/song")
    public String addSong(@ModelAttribute("song") Song song) {
        return "addSong";
    }

    @PostMapping("/songs")
    public String createSong(@ModelAttribute Song song,
                             //@RequestParam("audioFile") MultipartFile audioFile,
                             @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        // Обработка других полей сущности Song
        // ...
/*
        if (!audioFile.isEmpty()) {
            File dir = new File("src/main/resources/static");
            audioFile.transferTo(new File(dir.getAbsolutePath()+"/"+audioFile.getOriginalFilename()));
            song.setAudioFilePath(audioFile.getOriginalFilename());
        }
*/
        if (!imageFile.isEmpty()) {
            File dir = null; //Файловая система
                //dir = new File("src/main/resources/static/album_photo");
            dir = new File("target/classes/static/album_photo");
            imageFile.transferTo(new File(dir.getAbsolutePath()+"/"+imageFile.getOriginalFilename()));
            song.setPhotoFilePath("/album_photo/"+imageFile.getOriginalFilename());
        }
        //System.out.println(song);
        // Сохранение сущности Song в базу данных
        // ...

        songService.save(song);
        return "redirect:/songs";
    }
}