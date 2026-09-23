import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Encryption {
    public static void stringToFile(String text,String name) throws IOException {
        Path out = Path.of("src","resources", name);
        Files.createDirectories(out.getParent());
        Files.writeString(
                out,
                text,
                StandardCharsets.UTF_8
        );
        System.out.println("Записано: " + out.toAbsolutePath());

    }
    public static void cipher(String text, int shift,String name) throws IOException {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'а' && c <= 'я') {
                int offset = c - 'а';
                offset = (offset - shift) % 32;
                if (offset < 0) offset += 32;
                c = (char) ('а' + offset);
            }
            else if (c >= 'А' && c <= 'Я') {
                int offset = c - 'А';
                offset = (offset - shift) % 32;
                if (offset < 0) offset += 32;
                c = (char) ('А' + offset);
            }
            newText.append(c);
        }
        stringToFile(newText.toString(),name);
    }
    public static String cipher(String text, int shift) throws IOException {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'а' && c <= 'я') {
                int offset = c - 'а';
                offset = (offset - shift) % 32;
                if (offset < 0) offset += 32;
                c = (char) ('а' + offset);
            }
            else if (c >= 'А' && c <= 'Я') {
                int offset = c - 'А';
                offset = (offset - shift) % 32;
                if (offset < 0) offset += 32;
                c = (char) ('А' + offset);
            }
            newText.append(c);
        }
        return newText.toString();
    }
    public static String useKeyToFile(String text, int key) throws IOException {
        return cipher(text,-key);
    }
    public static void useKeyToFile(String text, int key,String path) throws IOException {
        cipher(text,-key,path);
    }
}
