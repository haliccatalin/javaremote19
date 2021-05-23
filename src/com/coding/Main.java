package com.coding;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static List<Student> students = new ArrayList<>();
    private static List<Trainer> trainers = new ArrayList<>();
    private static List<Grup> grups = new ArrayList<>();


    public static void main(String[] args) {


        Student student1 = new Student("Adrian","Postasu",new Date(1981,11,1),true);
        Student student2 = new Student("Alina","Ciuca",new Date(1982,11,1),true);
        Student student3 = new Student("Ciprian","Boanta",new Date(1986,11,1),true);
        Student student4 = new Student("Loredana","Burzo",new Date(1983,11,1),true);
        Student student5 = new Student("Claudiu","Cojocar",new Date(1989,11,1),true);
        Student student6 = new Student("Cristi","Tarta",new Date(1986,11,1),true);
        Student student7 = new Student("Diana","Doroi",new Date(1982,11,1),true);
        Student student8 = new Student("Leo","Hanet",new Date(1985,11,1),true);
        Student student9 = new Student("Marcel","Stancu",new Date(1989,11,1),true);
        Student student10 = new Student("Adrian","Nagy",new Date(1987,11,1),true);
        Student student11 = new Student("Sebastian","Radea",new Date(1984,11,1),true);
        Student student12 = new Student("Radu","Rus",new Date(1980,11,1),true);
        Student student13 = new Student("Simona","Munteanu",new Date(1982,11,1),true);
        Student student14 = new Student("Adrian","Strisca",new Date(1985,11,1),true);
        Student student15 = new Student("Robert","Stroe",new Date(1988,11,1),true);
        Student student16 = new Student("Paul","Marian",new Date(1998,11,1),true);

        Trainer trainer1 = new Trainer("Catalin","Halic",new Date(1994,11,0),true);
        Trainer trainer2 = new Trainer("Bogdan","Niculae",new Date(1994,11,0),true);
        Trainer trainer3 = new Trainer("Alina","Noge",new Date(1994,11,0),false);


        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student2);
        studentList1.add(student3);
        studentList1.add(student4);

        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(student5);
        studentList2.add(student6);
        studentList2.add(student7);
        studentList2.add(student8);

        List<Student> studentList3 = new ArrayList<>();
        studentList3.add(student9);
        studentList3.add(student10);
        studentList3.add(student11);
        studentList3.add(student12);

        List<Student> studentList4 = new ArrayList<>();
        studentList4.add(student13);
        studentList4.add(student14);
        studentList4.add(student15);
        studentList4.add(student16);





        Grup grup1 = new Grup("grup1",trainer1,studentList1);
        Grup grup2 = new Grup("grup2",trainer2,studentList2);
        Grup grup3 = new Grup("grup3",trainer1,studentList3);
        Grup grup4 = new Grup("grup4",trainer3,studentList4);

        grups.add(grup1);
        grups.add(grup2);
        grups.add(grup3);
        grups.add(grup4);

        for (Grup g:grups) {
            Trainer grupTrainer = g.getTrainer();
            trainers.add(grupTrainer);
            students.addAll(g.getStudentList());
            g.displayStudentsAlphabetically();
            if (g.isFull()){
                System.out.println(g.getName());
            }
        }

        System.out.println("Students under 25");
        for (Student s:students) {
            LocalDateTime currentDate = LocalDateTime.now();
            Date birthOfDate = s.getDateOfBirth();
            if ((currentDate.getYear()-birthOfDate.getYear())<25){
                System.out.println(s);
            }
        }



    }


}
