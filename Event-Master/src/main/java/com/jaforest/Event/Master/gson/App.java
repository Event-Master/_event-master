package com.jaforest.Event.Master.gson;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void addToJson() {
        int test = 15;
        ArrayList<String> list = new ArrayList<>();
        list.add("title = test");
        list.add("title = something");
        list.add("test4");

        Gson gson = new Gson();
        String path = "Event-Master/src/main/java/com/jaforest/Event/Master/gson/events.json";
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            gson.toJson(list, fileWriter);
            fileWriter.close();
            System.out.println("writing to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
