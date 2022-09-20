import java.util.Scanner;

public class Penjumlahan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y, hasil;
        System.out.print("Masukkan nilai x = ");
        x = input.nextInt();
        System.out.print("Masukkan nilai y = ");
        y = input.nextInt();

        hasil = x + y;
        System.out.println("Hasil penjumlahan x + y = " + hasil);
    }
}