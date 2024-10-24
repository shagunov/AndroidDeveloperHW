package NestedInner;

public class Car {
    private String carBrand;
    private int speed = 0;
    private int weight;

    public Car(String carBrand, int weight) {
        this.carBrand = carBrand;
        this.weight = weight;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                '}';
    }

    public void run(){
        Engine engine = new Engine();
        Door door = new Door();
        Wheel wheel = new Wheel();

        door.open();
        door.close();

        engine.isRunning();
        for(int i = 0; i <= 10; ++i){
            engine.accelerate();
        }
    }

    public void stop(){
        System.out.println("\nТорможение");
        Engine engine = new Engine();
        Door door = new Door();
        Wheel wheel = new Wheel();
        engine.stop();
        wheel.stop();
        door.open();
        door.close();
    }

    private class Engine{
        boolean isActive;

        public void stop(){
            System.out.println("\nДвигатель остановился");
        }

        public void accelerate(){
            System.out.println("\nРазгон");
            isRunning();
            speed += 10;
            System.out.println("Автомобиль ускорился до: " + speed);
        }

        public void isRunning(){
            System.out.println(" ");
            class Piston{
                private int stat = 0;
                void move(){
                    if(stat < 3){ stat++; } else { stat = 0; }
                    switch(stat){
                        case 0:
                            System.out.println("Поршень движется вверх");
                            break;
                        case 1:
                            System.out.println("Поршень достиг верха");
                            break;
                        case 2:
                            System.out.println("Поршень движется вниз");
                            break;
                        case 3:
                            System.out.println("Поршень достиг низа");
                            break;
                        default:
                            System.out.println("Неправильное состояние");
                            break;
                    }
                }
            };

            class Belt{
                void rotate(){
                    System.out.println("Ремень привода вращается");
                }
            };

            Piston piston = new Piston();
            Belt belt = new Belt();

            for(int i = 0; i < 4; ++i){
                piston.move();
                belt.rotate();
            }

        }
    };
    private class Door{
        void open(){
            System.out.println("Дверь открывается");
        }

        void close(){
            System.out.println("Дверь закрывается");
        }

    };
    private class Wheel{
        void rotate(){
            System.out.println("Колесо вращается");
        }

        void stop(){
            System.out.println("Колесо больше не вращается");
        }
    };
}
