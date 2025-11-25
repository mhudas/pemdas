import java.util.ArrayList;
import java.util.Scanner;

class Buku {
    String isbn;
    String judul;

    Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }
}

class Mahasiswa {
    String nim;
    String nama;
    ArrayList<Buku> daftarBuku = new ArrayList<>();

    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    void pinjam(Buku buku) {
        daftarBuku.add(buku);
    }

    void printData() {
        System.out.println("\n==========================================");
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("==========================================");
        System.out.println("| No | ISBN            | Judul                     |");

        int no = 1;
        for (Buku b : daftarBuku) {
            System.out.printf("| %-2d | %-14s | %-25s |\n", no, b.isbn, b.judul);
            no++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM Anda: ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama Anda: ");
        String nama = sc.nextLine();
        Mahasiswa mhs = new Mahasiswa(nim, nama);

        System.out.print("Masukkan jumlah buku yang ingin dipinjam: ");
        int jumlah = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Buku ke-" + (i + 1));

            System.out.print("Masukkan ISBN: ");
            String isbn = sc.nextLine();

            System.out.print("Masukkan Judul: ");
            String judul = sc.nextLine();

            Buku buku = new Buku(isbn, judul);
            mhs.pinjam(buku);
        }
        mhs.printData();
    }
}
