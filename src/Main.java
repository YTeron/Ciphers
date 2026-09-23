//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import org.w3c.dom.css.Counter;

void main() throws IOException {
    Scanner scanner =new Scanner(System.in);
    String txt = Reader.fileText(scanner.nextLine());

    //String txt = Reader.fileText("/resources/text.txt");
    System.out.println(txt);
    Scanner scanner2 = new Scanner(System.in);
    int shift = scanner2.nextInt();
    if (shift >=0&&shift<=32) {
        String codeTest = Encryption.cipher(txt,shift);
        System.out.println(codeTest);
        Encryption.cipher(txt,shift,"newFile" );
        System.out.println(Encryption.useKeyToFile(codeTest, shift));
        Encryption.useKeyToFile(codeTest,shift,"decodedNewFile");
    }
    else {
        System.out.println("Сдвиг за пределами значений");
        return;
    }
    scanner.close();
    scanner2.close();
}
