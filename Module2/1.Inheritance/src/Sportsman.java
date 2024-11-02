public class Sportsman {
    private String name;
    private String team;
    private int age;
    private int winCount;

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getAge() {
        return age;
    }

    public int getWinCount() {
        return winCount;
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
        ++winCount;
        System.out.println("Спортсмен победил уже " + winCount + " раз");
    }
}
