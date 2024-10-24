package File_;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class File_ {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("./out/production/HelloApp/File_/data.txt");
        FileWriter writer = new FileWriter(file, true);
        String stroke;
        while(true){
            System.out.println("Вводите данные с консоли");
            stroke = scanner.nextLine();
            if (stroke.compareTo("0") == 0){
                break;
            } else {
                writer.write(stroke + '\n');
            }
        }
        writer.flush();
        writer.close();
    }
}
