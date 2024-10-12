package ClassMembersConstructorsMethods;

public class ClassMembersConstructorsMethods {
    public static void main(String[] args){
        Calculator calculator = new Calculator();

        calculator.a = 6;
        calculator.b = 9;

        System.out.println(calculator.sum());
        System.out.println(calculator.sub());

        calculator.mul();
        calculator.div();
    }
}
