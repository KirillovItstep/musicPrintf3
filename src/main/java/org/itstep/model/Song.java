package org.itstep.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private int id;

    @Column(name = "song_name")
    private String songName;
    @Column(name = "song_year")
    private int songYear;
    //@Column(name = "audio_file_path")
    //private String audioFilePath;
    @Column(name = "photo_file_path")
    private String photoFilePath;
    public int getId() {
        return id;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }

    /*public String getAudioFilePath() {
        return audioFilePath;
    }

    public void setAudioFilePath(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }
*/
    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getSongYear() {
        return songYear;
    }

    public void setSongYear(int songYear) {
        this.songYear = songYear;
    }

    public Song() {
    }

    public Song(int id, String songName, int songYear) {
        this.id = id;
        this.songName = songName;
        this.songYear = songYear;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", songYear=" + songYear +
                ", photoFilePath='" + photoFilePath + '\'' +
                '}';
    }
}