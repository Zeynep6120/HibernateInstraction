package com.tpe.hb01.basicannotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity

public class Employee {

    @Id
    private Long id;

    private String name;

    private Double salary;//50$

    @Transient//DB de bu field e karşılık bir sütun oluşmasını engeller
    //ben bu fielde uygulamamda kullanıcam fakat tabloya kaydetmemiş oldu bu anatasyon sayesinde
    //eğer ben her hangi bir anatosyan kullanmasam.entity anatasyonu ile class daki tüm fieldere karşılık
    //DB de tabloda bir sütun oluşucak
    private Double bonus;//50
    //bonusun tabloda yer almasına gerek yok.

    //@Lob //Large Object: bu sütunda büyük boyutlu datalar saklanır:resim,video,ses...
  //  private byte[] image;
    //employee lerin fotolarını tabloda saklamak istiyourm.foto,resim görsel image video gibi büyük 7
    //boyuttaki medya datalarını biz  byte arrayler olarak tutarız yani büyük boyuttaki dataları
    //byte arraylere dönüştürerek saklarız.byte array data tipindeki bir veryiy data yı biz
    //data base deki sütunlarda b-lob data tipinde tutarız.
    //getter-setter

    //bu lob çok tercih edilmez data base de memory kapladığı için onun yerine belli serverlarda büyük
    //veriler tutulur DB de bunların referansı yani adresi,path i  string olarak tutulur.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}
