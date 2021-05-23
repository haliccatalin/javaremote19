package com.company.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String name = null;
//        if(name == null) {
//            System.out.println("name is null");
//        } else {
//            System.out.println("name is ok");
//        }

        Optional<String> checkString = Optional.ofNullable(name);
        // daca name este null seteaza valoare "catalin", daca nu, pastreaza valoarea initiala
        name = checkString.orElse("catalin");

        // verifica daca este null sau nu
        if(checkString.isPresent()) {
            System.out.println("is not null");
        } else {
            System.out.println("is null");
        }

        System.out.println(name);
    }
}
