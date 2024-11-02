import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("./out/production/HelloApp/Main/data.txt");
        FileWriter writer = new FileWriter(file, true);
        String stroke;
        System.out.println("Вводите данные с консоли");
        while(true){
            stroke = scanner.nextLine();
            if (stroke.compareTo("0") == 0){
                break;
            } else {
                writer.write(stroke + '\n');
            }
            System.out.println("Вводите что нибудь ещё");
        }
        writer.flush();
        writer.close();
        scanner.close();
    }
}
