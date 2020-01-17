package model;
// Generated Jan 13, 2020 1:30:55 PM by Hibernate Tools 4.3.1


public class Employees  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String address;
     private int age;
     private String conNumber;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getConNumber() {
        return conNumber;
    }

    public void setConNumber(String conNumber) {
        this.conNumber = conNumber;
    }

//    @Override
//    public String toString() {
//        return "Employees{" + "id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", conNumber=" + conNumber + '}';
//    }

    

}


