import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main
{
    private static void createAndShowGUI()
    {
        // Створення фрейма
        JFrame frame = new JFrame("Dialog Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Створення та налаштування діалогового вікна
        JDialog dialog = new JDialog(frame, "Dialog", true);
        dialog.setLayout(new GridLayout(3, 2)); // 3 рядки, 2 стовпці
        // Додавання компонентів до діалогового вікна
        dialog.add(new JLabel("Login:"));
        JTextField textField1 = new JTextField();
        dialog.add(textField1);
        dialog.add(new JLabel("Password 2:"));
        JTextField textField2 = new JTextField();
        dialog.add(textField2);
        JButton okButton = new JButton("ОК");
        JButton cancelButton = new JButton("Відміна");
        dialog.add(okButton);
        dialog.add(cancelButton);
        // Налаштування дії для кнопки "ОК"
        okButton.addActionListener(e ->
        {
            dialog.dispose(); // Закриття діалогового вікна після натискання "ОК"
        });
        // Налаштування дії для кнопки "Відміна"
        cancelButton.addActionListener(e ->
        {
            dialog.dispose();
        });
        // Встановлення розміру діалогового вікна відповідно до його вмісту
        dialog.pack();
        // Встановлення розташування фрейма
        frame.setLocationRelativeTo(null);
        // Налаштування дії для кнопки відображення діалогового вікна
        JButton showDialogButton = new JButton("Показати діалогове вікно");
        showDialogButton.addActionListener(e -> dialog.setVisible(true));
        // Додавання компонентів до фрейма
        frame.getContentPane().setLayout(new GridLayout(2, 1));
        frame.getContentPane().add(showDialogButton);
        frame.getContentPane().add(new JPanel()); // Пуста панель для зручного відображення
        // Відображення фрейма
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        // Запуск застосування
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}