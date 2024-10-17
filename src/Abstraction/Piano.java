package Abstraction;

public class Piano extends Instrument {
    @Override
    public void tune(){
        System.out.println("Настройка пианино");
    }

    @Override
    public void play(){
        System.out.println("Играем на пианино");
    }
}
