import java.util.Scanner;
import java.io.*;
public class lab2_2 {
        public static void main(String[] args) throws IOException
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть значеня кута: ");
            double angle = scanner.nextDouble();
            System.out.println("Синус кута 30 градусів: " + Math.sin(Math.toRadians(angle)));
            System.out.println("Косинус кута 30 градусів: " + Math.cos(Math.toRadians(angle)));
        }
    }