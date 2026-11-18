import  java.awt.*;
import  java.awt.event.*;
import  javax.swing.*;

public class SimpleGUI extends JFrame{

    private JButton cripton = new JButton("Шифрование");
    private JButton deCripton =new JButton("Дешифрование");
    private JTextField input = new JTextField("",10);
    private JLabel output = new JLabel("",10);
    private JRadioButton vigener =new JRadioButton("Видженёр");
    private JRadioButton cheser =new JRadioButton("Цезарь");
    private JTextField keyField = new JTextField("", 10);

     public SimpleGUI(){
        super("Label");
        this.setBounds(100,100,250,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container =this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
         container.add(new JLabel("Текст:"));
         container.add(input);

         container.add(new JLabel("Ключ (число или слово):"));
         container.add(keyField);

         ButtonGroup group = new ButtonGroup();
         group.add(vigener);
         group.add(cheser);

         cheser.setSelected(true);
         container.add(vigener);
         container.add(cheser);

         container.add(cripton);
         container.add(deCripton);

         container.add(new JLabel("Результат:"));
         container.add(output);

         cripton.addActionListener(e -> doAction(true));
         deCripton.addActionListener(e -> doAction(false));
    }
    private void doAction(boolean encrypt) {
        String text = input.getText();
        String key  = keyField.getText().trim();

        if (text.isEmpty()) { output.setText("Введите текст"); return; }

        try {
            String result;
            if (cheser.isSelected()) {
                int shift = Integer.parseInt(key);
                if (shift < 0 || shift > 32) { output.setText("Сдвиг 0-32"); return; }
                result = encrypt ? Encryption.cipher(text, shift) : Encryption.useKeyToFile(text, shift);
            } else {
                if (key.isEmpty()) { output.setText("Введите ключ"); return; }
                if (!text.equals(text.toUpperCase()) || !key.equals(key.toUpperCase())) {
                    output.setText("Виженер: только заглавные A–Z");
                    return;
                }
                result = encrypt ? Vigenere.encrypt(text, key) : Vigenere.decrypt(text, key);
            }
            output.setText(result);
            if (encrypt) input.setText(result);
        } catch (NumberFormatException ex) {
            output.setText("Ключ Цезаря - число");
        } catch (Exception ex) {
            output.setText("Ошибка: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleGUI().setVisible(true));
    }
}
