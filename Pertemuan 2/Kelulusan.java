import java.util.Scanner;

public class Kelulusan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nama, keterangan;
        int nilai;
        System.out.print("Masukkan Nama : ");
        nama = input.next();
        System.out.print("Masukkan Nilai: ");
        nilai = input.nextInt();

        if(nilai >= 60) {
            keterangan = "Lulus";
        } else {
            keterangan = "Tidak Lulus";
        }

        System.out.println(nama + " " + keterangan);
    }
}