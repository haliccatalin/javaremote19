package com.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grup {
    private String name;
    private Trainer trainer;
    private List<Student> studentList = new ArrayList<>();

    public Grup(String name, Trainer trainer, List<Student> studentList) {
        this.name = name;
        this.trainer = trainer;
        this.addStudents(studentList);
    }

    private void addStudents(List<Student> studentList){
        for (Student s:studentList) {
            if (this.studentList.contains(s)){
                System.out.println("Already here");
            }else {
                if (this.studentList.size()<=4) {
                    this.studentList.add(s);
                }else {
                    try {
                        throw new MaximumNumberOfStudentsReached("The grup is full");
                    } catch (MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
                        String error = maximumNumberOfStudentsReached.getMessage();
                        System.err.println("Error " + error );
                    }
                }
            }
        }
    }

    public void  displayStudentsAlphabetically(){
        studentList.stream()
                   .sorted( (s1,s2) -> s1.getLastName().toLowerCase().compareTo(s2.getLastName().toLowerCase()))
                   .forEach( (student)-> System.out.println(student.toString()) );
    }

    public boolean isFull(){
//        if (studentList.size()==5){
//            return true;
//        }
//        return false;
        return studentList.size()==5;
    };

    public Trainer getTrainer() {
        return trainer;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getName() {
        return name;
    }
}
