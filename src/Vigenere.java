public class Vigenere {
    public static String encrypt(String text, String key) {
        return transform(text, key, +1);
    }
    public static String decrypt(String text, String key) {
        return transform(text, key, -1);
    }
    private static char shiftLetter(char c, int shift, int direction) {
        return (char) ((c - 'A' + direction * shift + 26) % 26 + 'A');
    }
    public static String transform(String plaintext, String key,int direction) {
        StringBuilder newText = new StringBuilder();
        int[] shifts = new int[key.length()];
        int countI =0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int count = c - 'A';
            shifts[i] = count;
        }
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                int shift = shifts[countI % shifts.length];
                char encrypted = shiftLetter(c,shift,direction);
                newText.append(encrypted);
                countI++;
            } else {
                newText.append(c);
            }
        }

        return newText.toString();
    }
}
