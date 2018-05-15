package models;

public class Child {

    private int id;
    private String name;
    private int age;
    private String range;

    public Child() {
    }

    public Child(String name, int age, String range) {
        this.name = name;
        this.age = age;
        this.range = range;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
