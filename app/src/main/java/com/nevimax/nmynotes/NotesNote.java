package com.nevimax.nmynotes;

public class NotesNote {
    private String zak;
    private String text;
    private String time;

    public NotesNote(String zak, String text, String time) {
        this.zak = zak;
        this.text = text;
        this.time = time;
    }

    public String getZak() {
        return zak;
    }

    public void setZak(String zak) {
        this.zak = zak;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
