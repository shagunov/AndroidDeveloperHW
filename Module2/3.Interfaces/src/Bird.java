public class Bird implements Flyable{
    private String name;
    private int age;

    public void fly(){
        System.out.println("Птица летит в небе. ");
    }

    public Bird(String name, int age) {
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
