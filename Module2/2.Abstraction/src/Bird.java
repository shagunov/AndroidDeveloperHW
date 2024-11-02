public abstract class Bird {
    private int flySpeed;

    protected Bird(int flySpeed){
        this.flySpeed = flySpeed;
    }

    public abstract void fly();

    public abstract void makeSound();

    public int getFlySpeed() {
        return flySpeed;
    }
}
