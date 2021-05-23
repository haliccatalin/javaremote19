package com.company.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Ion");
        nameList.add("Mihai");
        nameList.add("Mircea");
        nameList.add("Dan");

        System.out.println("Without stream");
        for(String name : nameList) {
            System.out.println(name.length());
        }

        System.out.println("With stream ");
        nameList.stream()
                .map((String name) -> name.toUpperCase()) // map. ne ajuta sa modificam un element
                .forEach((item) -> System.out.println(item)); // forEach. ne permite sa il afisam

        System.out.println("Using Filter");
        nameList.stream()
                .filter((String name) -> name.startsWith("M")) // map. ne ajuta sa modificam un element
                .forEach((item) -> System.out.println(item)); // forEach. ne permite sa il afisam

        System.out.println("Using Filter and Map");
        nameList.stream()
                .filter((name) -> name.startsWith("M"))
                .map((name) -> name.toUpperCase())
                .forEach((item) -> System.out.println(item));

        List<String> newNames = nameList.stream()
                .filter((name) -> name.startsWith("M"))
                .map((name) -> name.toUpperCase())
                .collect(Collectors.toList()); // transforma rezultatele din stream inapoi in lista

        System.out.println("old list: " + nameList.size());
        System.out.println("new list: " + newNames.size());

        System.out.println("Stream reduce");
        String namesConcatenation = nameList.stream()
                // identity: "" - reprezinta valoarea initiala a strinului
                .reduce("",             // daca stringul curent este gol, atunci adauga un nou element, daca nu atunci adauga ", " si apoi noul element
                        (currValue, element) -> (currValue.equals("") ? "" : currValue + ", ") + element);
        System.out.println(namesConcatenation);
    }
}
