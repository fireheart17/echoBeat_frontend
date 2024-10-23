package com.echobeat.servingwebcontent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

class Song {

    public String name;
    public int id;

    public Song(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Album {

    public String name;
    public int id;

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

@Controller
public class artist {

    @GetMapping("/artist")
    public String getArtist(Model model) {
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = "song";
            char id = (char) ('0' + i);
            s = s + id;
            Song newSong = new Song(i, s);
            songs.add(newSong);
        }
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = "album";
            char id = (char) ('0' + i);
            s = s + id;
            Album newAlbum = new Album(i, s);
            albums.add(newAlbum);
        }

        model.addAttribute("songs", songs);
        model.addAttribute("albums", albums);
        return "artist";
    }

}