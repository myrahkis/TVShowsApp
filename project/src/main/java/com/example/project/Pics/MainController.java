package com.example.project.Pics;

import com.example.project.TVShows;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainController {
    static LinkedList<TVShows> listTVShows;
    public static String pathCSV = ".\\src\\main\\resources\\data.csv";

    public  MainController() throws Exception {
        listTVShows = ParseCSV(pathCSV);
    }

    private static boolean CheckColumn(String text)
    {
        String trimText = text.trim();
        //Если в тексте одна ковычка или текст на неё заканчивается, то это часть предыдушей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"");
    }

    private static String deleteQuotes(String text)
    {
        while (text.charAt(0) == '\"' && text.charAt(text.length()-1)=='\"')
        {
            text = text.replaceFirst("\"", "");
            text = text.substring(0,text.length()-1);
        }
        return text;
    }

    public static boolean addInCSV()
    {
        try (PrintWriter writer = new PrintWriter(pathCSV)){
            for (TVShows tvShows : listTVShows) {
                String line = "";
                line += "\"" + deleteQuotes(tvShows.getName()) + "\";";
                line += "\"" + deleteQuotes(tvShows.getYear()) + "\";";
                line += "\"" + deleteQuotes(tvShows.getGenre()) + "\";";
                line += "\n";
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static LinkedList<TVShows> ParseCSV(String path) throws Exception
    {
        LinkedList<TVShows> tvShows = new LinkedList();
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String line : lines)
        {
            String[] splited = line.split(";");
            ArrayList<String> column = new ArrayList<>();
            for (String s : splited) {
                if (CheckColumn(s)) {
                    String lastText = column.get(column.size());
                    column.set(column.size() - 1, lastText + ";" + s);
                } else {
                    column.add(s);
                }
            }
            TVShows tvShow = new TVShows(
                    column.get(0), column.get(1), column.get(2)
            );
            tvShows.add(tvShow);
        }
        return tvShows;
    }
}
