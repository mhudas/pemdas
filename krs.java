import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }
}

class Mahasiswa {
    private String nim;
    private String nama;
    private String namaKPS;
    private List<MataKuliah> daftarMK;
    private int totalSks;

    private static final int MAX_SKS = 24;

    public Mahasiswa(String nim, String nama, String namaKPS) {
        this.nim = nim;
        this.nama = nama;
        this.namaKPS = namaKPS;
        this.daftarMK = new ArrayList<>();
        this.totalSks = 0;
    }

    public boolean tambahMataKuliah(MataKuliah mk) {
        if (totalSks + mk.getSks() > MAX_SKS) {
            return false;
        }
        daftarMK.add(mk);
        totalSks += mk.getSks();
        return true;
    }


    public void cetakKRS() {
        System.out.println("========================================");
        System.out.println("              KARTU RENCANA STUDI       ");
        System.out.println("========================================");
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("----------------------------------------");
        System.out.println("Daftar Mata Kuliah yang Diambil:");
        System.out.println("----------------------------------------");
        System.out.printf("%-10s %-25s %-3s%n", "Kode", "Nama MK", "SKS");
        System.out.println("----------------------------------------");

        for (MataKuliah mk : daftarMK) {
            System.out.printf("%-10s %-25s %-3d%n",
                    mk.getKode(), mk.getNama(), mk.getSks());
        }

        System.out.println("----------------------------------------");
        System.out.println("Total SKS : " + totalSks);
        System.out.println("Maksimal  : " + MAX_SKS + " SKS");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Mengetahui,");
        System.out.println("KPS / Dosen Pembimbing");
        System.out.println();
        System.out.println("Ttd:");
        System.out.println(namaKPS);
        System.out.println("========================================");
    }
}

public class krs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Aplikasi Pengisian KRS Mahasiswa ===");
        System.out.print("Masukkan NIM  : ");
        String nim = input.nextLine();

        System.out.print("Masukkan Nama : ");
        String nama = input.nextLine();

        System.out.print("Masukkan Nama KPS/Dosen Pembimbing : ");
        String namaKPS = input.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama, namaKPS);

        boolean lanjut = true;

        while (lanjut) {
            System.out.println();
            System.out.println("Input Mata Kuliah yang Diambil:");
            System.out.print("Kode MK      : ");
            String kode = input.nextLine();

            System.out.print("Nama MK      : ");
            String namaMK = input.nextLine();

            System.out.print("SKS Mata Kuliah : ");
            int sks = 0;
            try {
                sks = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input SKS harus berupa angka!");
                continue;
            }

            MataKuliah mk = new MataKuliah(kode, namaMK, sks);

            if (mhs.tambahMataKuliah(mk)) {
                System.out.println("Mata kuliah berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan mata kuliah.");
                System.out.println("Total SKS akan melebihi batas 24 SKS.");
            }

            System.out.print("Tambah mata kuliah lagi? (y/n): ");
            String jawab = input.nextLine();

            if (!jawab.equalsIgnoreCase("y")) {
                lanjut = false;
            }
        }

        System.out.println();
        mhs.cetakKRS();

        input.close();
    }
}
