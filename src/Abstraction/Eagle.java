package Abstraction;

public class Eagle extends Bird{
    Eagle(){
        super(180);
    }

    @Override
    public void fly(){
        System.out.println("Орёл летит со скоростью: " + this.getFlySpeed() + " км/ч");
    }

    @Override
    public void makeSound(){
        System.out.println("Орёл издаёт трель с неба");
    }
}
