import javax.swing.*;
import java.awt.*;
public class lab5
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("2 завдання");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260, 170);
        DoubleVector vec = new DoubleVector();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JLabel l1 = new JLabel("Вивід 1: " + vec.getResult1());
        JLabel l2 = new JLabel("Вивід 2: " + vec.isResult2());
        JLabel l3 = new JLabel("Вивід 3: " + vec.getResult3());
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.setVisible(true);
    }
    static class DoubleVector
    {
        private int result1 = 1;
        private boolean result2 = true;
        private String result3 = "Operation Basepoint";
        public int getResult1() {
            return result1;
        }
        public boolean isResult2() {
            return result2;
        }
        public String getResult3() {
            return result3;
        }
    }
}