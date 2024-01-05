import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class lab8 extends JFrame
{
    JTextField fld = new JTextField(20);
    JButton btn = new JButton("Скопіювати та занести у список");
    JButton printBtn = new JButton("Друкувати");
    JLabel lbl = new JLabel(" ");
    JTextArea outputArea = new JTextArea(5, 20);
    JScrollPane scrollPane = new JScrollPane(outputArea);
    JPanel inputPanel = new JPanel();
    JPanel outputPanel = new JPanel();
    ArrayList<String> inputList = new ArrayList<>();
    lab8()
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
        buttonOutputPanel.add(printBtn, BorderLayout.SOUTH);
        c.add(buttonOutputPanel, BorderLayout.CENTER);
        btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String inputText = fld.getText();
                inputList.add(inputText);
                // Копіювання введеного тексту в буфер обміну
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection stringSelection = new StringSelection(inputText);
                clipboard.setContents(stringSelection, null);
                updateOutputArea();
            }
        });
        fld.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String inputText = fld.getText();
                inputList.add(inputText);
                lbl.setText("Введений текст: " + inputText);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                StringSelection stringSelection = new StringSelection(inputText);
                clipboard.setContents(stringSelection, null);
                updateOutputArea();
            }
        });

        printBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Збережений список:");
                for (String item : inputList) {
                    System.out.println(item);
                }
                updateOutputArea();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void updateOutputArea()
    {
        outputArea.setText("");
        for (String item : inputList)
        {
            outputArea.append(item + "\n");
        }
    }
    public static void main(String[] args)
    {
        new lab8();
    }
}
