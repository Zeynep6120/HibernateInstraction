package com.tpe.hb03.uni_onetoone;

import com.tpe.hb03.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();

        //id:1001 olan öğrenciyi getirelim
        Student03 student=session.get(Student03.class,1001);

        //id:11 olan günlüğü getirelim
        Diary diary=session.get(Diary.class,11);
        //diary de id,name,student fielderi var ben sessionun get metdhodunu kullandıpım zaman tablonun
        //bir satırındaki tüm sütunları isteriz .student sütununu  foreign key sütunundaki bilgiyi kullanarak
        //bana studentin bilgilerini de getirmiş oldu


        System.out.println("*************************************");
        System.out.println(student);
        System.out.println("*************************************");
        System.out.println(diary);
        System.out.println("*************************************");

       //günlük kime ait
        //bena diary tablomu getirirken öğrenci bilgilerimi de getirdiği için tekrar data base gitmeme gerek kalmadı
        //direkt get methodu ile çağırabilir
        System.out.println(diary.getStudent());//tekrar data base e gitmeye gerek yok zaten yanında öğrenciyi de
        //getirdi.bizim join işlemini de yapmaya gerek yok otomatikmen join işlemini de yapıp bize öğrenciyi de
        //yanında getirdi.

        //id:1002 olan öğrencinin günlüğü hangisidir
        Student03 student2=session.get(Student03.class,1002);
        //student2.getDiary() -->java kodları ile ulaşamıyoruz fakat DB den ulaşabilirim
        String diaryname= (String) session.createSQLQuery("SELECT name FROM diary WHERE std_id=1002").uniqueResult();

        //PROBLEM: sorgu yazmadan diaryden studenta , studentdan diarye ulaşmak istersem?
        //PROBLEM: sorgu yazmadan diaryden studenta , studentdan diarye ulaşmak istersem?
        //uni_directional(tek yönlü) : Diary  -> Student
        //bi_directional (çift yönlü) : Diary <-> Student(veritabanında birşey değişmez)



        session.close();
        sf.close();
    }
}
