import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("InputTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel fileLabel = new JLabel("Имя файла:");
        JTextField fileField = new JTextField();
        JLabel searchLabel = new JLabel("Строка для поиска:");
        JTextField searchField = new JTextField();
        JButton processButton = new JButton("Обработать");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        processButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String fileName = fileField.getText();
                String searchString = searchField.getText();

                if (fileName.isEmpty() || searchString.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "Введіть назву файлу та строку для пошуку", "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ArrayList<String> list = new ArrayList<>();
                BufferedReader fin = null;

                try
                {
                    fin = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

                    String thisLine;
                    while ((thisLine = fin.readLine()) != null)
                    {
                        list.add(thisLine);
                    }

                    Collections.sort(list);

                    resultArea.append("Список строк файлу:\n");
                    for (String str : list)
                    {
                        resultArea.append(str + "\n");
                    }

                    // Поиск введеної користувачем строки в відсортованому списку
                    int index = Collections.binarySearch(list, searchString);
                    if (index >= 0)
                    {
                        resultArea.append("Строка '" + searchString + "' знайдена у списку на позиции " + (index + 1) + "\n");
                    } else {
                        resultArea.append("Строка '" + searchString + "' не знайдена у списку\n");
                    }

                } catch (FileNotFoundException ex)
                {
                    resultArea.append("Файл не знайдено: " + fileName + "\n");
                } catch (IOException ex)
                {
                    resultArea.append("Помилка ввода/вивода. Файл " + fileName + "\n");
                } finally
                {
                    if (fin != null) {
                        try
                        {
                            fin.close(); // Закрыть файл
                        } catch (IOException ex)
                        {
                            resultArea.append("Помилка закриття файла " + fileName + "\n");
                        }
                    }
                }
            }
        });
        panel.add(fileLabel);
        panel.add(fileField);
        panel.add(searchLabel);
        panel.add(searchField);
        panel.add(new JLabel());
        panel.add(processButton);
        panel.add(new JLabel());
        panel.add(resultArea);
        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

