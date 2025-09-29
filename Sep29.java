import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sep29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Jumlah barang yang dibeli: ");
        int a = in.nextInt();
        String[] namaBarang = new String[a];
        int[] harga = new int[a];
        int[] qty = new int[a];
        int[] total = new int[a];
        long subtotal = 0;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        for (int i = 0; i < a; i++) {
            System.out.printf("Nama barang %d: ", i + 1);
            namaBarang[i] = in.next();
            System.out.printf("Jumlah barang %d: ", i + 1);
            qty[i] = in.nextInt();
            System.out.printf("Harga barang %d: ", i + 1);
            harga[i] = in.nextInt();
            total[i] = harga[i] * qty[i];
        }
        System.out.println("\n================================");
        System.out.println("STRUK PEMBELIAN");
        System.out.println("================================");
        System.out.printf("Tanggal \t%s\n", now.format(tglFormat));
        System.out.println("\n");
        for (int i = 0; i < a; i++) {
            System.out.printf("%s - %d  %d = %d\n", namaBarang[i], qty[i], harga[i], total[i]);
            subtotal += total[i]; 
        }
        System.out.println("----------------------------------------");
        System.out.printf("Subtotal\t\tRp%d\n", subtotal);
        System.out.println("----------------------------------------");
        System.out.printf("Total\t\t\tRp%d\n", subtotal); 
        System.out.println("========================================");
        System.out.println("\nTerima Kasih Telah Berbelanja di");
        System.out.println("FILKOM-MART");
        in.close();

    }
}
