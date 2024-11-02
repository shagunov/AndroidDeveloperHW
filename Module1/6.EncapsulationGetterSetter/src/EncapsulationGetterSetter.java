public class EncapsulationGetterSetter {
    public static void main(String[] args){

        // TODO решение 2-го задания
        Gamer[] gamers = new Gamer[]{
                new Gamer("Anna", false),
                new Gamer("Vlad", true),
                new Gamer("Kyrill", false),
                new Gamer("Kristian", true),
                new Gamer("Marina", false),
                new Gamer("Sergey", true)
        };

        for(Gamer gamer : gamers){
            System.out.println(gamer);
        }

        // TODO решение 3-го зодания
        System.out.print("\nАктивные игроки: [");
        for (Gamer gamer : gamers){
            if(gamer.isActive()){
                System.out.print(gamer.getNickname() + ", ");
            }
        }
        System.out.println("\b\b]");

    }
}
