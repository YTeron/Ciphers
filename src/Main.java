import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String key = scanner.nextLine();
        if (text == text.toUpperCase()&&key == key.toUpperCase()) {
            System.out.println(Vigenere.encrypt(text,key));
            String s =Vigenere.encrypt(text,key);
            System.out.println(Vigenere.decrypt(s,key));
            scanner.close();
        } else {
            System.out.println("Слова должны быть с Большой буквы");
        }

    }
}