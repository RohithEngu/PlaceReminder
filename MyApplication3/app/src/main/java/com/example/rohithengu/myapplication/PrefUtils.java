package com.example.rohithengu.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*********************************************************
 * Project Name : Place Reminder.
 * Implemented by : Rohith Engu,AbdulVafa Choudhary
 * SUID's : 678923180,671290061.
 * FileName : PrefUtils.java
 * Application : Class for Saving Shared user preferences
 *            of user locations.
 **********************************************************/
public class PrefUtils {

    private static String filename = "PREFS";

    public static void savePlace(Context context, String place) {

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putString(place, place);
        editor.apply();
    }

    public static List<String> getSavedPlaces(Context context) {

        List<String> places = new ArrayList<String>();
        SharedPreferences settings;
        settings = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        Map<String, ?> prefsMap = settings.getAll();

        for (Map.Entry<String, ?> entry : prefsMap.entrySet()) {
            places.add(entry.getKey());

        }

        return places;
    }

    public static void removePlace(Context context, String place) {

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.remove(place);
        editor.apply();
    }


}
