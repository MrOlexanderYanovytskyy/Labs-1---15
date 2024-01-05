import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)
    {
        try {
            // Зчитуємо файл
            BufferedReader reader = new BufferedReader(new FileReader("Cat.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Введений рядок: " + line);

                // Розбиваємо рядок за допомогою StringTokenizer
                StringTokenizer tokenizer = new StringTokenizer(line);

                // Виводимо результати
                System.out.println("Рядок складається з:");

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();

                    try {
                        // Перевіряємо, чи слово можна перетворити в число
                        double number = Double.parseDouble(token);
                        System.out.println(token + " - це число = " + number);
                    } catch (NumberFormatException e) {
                        System.out.println(token + " - не можна перетворити в число");
                    }
                }

                System.out.println();
            }
            // Закриваємо ридер
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдений");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
