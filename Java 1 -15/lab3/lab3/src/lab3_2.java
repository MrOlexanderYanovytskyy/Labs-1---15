import java.util.Scanner;
public class lab3_2
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть довжину першого катета:");
        double kA = scanner.nextDouble();
        System.out.println("Введіть довжину другого катета:");
        double kB = scanner.nextDouble();
        scanner.close();
        double gip = Math.hypot(kA, kB);
        double kat1 = Math.toDegrees(Math.asin(kA / gip));
        double kat2 = Math.toDegrees(Math.asin(kB / gip));
        double kat3 = 90;
        System.out.println("Кут A: " + kat1);
        System.out.println("Кут B: " + kat2);
        System.out.println("Кут C: " + kat3);
    }
}
