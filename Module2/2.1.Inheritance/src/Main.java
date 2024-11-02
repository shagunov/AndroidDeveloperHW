public class Main {
    public static void main(String[] args){
        // TODO задание 3
        // Лыжники
        Skier skier = new Skier("Алексей", 32, "Уральцы");
        Skier skier1 = new Skier("Евгений", 25, "Снежники");

        skier.advanceWay();
        skier1.advanceWay();

        skier1.advanceWay();
        skier1.win();

        System.out.println(" ");
        System.out.println(skier);
        System.out.println(skier1);
        System.out.println(" ");

        // Футболисты
        Footballer footballer = new Footballer("Юрий", 21, "Молодцы");
        Footballer footballer1 = new Footballer("Михаил", 23, "Спартанцы");

        footballer1.scoredGoals();
        footballer.scoredGoals();
        footballer.scoredGoals();
        footballer.win();

        System.out.println(" ");
        System.out.println(footballer1);
        System.out.println(footballer);
        System.out.println(" ");

        // Хоккеисты
        HockeyPlayer hockeyPlayer = new HockeyPlayer("Марина", 19, "Орлицы");
        HockeyPlayer hockeyPlayer1 = new HockeyPlayer("Алёна", 18, "Амазонки");

        hockeyPlayer1.hitPuck();
        hockeyPlayer1.hitPuck();
        hockeyPlayer.hitPuck();

        hockeyPlayer1.win();

        System.out.println(" ");
        System.out.println(hockeyPlayer1);
        System.out.println(hockeyPlayer);
    }
}
