import java.io.InputStream;
import java.util.Scanner;

public class Reader {
    public static String fileText(String file){
        InputStream is = Reader.class.getResourceAsStream(file);
        if (is == null) {
            return "Ресурс не найден!";
        }
        else {
            System.out.println("Загружен");
        }
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return sb.toString();


    }
}
