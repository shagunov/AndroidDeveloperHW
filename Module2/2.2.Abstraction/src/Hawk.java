public class Hawk extends Bird{
    Hawk(){
        super(120);
    }

    @Override
    public void fly(){
        System.out.println("Ястреб летит со скоростью " + this.getFlySpeed() + " км/ч");
    }

    @Override
    public void makeSound(){
        System.out.println("Ястреб издаёт негромкий свист");
    }
}
