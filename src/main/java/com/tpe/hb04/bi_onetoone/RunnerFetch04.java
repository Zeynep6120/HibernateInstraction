package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:1001 olan öğrenciyi getirelim
        Student04 student=session.get(Student04.class,1001);
        System.out.println(student);

        //id:11 olan günlüğü getirelim
        Diary04 diary=session.get(Diary04.class,11);
        System.out.println(diary);

        //günlüğün sahibi kimdir?
        System.out.println(diary.getStudent());

        //öğrencinin günlüğü hangisidir?
        System.out.println(student.getDiary());

        //bi_directional : student <--> diary

        // !!! Task 1: Günlüğü olan öğrenci ve sahibi olan günlüklerin
        //student name ve diary name fieldlarını getirelim.
        String hql="SELECT s.name,d.name FROM Student04 s INNER JOIN Diary04 d ON s.id=d.student"; //d.student.id

        List<Object[]> resultList=session.createQuery(hql).getResultList();
        for(Object[] oa:resultList){
            System.out.println(Arrays.toString(oa));
        }

        // !!! Task 2: Tüm öğrencilerin
        //student name ve varsa diary name fieldlarını getirelim.
        System.out.println("--------------------------------------------------------------");
        String hql2="SELECT s.name,d.name FROM Student04 s LEFT JOIN Diary04 d ON s.id=d.student"; //d.student.id
        String hql3="SELECT s.name,d.name FROM  Diary04 d RIGHT JOIN Student04 s ON s.id=d.student"; //d.student.id
        List<Object[]> resultList2=session.createQuery(hql2).getResultList();
        for (Object[] oa:resultList2){
            System.out.println(Arrays.toString(oa));
        }


        // Task 3 : Butun gunlukler ve varsa gunlugun sahibi olan ogrenciler gelsin
        System.out.println("--------------------------------------------------------------");
        String hql4="SELECT s.name,d.name FROM Student04 s RIGHT JOIN Diary04 d ON s.id=d.student"; //d.student.id
        List<Object[]> resultList3=session.createQuery(hql4).getResultList();
        for (Object[] oa:resultList3){
            System.out.println(Arrays.toString(oa));
        }

        // Task 4 : tüm günlük ve öğrencilerin isimlerini getirelim.
        System.out.println("--------------------------------------------------------------");
        String hql5="SELECT s.name,d.name FROM Student04 s FULL JOIN Diary04 d ON s.id=d.student"; //d.student.id
        List<Object[]> resultList5=session.createQuery(hql5).getResultList();
        for (Object[] oa:resultList5){
            System.out.println(Arrays.toString(oa));
        }
    }
}
