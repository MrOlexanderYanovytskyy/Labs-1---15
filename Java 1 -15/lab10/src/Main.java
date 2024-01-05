import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;
class PhoneBookApp extends JFrame
{
    private JTextField surnameField;
    private JTextField phonesField;
    private JLabel countLabel;
    private TreeSet<String> phoneBook;
    public PhoneBookApp()
    {
        phoneBook = new TreeSet<>();
        setTitle("Телефонний Записник");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel up = new JPanel(new GridLayout(3, 1));
        surnameField = new JTextField();
        phonesField = new JTextField();
        JButton printButton = new JButton("Друкувати");
        countLabel = new JLabel("Кількість записів: 0");
        printButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                printPhoneBook();
            }
        });
        up.add(createLabeledPanel("Прізвище:", surnameField));
        up.add(createLabeledPanel("Телефони:", phonesField));
        up.add(printButton);
        JPanel down = new JPanel(new FlowLayout(FlowLayout.LEFT));
        down.add(countLabel);
        add(up, BorderLayout.NORTH);
        add(down, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JPanel createLabeledPanel(String labelText, JTextField textField)
    {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }
    private void printPhoneBook()
    {
        String surname = surnameField.getText();
        String phones = phonesField.getText();
        phoneBook.add(surname + ": " + phones);
        surnameField.setText("");
        phonesField.setText("");
        countLabel.setText("Кількість записів: " + phoneBook.size());
        System.out.println("Телефонний Записник:");
        for (String entry : phoneBook)
        {
            System.out.println(entry);
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new PhoneBookApp();
            }
        });
    }
}
