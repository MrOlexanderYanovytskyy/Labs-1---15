import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class lab7 extends JFrame
{
    JTextField fld = new JTextField(20);
    JButton btn = new JButton("Натиснути");
    JLabel lbl = new JLabel(" ");
    JTextArea outputArea = new JTextArea(5, 20); // Додано поле для виводу
    JScrollPane scrollPane = new JScrollPane(outputArea);
    JPanel inputPanel = new JPanel();
    JPanel outputPanel = new JPanel();
    lab7()
    {
        super("Слухачі (listeners) полів та кнопок");
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        setSize(400, 300);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        inputPanel.add(new JLabel("Введіть текст: "));
        inputPanel.add(fld);
        c.add(inputPanel, BorderLayout.NORTH);
        JPanel buttonOutputPanel = new JPanel();
        buttonOutputPanel.setLayout(new BorderLayout());
        buttonOutputPanel.add(btn, BorderLayout.NORTH);
        buttonOutputPanel.add(scrollPane, BorderLayout.CENTER);
        c.add(buttonOutputPanel, BorderLayout.CENTER);
        btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String currentText = outputArea.getText();
                outputArea.setText(currentText + "Натиснута кнопка\n");
            }
        });
        fld.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String currentText = outputArea.getText();
                outputArea.setText(currentText + "Введений текст: " + fld.getText() + "\n");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new lab7();
    }
}
