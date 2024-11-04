import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = createFileIfNotExist("./out/production/2.6.File/files/data.txt");
        System.out.println(" ");
        FileWriter writer = new FileWriter(file);
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

    public static File createFileIfNotExist(String filePath) throws IOException{
        File file = new File(filePath);

        if (!file.exists()){
            var fileName = file.getName();
            var filePathStrings = new Stack<String>();

            File dirFile = null;
            for(dirFile = file.getParentFile(); !dirFile.exists(); dirFile = dirFile.getParentFile()) {
                filePathStrings.push(dirFile.getName());
            }
            if(!dirFile.isDirectory()) throw new IOException("Directory file is not a Directory");

            File file1 = dirFile;

            while(!filePathStrings.empty()){
                file1 = new File(file1, filePathStrings.pop());
                if(!file1.mkdir()) throw new IOException("Cannot create dir");
            }
            file = new File(file1, fileName);
        }

        return file;
    }
}
