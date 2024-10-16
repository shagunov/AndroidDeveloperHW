package Inheritance;

public class Sportsman {
    private String name;
    private String team;
    private int age;

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Спортсмен " + name +
                " играет в команде " + team +
                ". Возраст спортсмена " + age + "лет";
    }

    public Sportsman(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public void win(){
        System.out.println("Спортсмен победил");
    }
}
