public class Main {
    public static void main(String[] args){

        Printable englishPrint = new Printable() {
            @Override
            public void print() {
                System.out.println("Hello, world!!!");
            }
        };

        Printable russianPrint = new Printable() {
            @Override
            public void print() {
                System.out.println("Привет, мир!!!");
            }
        };

        russianPrint.print();
        englishPrint.print();

        Concationble concatDot = new Concationble() {
            @Override
            public String concat(String lhs, String rhs) {
                return lhs + "." + rhs;
            }
        };

        Concationble concatSpace = new Concationble() {
            @Override
            public String concat(String lhs, String rhs) {
                return lhs + " " + rhs;
            }
        };

        System.out.println("\nConcat Space: " + concatSpace.concat("Sheggy", "Aggy"));
        System.out.println("Concat Dot: " + concatDot.concat("Sheggy", "Aggy"));


    }
}

@FunctionalInterface
interface Printable{
    void print();
}

@FunctionalInterface
interface Concationble{
    String concat(String lhs, String rhs);
}
