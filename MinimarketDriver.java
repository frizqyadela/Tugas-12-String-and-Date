import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MinimarketDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("No. Faktur        : ");
            String noFaktur = scanner.nextLine();

            System.out.print("Nama Pelanggan    : ");
            String namaPelanggan = scanner.nextLine();

            System.out.print("No. HP            : ");
            String nomorHP = scanner.nextLine();

            System.out.print("Alamat            : ");
            String alamatPelanggan = scanner.nextLine();

            System.out.print("Nama Barang       : ");
            String namaBarang = scanner.nextLine();

            System.out.print("Kode Barang       : ");
            String kodeBarang = scanner.nextLine();

            double hargaBarang;
            while (true) {
                try {
                    System.out.print("Harga Barang      : ");
                    hargaBarang = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Input harga tidak valid. Mohon masukkan angka.");
                    scanner.next(); 
                }
            }

            int jumlahBarang;
            while (true) {
                try {
                    System.out.print("Jumlah Barang     : ");
                    jumlahBarang = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Input jumlah tidak valid. Mohon masukkan angka.");
                    scanner.next(); 
                }
            }

            // Buat objek transaksi
            TransaksiPenjualan transaksi = new TransaksiPenjualan(noFaktur, namaPelanggan, alamatPelanggan, nomorHP, kodeBarang, namaBarang, hargaBarang, jumlahBarang);

            // Hitung total bayar
            transaksi.hitungTotalBayar();

            // Tampilkan detail transaksi
            transaksi.tampilDetail();

            // Tanggal dan Waktu
            Date date = new Date();
            SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-MM-yyyy");
            SimpleDateFormat jam = new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");

            // Tampilkan Struk
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("============== DEFA MART ===============");
            System.out.println(hari.format(date));
            System.out.println(jam.format(date));
            System.out.println("No Faktur \t: " + noFaktur);
            System.out.println("========================================");
            System.out.println(" ");
            System.out.println("------------ DATA PELANGGAN ------------");
            System.out.println("Nama Pelanggan \t: " + namaPelanggan);
            System.out.println("No. HP \t\t: " + nomorHP);
            System.out.println("Alamat \t\t: " + alamatPelanggan);
            System.out.println(" ");
            System.out.println("-------- DATA PEMBELIAN BARANG ---------");
            System.out.println("Nama Barang \t: " + namaBarang);
            System.out.println("Kode Barang \t: " + kodeBarang);
            System.out.println("Harga \t\t: " + hargaBarang);
            System.out.println("Jumlah \t\t: " + jumlahBarang);
            System.out.println("Total Bayar \t: " + transaksi.getTotalHarga());
            System.out.println("========================================");
            System.out.println("Kasir \t\t: Frizqya Dela Pratiwi \n");

            // Method string
            System.out.println("toUpperCase\t: " + namaPelanggan.toUpperCase());
            System.out.println("length\t\t: " + namaPelanggan.length());
            System.out.println("equals\t\t: " + hari.equals(hari));

        } finally {
            scanner.close();
        }
    }
}
