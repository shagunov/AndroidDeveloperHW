package Enum_;

public class Person {
    public enum Gender{
        MALE("Male"),
        FEMALE("Female");

        final private String type;

        Gender(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }
    }

    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
