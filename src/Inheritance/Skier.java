package Inheritance;

public class Skier extends Sportsman{
    private int completeDistance;

    public Skier(String name, int age, String team) {
        super(name, age, team);
        completeDistance = 0;
    }

    public int getCompleteDistance() {
        return completeDistance;
    }

    public void advanceWay(){
        completeDistance += 536;
        System.out.println("Игрок " + this.getName() +
                " из команды " + this.getTeam() +
                " прошёл уже " + completeDistance + " метров дистанции!!!");
    }

    @Override
    public String toString() {
        return "Лыжник " + this.getName() +
                ". Команда " + this.getTeam() +
                ". Возраст " + this.getAge() +
                ". Пройдено " + completeDistance + " метров дистанции." +
                " У игрока" + this.getWinCount() + " побед";
    }
}
