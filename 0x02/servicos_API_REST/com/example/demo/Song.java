package com.example.demo;

public class Song {
    private Integer id;
    private String title;
    private String artist;
    private Integer year;

    public Song() {}

    public Song(Integer id, String title, String artist, Integer year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }
}

