package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();
    private int nextId = 1;

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        if (id == null) return null;
        Optional<Song> opt = list.stream().filter(s -> id.equals(s.getId())).findFirst();
        return opt.orElse(null);
    }

    public void addSong(Song s) {
        if (s == null) return;
        if (s.getId() == null) {
            s.setId(nextId++);
        } else {
            // ensure nextId is always greater than existing ids
            nextId = Math.max(nextId, s.getId() + 1);
        }
        list.add(s);
    }

    public void updateSong(Song s) {
        if (s == null || s.getId() == null) return;
        for (int i = 0; i < list.size(); i++) {
            if (s.getId().equals(list.get(i).getId())) {
                list.set(i, s);
                return;
            }
        }
    }

    public void removeSong(Song s) {
        if (s == null || s.getId() == null) return;
        list.removeIf(item -> s.getId().equals(item.getId()));
    }
}