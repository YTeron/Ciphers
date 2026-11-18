void main() throws IOException {
    Scanner scanner = new Scanner(System.in);

    String path = scanner.nextLine();
    String txt = Reader.fileText(path);
    System.out.println(txt);

    int shift = Integer.parseInt(scanner.nextLine().trim());
    if (shift >= 0 && shift <= 32) {
        String codeTest = Encryption.cipher(txt, shift);
        System.out.println(codeTest);
        Encryption.cipher(txt, shift, "newFile");
        System.out.println(Encryption.useKeyToFile(codeTest, shift));
        Encryption.useKeyToFile(codeTest, shift, "decodedNewFile");
    } else {
        System.out.println("Сдвиг за пределами значений");
        return;
    }
    //  /resources/text.txt
    String text = scanner.nextLine();
    String key  = scanner.nextLine();

    if (text.equals(text.toUpperCase()) && key.equals(key.toUpperCase())) {
        String s = Vigenere.encrypt(text, key);
        System.out.println(s);
        System.out.println(Vigenere.decrypt(s, key));
    } else {
        System.out.println("Слова должны быть с Большой буквы");
    }

    scanner.close();
}