package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-song")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Bem-vindo à API de Músicas";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Integer id) {
        Song s = songRepository.getSongById(id);
        if (s == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(s);
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        return ResponseEntity.ok(song);
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Song> updadeSong(@RequestBody Song song) {
        Song existing = songRepository.getSongById(song.getId());
        if (existing == null) return ResponseEntity.notFound().build();
        songRepository.updateSong(song);
        return ResponseEntity.ok(song);
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> deleteSongById(@RequestBody Song song) {
        Song existing = songRepository.getSongById(song.getId());
        if (existing == null) return ResponseEntity.notFound().build();
        songRepository.removeSong(song);
        return ResponseEntity.ok().build();
    }
}