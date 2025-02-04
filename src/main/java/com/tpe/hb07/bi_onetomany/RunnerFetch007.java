package com.tpe.hb07.bi_onetomany;

import com.tpe.hb06.onetomany.Book;
import com.tpe.hb06.onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration config=new Configuration().configure().
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);
        SessionFactory sf=config.buildSessionFactory();
        Session session =sf.openSession();
        Transaction transaction=session.beginTransaction();


        // !!! Kitab bilgisi(ilişkisi) olan bir ogrenciyi silmek istersek
        // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir daha sonra istenen student objesi silinebilir
        // 2.yol ) Cascade:CascadeType.REMOVE / orphanRemoval


        //id:1002 olan öğrenciyi silelim:Cascade:CascadeType.REMOVE / orphanRemoval aynı
//        Student07 student=session.get(Student07.class,1002);
//        session.delete(student);

        //id:1001 olan öğrencinin kitap listesinden ilkini silelim
        Student07 student2=session.get(Student07.class,1001);
        student2.getBookList().remove(0);//1001: 101,102-->102
        student2.getBookList().set(0,null);//1001: 102-->null
        //collectiondan bir eleman silinir veya null yapılırsa
        // referansı olmayan bu nesneyi tablodan da siler

        //1-std-book-->std kitabı iade etti-->listeden kaldırdık-->tablodan silmemeliyiz-orphanRemoval:false
        //2-müşteri-sipariş-->sipariş listesi(1,2,3)
        //                 -->siparişi iptal(1)-->sipariş listesi(2,3)
        //müşterinin oluşturduğu siparişi tabloda tutmaya gerek var mı--orphanRemoval:true



        transaction.commit();
        session.close();
        sf.close();
    }
}
