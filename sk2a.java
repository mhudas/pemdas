import java.util.Scanner;

public class sk2a {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan batas atas:");
        int n = in.nextInt();
        int i = n;
        while (i >= 1) {
            int j = 1;
            while (j <= i) {
                System.out.print(j + " ");
                j++;
            }
            System.out.println();
            i--;
        }
        }
    }
