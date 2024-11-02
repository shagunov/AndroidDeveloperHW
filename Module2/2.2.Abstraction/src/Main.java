public class Main {
    public static void main(String[] args){
        Bird eagle = new Eagle();

        eagle.fly();
        eagle.makeSound();
        System.out.println(" ");

        Bird hawk = new Hawk();

        hawk.fly();
        hawk.makeSound();
        System.out.println(" ");

        Instrument guitar = new Guitar();

        guitar.tune();
        guitar.play();
        System.out.println(" ");

        Instrument piano = new Piano();

        piano.tune();
        piano.play();
        System.out.println(" ");
    }
}
