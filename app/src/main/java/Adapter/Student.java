package Adapter;

public class Student {
    private String name;
    private String age;
    private int image;
    private String des;
    public Student() {
    }

    public Student(String age, String name, int image,String des) {
        this.age = age;
        this.name = name;
        this.image = image;
        this.des=des;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public String getAge() {
        return age;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}
