package com.nevimax.nmynotes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static String time(){
    //time
    Date time1 = new Date();
    DateFormat timeFormat = new SimpleDateFormat("HH.mm ");
    String timeText = timeFormat.format(time1);
    //date
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    String dateText = dateFormat.format(time1);
    String dati = timeText + "|| " + dateText;
    return dati;
    }
}
