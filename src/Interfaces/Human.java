package Interfaces;

public class Human implements Flyable, Swimmable{
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void fly(){
        System.out.println("Человек летает в самолёте");
    }

    public void swim(){
        System.out.println("Человек плывёт на корабле");
    }
}
