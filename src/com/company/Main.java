package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // citirea din fisier
           List<String> lines = Files.readAllLines(Paths.get("Texts.txt"));

            System.out.println(lines);

            System.out.println("first line ->" + lines.get(0));

            // scriere in fisier
            Files.write(Paths.get("outputdata.txt"), lines);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
