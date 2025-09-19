import java.util.Scanner;

public class sk2b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan bilangan N:");
        int n = in.nextInt();

        int count = 0;
        int num = 1;

        if (n % 2 == 0) {
            while (count < n) {
                if (num % 2 == 0) {
                    System.out.print(num + " ");
                    count++;
                }
                num++;
            }
        } else {
            while (count < n) {
                if (num % 2 != 0) {
                    System.out.print(num + " ");
                    count++;
                }
                num++;
            }
        }
    }
}
