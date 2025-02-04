package com.tpe.hb01.basicannotations;
//uygulamaya veritabanından data çekme


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static <Stdudent> void main(String[] args) {
        /*
        DB den data çekmek için:fetch işlemlerinde transactiona gerek yoktur
          Task:id=1001 olan öğrenciyi tüm fieldlarıyla getirmek(fetch) istiyoruz.
         */
     /*
        1) sessionın metodu:get():en pratik ama kullanım alanı kısıtlı
        2) SQL : DB ce
        3) HQL(Hibernate Query Language): Javaca

        HQL (Hibernate Query Language), Hibernate ORM tarafından sağlanan,
                nesne odaklı bir sorgulama dilidir. HQL, SQL'e benzer şekilde çalışır
        ancak doğrudan veritabanı tablolarıyla değil,
                Java sınıfları (entity'ler) ve onların özellikleriyle çalışır*/
        /*fetch işlemlerinde transactiona gerek yoktur.data da değişiklik yapmıyoruz .sadece datayı
                görüntülüyoruz.fakat insert delete update yapıyorsak transaction oluşturmak zorundayız*/

        Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf= config.buildSessionFactory();
        Session session=sf.openSession();

    //get
        //hibernate bir data base deki tabloda bir satırın bir sütudunt objesine denk geldiğini biliyor
        //bu yüzden ben session in get methodu ile id kullanarak veri çağırdığımda bana obje döndürür
        Student student=  session.get(Student.class,1001);
        System.out.println("-------------------------GET METHODU-----------------------------------");
        System.out.println(student);

    //SQL
    String  sql="SELECT * FROM t_student WHERE id=1002 ";
      Object[] student2= (Object[]) session.createSQLQuery(sql).uniqueResult();
       //eğer sorgumuz sonucunda tek satır geliceğini biliyorsak uniqueResult() methdounu kullanırız
        //bu method geriye döndürdüğümüz sütunları arrayın içine atıp bize bir array döndürür

        //uniqueResult():sorgunun tek satır getireceğini biliyorsak kullanılır
        //geriye bir saturdan birden fazla data geldiği için data tipleri farklı
        //old için Object[] içine alınır.
        System.out.println("-------------------------SQL-----------------------------------");
        System.out.println(Arrays.toString(student2));


        //HQL:Javaca:daha aşinayız
        //sql komutlarını javaca konuşarak kullanmak demek.
        String hql="FROM Student WHERE id=1003";
        Student student3=session.createQuery(hql, Student.class).uniqueResult();
        //uniqueResult():sorgunun tek satır getireceğini biliyorsak kullanılır
        System.out.println("-------------------------HQL-----------------------------------");
        System.out.println(student3);


        //tüm kayıtları çekelim
        //hql ile
        //getResultList birden fazla kayıt geleceği zaman kullanılır
        List<Student> studentList=session.createQuery("FROM Student", Student.class).getResultList();
        //getResultList birden fazla kayıt geleceği zaman kullanılır
        System.out.println("Tüm öğrenciler");
        for (Student s:studentList){
            System.out.println(s);
        }

        //sql ile tüm kayıtları çekelim:exercise
        System.out.println("------------------------SQL-----------------------------------");
        String sql2=" SELECT * FROM t_student ";
        List<Object[]>result=session.createSQLQuery(sql2).getResultList();
        for(Object[] objects:result){
            System.out.println(Arrays.toString(objects));
        }






        // HQL ile grade degeri 98 olan ogrencilerin id ve name bilgilerini getirelim
        String hql2="SELECT s.id,s.name FROM Student s WHERE s.grade=98";
        List<Object[]> resultList=session.createQuery(hql2).getResultList();
        for (Object[] oa:resultList){
            System.out.println(Arrays.toString(oa));
        }
        //practice:HQL ile
        //1-ismi Harry Potter olan öğrencileri getirelim
        String hql3=" SELECT s FROM Student s WHERE s.name='Harry Potter'";
        List<Student>resultList2=session.createQuery(hql3, Student.class).getResultList();
        for(Student s:resultList2){
            System.out.println(s);
        }

        //2-tüm öğrencilerin sadece isimlerini getirelim
        String hql4 ="SELECT name FROM Student ";
        List<String>resultList3=session.createQuery(hql4,String.class).getResultList();
        for(String s:resultList3){
            System.out.println(s);
        }

        //SQL ile
        //1-tüm öğrencilerin sadece isimlerini getirelim
        String sql3=" SELECT student_name FROM t_student";
        List<String>isimler=session.createSQLQuery(sql3).getResultList();
        for(String s:isimler){
            System.out.println(s);
        }
        session.close();
        sf.close();

    }
}
