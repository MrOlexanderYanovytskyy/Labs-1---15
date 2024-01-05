import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main
{
    private JFrame frame;
    private JPanel panel;
    private ButtonGroup group;
    private ArrayList<Integer> scores;
    private int currentQuestionIndex;
    private String[][] questions =
            {
            {"Хто вбив Кенеді?", "Трамп", "Вася", "Джордж Буш", "Джо Байден", "Правильна відповідь: Террорист"},
            {"Чому Трампу оголосили імпічмент?", "За фальсифікацію виборів", "Расизм", "Запуск ракет", "За стіну", "Правильна відповідь: Приховування документів"},
            {"Якого кольору трава?", "Червоний", "Синій", "Фіолетовий", "Жовтий", "Правильна відповідь: Зелений"}
    };

    public Main()
    {
        frame = new JFrame("Тестування");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(0, 1));
        group = new ButtonGroup();
        scores = new ArrayList<>();
        currentQuestionIndex = 0;
        createQuestion();
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                nextQuestion();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(nextButton, BorderLayout.SOUTH);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void createQuestion()
    {
        JLabel questionLabel = new JLabel(questions[currentQuestionIndex][0]);
        panel.add(questionLabel);
        for (int i = 1; i < questions[currentQuestionIndex].length; i++)
        {  // Змінено умову циклу
            final String optionText = questions[currentQuestionIndex][i];
            JRadioButton radioButton = new JRadioButton(optionText);
            panel.add(radioButton);
            group.add(radioButton);
            radioButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    checkAnswer(optionText.endsWith("Правильна відповідь: " + radioButton.getText()));
                }
            });
        }
    }
    private void checkAnswer(boolean isCorrect)
    {
        String correctAnswer = questions[currentQuestionIndex][questions[currentQuestionIndex].length - 1].substring("Правильна відповідь: ".length());
        if (isCorrect)
        {
            scores.add(5);
        } else
        {
            scores.add(2);
        }
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length)
        {
            group.clearSelection();
            panel.removeAll();
            createQuestion();
            frame.revalidate();
            frame.repaint();
        } else
        {
            finishTest();
        }
    }

    private void finishTest()
    {
        int totalScore = 0;
        for (int score : scores)
        {
            totalScore += score;
        }

        double averageScore = (double) totalScore / scores.size();
        JOptionPane.showMessageDialog(frame, "Test completed!\nAverage Score: " + averageScore, "Results", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    private void nextQuestion()
    {
        if (currentQuestionIndex < questions.length)
        {
            group.clearSelection();
            panel.removeAll();
            createQuestion();
            frame.revalidate();
            frame.repaint();
        } else
        {
            finishTest();
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Main();
            }
        });
    }
}
