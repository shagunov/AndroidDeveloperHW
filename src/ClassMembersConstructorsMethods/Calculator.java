package ClassMembersConstructorsMethods;

public class Calculator {
    int a;
    int b;

    int sum(){
        return a + b;
    }

    int sub(){
        return a - b;
    }

    void mul(){
        System.out.println(a * b);
    }

    void div(){
        if( b != 0){
            System.out.println(a / b);
        } else {
            System.out.println("Делить на ноль нельзя");
        }
    }
}
