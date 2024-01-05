import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame
{
    private JTextArea txt;
    private double A;
    private double step;
    private int numPoints;

    public Main(double A, double step, int numPoints)
    {
        super("Таблиця значень функції");
        this.A = A;
        this.step = step;
        this.numPoints = numPoints;
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        setSize(600, 400);
        Container c = getContentPane();
        JPanel pane = new JPanel(new BorderLayout());
        c.add(pane, BorderLayout.CENTER);
        JPanel topPanel = new JPanel();
        JLabel labelA = new JLabel("A:");
        JTextField txtA = new JTextField(5);
        JLabel labelStep = new JLabel("Крок:");
        JTextField txtStep = new JTextField(5);
        JLabel labelNumPoints = new JLabel("Кількість точок:");
        JTextField txtNumPoints = new JTextField(5);
        topPanel.add(labelA);
        topPanel.add(txtA);
        topPanel.add(labelStep);
        topPanel.add(txtStep);
        topPanel.add(labelNumPoints);
        topPanel.add(txtNumPoints);
        pane.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        txt = new JTextArea(15, 40);
        txt.setEditable(false);
        JScrollPane scroll = new JScrollPane(txt);
        centerPanel.add(scroll);
        pane.add(centerPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        JButton btnUpdate = new JButton("Оновити таблицю");
        bottomPanel.add(btnUpdate);
        pane.add(bottomPanel, BorderLayout.SOUTH);
        btnUpdate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateTable(txtA.getText(), txtStep.getText(), txtNumPoints.getText());
            }
        });
        WindowListener wndCloser = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }
    private void updateTable(String aValue, String stepValue, String numPointsValue)
    {
        try
        {
            A = Double.parseDouble(aValue);
            step = Double.parseDouble(stepValue);
            numPoints = Integer.parseInt(numPointsValue);

            if (step <= 0 || numPoints <= 0)
            {
                throw new NumberFormatException();
            }

            txt.setText(""); // Clear the text area before updating

            for (int i = 1; i <= numPoints; i++)
            {
                double X = i * step;
                double Y = A * Math.sqrt(X) * Math.sin(A * X);
                txt.append(String.format("X=%.4f: Y=%.4f\n", X, Y));
            }
        } catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Невірний формат введених даних для A, кроку або кількості точок.", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Main(1.0, 0.1, 10);
            }
        });
    }
}
