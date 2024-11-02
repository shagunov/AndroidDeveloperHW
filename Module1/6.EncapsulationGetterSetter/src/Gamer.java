public class Gamer {
    // TODO решение 1-го задания. Создание класса игрока
    private String nickname;
    private boolean isActive;

    @Override
    public String toString() {
        return "Игрок: " + nickname + " " + (isActive() ? "активен" : "не активен");
    }

    Gamer(String nickname, boolean isActive){
        this.nickname = nickname;
        this.isActive = isActive;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
