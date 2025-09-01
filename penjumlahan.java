import java.util.Scanner;

public class penjumlahan {

    public int tambah(int a, int b) {
        int hasil = a + b;
        if (hasil < 10) {
            System.out.println("Kurang dari 10");
        }
        return hasil;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan pertama: ");
        int a = scanner.nextInt();

        System.out.print("Masukkan bilangan kedua: ");
        int b = scanner.nextInt();

        penjumlahan calc = new penjumlahan();
        int hasil = calc.tambah(a, b);
        System.out.println("Hasil penjumlahan: " + hasil);
    }
}
