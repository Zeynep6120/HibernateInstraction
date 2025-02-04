package com.tpe.hb01.basicannotations;

//hedef:
//dataları persist etmek için bu classa karşılık bir tablo gerekli
//tablonun sütunları:id,name,grade
//create table student(id int, name varchar...)
//hibernate(ORM) bizim için bu hedefi otomatik olarak yapar.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, tablonun adı: student

@Entity //bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, tablonun adı: student

//entity annatasyonunu kullanıcam .entity varlık demek yani kalıcı hale getirdiğimiz nesne demek.
//entity anatasyonu bir dip nottur.bu dip not ile dmek istediğim bu class a karşılık bir tablo oluşturdur.
//entity anatasyonun kullandığım andan itibaren hibernate tarafından student classına karşılık aynı isimde fakat
//tablo ismleri küçük harf ile başlar student adında bir tablo otomatik oluşturur.
//entity yi yazdıpımız anda class ta yazdığımız fielderin isimleri ile aynı isimde sütunlar otomatik oluşturulur.
@Table(name="t_student")
/*  class seviyesinde bir anatasyondur name attribute ile tabloların isimlerini bizim berlirlememizi sağlar*/



/////!!! Javaca konuşurken bu sınıfı belirtirken Student,
////SQLce konuşurken t_student kullanırız.
//java ca konuşurken class ismini sql ce konuşurken tablo ismini kullanıcaz.
public class Student {
    //bu classın içinde elde ettiğimiz verileri kalıcı hale getirmek istiyoruz. yani persest etmek istiyoruz.

    @Id//id sütununa PK  kısıtlamasının eklenmesini sağlar
    //yani artık id miz null olmaz ve unique olmak zorunda.yani biz id sütunun başka bir sütun ile ilişkilendirmek için
    //kullancam demek.bir etity oluşturuğumuzda bu entity ni başka bir tablo ile ilişkilendirme ihtimaline karşı
    //hibernate bize id anatasyonunu zorunlu kılar.
    /*id anatasyonu ne yapar. eper bu tablo ilişkisel bir veri tabanında oluşturulacaksa.yani eğer bu tablo başka
    * bir tablo ile ilişkilendirilecekse bu durumda primary key sütununa ihtiyacımız var.primary key sütunun
    * Id anatasyonu oluşturur .bu anatasyonu hangi fielden üzerine koyduysak o primary key olur*/

     //@Column(name="std_id")
    //column anatayonu ile sütun isimlerini değiştirebiliyoruz.
    private Integer id;

    @Column(name="student_name",nullable = false,unique = true,length=50)//    default :: varchar(255)
    // eğer isim sütunumuz not null olsun yani null değer alasın isiyorsakk column anatosyonunun nullable özelliğini
    //false yapabiliyoruz.
    //sütunlarımızın unique özelliği default olarak false dur yani sütunlarımız unique olmak zournda değildir.
    //eğer unique olsun istersek true yapabiliriz
    //varchar ın size in belirtmek hem de bir kısılamak olarak eklemek istediğmiz için length ekledik eğer bunu
    //eklemezsek varcharın default değeri yani 250 kullanılır.
    private String name;
    private int grade;

    //getter-setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
