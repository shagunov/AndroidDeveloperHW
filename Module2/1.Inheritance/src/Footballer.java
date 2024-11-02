public class Footballer extends Sportsman{

    private int goalsScore;

    public Footballer(String name, int age, String team) {
        super(name, age, team);
        goalsScore = 0;
    }

    public int getGoalsScore() {
        return goalsScore;
    }

    public void scoredGoals(){
        ++goalsScore;
        System.out.println("Спортсмен " + this.getName() +
                " из команды " + this.getTeam() +
                " забивает уже " + goalsScore + " гол!!!");
    }

    @Override
    public String toString() {
        return "Футболист " + this.getName() +
                ". Команда " + this.getTeam() +
                ". Возраст " + this.getAge() +
                ". Забито " + goalsScore + " голов." +
                " У игрока" + this.getWinCount() + " побед";
    }
}
