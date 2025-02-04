package com.tpe.hb02.embeddable;

import javax.persistence.*;


@Entity
@Table(name="t_student02")
public class Student02 {

    @Id//id sütununa PK kısıtlamasının eklenmesini sağlar
    //@Column(name = "std_id")
    private Integer id;

    @Column(name = "student_name",nullable = false,unique = true,length = 50)//default : varchar(255)
    private String name;//not null
    private int grade;

//    private String street;
//    private String city;
//    private String country;
//    private String zipcode;
    //ben bu 4 tane fielde address objesinde birleştirdim yani code mu daha clean yaptım ve.bu fieldların
    //sütunlarını address objesi içine gömmüş oldum ve yukardaki kalabalık yok olmuş oldu

    @Embedded//OPSİYONEL .bunu yazmasak da olur.
    //gömülü
    private Address address;
    /*addresi bilgilerini tek tek almak yerine kapsül olarak obje olarak almış olduk*/

    /*ben parametreli contructor kullanmıcam neden oluşturdum.hibernate in sesion objesinin get methodu var
   * bu method primary key sütununda vermiş olduğumuz bir değer ile bir satırı filtreleyip bize getiriyorü
   * tam olarak bir student objesi olarak getiriyor
   * hiber nate başta get methodu ile parametresi constructor kullanrak bir student objesi oluşturuyor
   * sonra get methodu ile gelen verileri set methodları ile set ederek objeye yerleştiriyor.yani her nekadar
   * bizim parametresiz constructora ihtiyacımız olmasa da hibernate fetch işlemleri nde default consturctorı kullanır*/


    //paramsiz const:hibernate fetch işlemlerinde default const kullanır.
    //parametresiz consturctor
    public Student02() {
    }

    //parmatereli constructor
    public Student02(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter-setter

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
