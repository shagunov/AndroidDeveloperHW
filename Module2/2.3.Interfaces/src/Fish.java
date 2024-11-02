public class Fish implements Swimmable{
    private int age;
    private String name;
    public void swim(){
        System.out.println("Рыба по имени " + name + " плавает в реке");
    }

    public Fish(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
