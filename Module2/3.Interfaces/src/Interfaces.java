public class Interfaces {
    public static void main(String[] args){
        Flyable human = new Human(20, "Alex");
        Flyable bird = new Bird("Eagle", 32);

        Swimmable human1 = new Human(30, "George");
        Swimmable fish = new Fish("Fish", 32);

        human.fly();
        human1.swim();

        bird.fly();
        fish.swim();
    }
}
