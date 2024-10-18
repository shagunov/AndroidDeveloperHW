package Interfaces;

public class Fish implements Swimmable{
    private int age;
    private String name;
    public void swim(){
        System.out.println("Рыба по имени " + name + " плавает в реке");
    }
}
