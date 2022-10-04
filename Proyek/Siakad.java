import java.util.Scanner;

public class Siakad {
    public static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    public static int jumlahData = 0;

    public static void tambahData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Silahkan tambahkan data");
        System.out.print("NIM: ");
        String nim = input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;
    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        for(int i = 0; i < jumlahData; i++){
            System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        do {
            System.out.println("---Menu Siakad---");
            System.out.println("1. Tambah data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu = ");
            menu = input.nextInt();
            if(menu == 1){
                tambahData();
            } else if(menu == 2){
                tampilData();
            }
        } while (menu != 3);
    }
}