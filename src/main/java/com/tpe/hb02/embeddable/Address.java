package com.tpe.hb02.embeddable;

import javax.persistence.Embeddable;
/**@Embeddable Anotasyonu
 @Embeddable, gömülü bir bileşen sınıfını tanımlamak için kullanılır.
 Bu sınıf bir entity değildir; yalnızca bir entity'nin bir parçası olarak kullanılır.
 @Embeddable sınıfı bağımsız bir tablo oluşturmaz.
 Veritabanında, bu sınıfın alanları ana entity'nin
 alanlarıyla aynı tabloya eklenir.

 @Embedded Anotasyonu
 @Embedded, bir entity içinde @Embeddable sınıfın kullanılacağını belirtir.
 Entity, @Embedded sınıfın özelliklerini kendi özellikleri gibi kabul eder
 ve veritabanı tablosunda bunları ayrı sütunlar olarak saklar.

 Kullanım Senaryoları:
 Bir entity'deki adres, iletişim bilgileri vb.
 gibi bir grup alanı(field) düzenli bir şekilde modellemek için uygundur. */

@Embeddable//gömülebilir
//böyle yapınca address classı bir tablo değil address classına karşılık bir tablo oluşmucak.fakat addres class
//içindeki fielder 4 tane fieldem var bunlar student classındak address fieldena karşılık 4 tane field sütun olakar
//student tablosuna eklenecek.yani sanki student classında street,city,county,zipcode gibi 4 tane ayrı sütun
//varmış gibi olucak
//ben bu class taki fieldleri sütun olark oluşturup student tablosuna gömmek istiyorum
public class Address {
    /*Adress classım bir ettiydi değil sadece içindeki fieldlar embeddable anatasyonu ile student tabloma gönülecek*/
    private String street;
    private String city;
    private String country;
    private String zipcode;

    //parametreli constuctor
    public Address(){
        /*biz parametresiz constructor kullanmasak da hibernate verileri fetch ederken ihtiyac duyup kullanıyor
        * eğer oluşturmazsak bize kızıp hata veriyor*/
    }

    public Address(String street, String city, String country, String zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    //getter-setter

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    //toString

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
