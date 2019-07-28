package com.nevimax.nmynotes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true) //сам генерирует айди
    int id;
    @ColumnInfo(name = "Zagol")
    String zagol;
    @ColumnInfo(name = "Text")
    String text;
    @ColumnInfo(name = "Date")
    String date;

    public Employee(String zagol, String text, String date) {
        this.zagol = zagol;
        this.text = text;
        this.date = date;
    }
//
//    public Employee(String zagol, String text, int id) {
//        this.zagol = zagol;
//        this.text = text;
//        this.id = id;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZagol() {
        return zagol;
    }

    public void setZagol(String zagol) {
        this.zagol = zagol;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(id)+" "+zagol+" "+text+" "+date;
    }

}
