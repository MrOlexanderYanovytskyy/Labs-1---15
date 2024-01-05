import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.*;

public class Main
{
    private static JTextField directoryTextField;
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Delete Files in Directory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new FlowLayout());
        JLabel directoryLabel = new JLabel("Введіть шлях до каталогу:");
        directoryTextField = new JTextField(20);
        JButton browseButton = new JButton("Огляд...");
        JButton deleteButton = new JButton("Видалити файли");
        browseButton.addActionListener(new BrowseButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        frame.add(directoryLabel);
        frame.add(directoryTextField);
        frame.add(browseButton);
        frame.add(deleteButton);
        frame.setVisible(true);
    }
    private static class BrowseButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File selectedDirectory = fileChooser.getSelectedFile();
                directoryTextField.setText(selectedDirectory.getAbsolutePath());
            }
        }
    }
    private static class DeleteButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String directoryName = directoryTextField.getText();

            if (directoryName.isEmpty())
            {
                showMessage("Введіть шлях до каталогу.");
                return;
            }
            File directory = new File(directoryName);
            if (!directory.exists() || !directory.isDirectory())
            {
                showMessage("Каталогу не існує або це не каталог.");
                return;
            }
            File[] files = directory.listFiles();
            if (files == null || files.length == 0)
            {
                showMessage("Каталог порожній.");
                return;
            }
            int response = showConfirmationDialog("Ви впевнені, що бажаєте видалити " + files.length + " файлів у каталозі?");
            if (response == JOptionPane.YES_OPTION)
            {
                for (File file : files)
                {
                    if (file.delete())
                    {
                        showMessage("Файл " + file.getName() + " видалено.");
                    } else
                    {
                        showMessage("Не вдалося видалити файл " + file.getName());
                    }
                }
            } else
            {
                showMessage("Операція видалення скасована користувачем.");
            }
        }
    }

    private static void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    private static int showConfirmationDialog(String message)
    {
        return JOptionPane.showConfirmDialog(null, message, "Підтвердження видалення", JOptionPane.YES_NO_OPTION);
    }
}
