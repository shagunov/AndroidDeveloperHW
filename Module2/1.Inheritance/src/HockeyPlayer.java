public class HockeyPlayer extends Sportsman{
    private int hitedPucksCount;

    public HockeyPlayer(String name, int age, String team) {
        super(name, age, team);
        hitedPucksCount = 0;
    }

    public int getHitedPucksCount() {
        return hitedPucksCount;
    }

    public void hitPuck(){
        ++hitedPucksCount;
        System.out.println("Игрок " + this.getName() +
            " из команды " + this.getTeam() +
            " отбил " + hitedPucksCount + " шайбу!!!");
    }

    @Override
    public String toString() {
        return "Хоккеист " + this.getName() +
                ". Команда " + this.getTeam() +
                ". Возраст " + this.getAge() +
                ". Отбито " + hitedPucksCount + " шайб." +
                " У игрока" + this.getWinCount() + " побед";
    }
}
