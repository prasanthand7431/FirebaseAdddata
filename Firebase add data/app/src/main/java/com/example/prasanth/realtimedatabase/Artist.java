package com.example.prasanth.realtimedatabase;

public class Artist {

    String artistid;
    String artistname;
    String artistgenere;

    public Artist(String artistid, String artistname, String artistgenere) {
        this.artistid = artistid;
        this.artistname = artistname;
        this.artistgenere = artistgenere;
    }

    public String getArtistid() {
        return artistid;
    }

    public String getArtistname() {
        return artistname;
    }

    public String getArtistgenere() {
        return artistgenere;
    }
}
