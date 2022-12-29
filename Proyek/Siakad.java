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

    public static void urutkanData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pengurutan:");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Shell Sort");
        System.out.print("Pilih algoritma: ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                bubbleSort();
                break;
            }
            case 4: {
                quickSort();
                break;
            }
            case 5: {
                shellSort();
                break;
            }
        }
    }

    public static void exchangeSort() {
        for(int x = 0; x < jumlahData; x++){
            for(int y = (x + 1); y < jumlahData; y++){
                if(mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1){
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        for(int i = 0; i < jumlahData; i++){
            int indeks = i;
            for(int j = i + 1; j < jumlahData; j++){
                if(mahasiswa[indeks].getNim().compareTo(mahasiswa[j].getNim()) >= 1){
                    indeks = j;
                }
            }
            if(indeks != i){
                Mahasiswa temp = mahasiswa[i];
                mahasiswa[i] = mahasiswa[indeks];
                mahasiswa[indeks] = temp;
            }
        }
    }

    public static void bubbleSort() {
        
    }

    public static void quickSort() {
        
    }

    public static void shellSort() {
        
    }

    public static void cariData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Algoritma Pencarian:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Pilih algoritma: ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1: {
                linearSearch();
                break;
            }
            case 2: {
                binarySearch();
                break;
            }
        }
    }

    public static void linearSearch() {
        
    }

    public static void binarySearch() {
        
    }

    public static void editData() {
        
    }

    public static void hapusData() {
        
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu;
        do {
            System.out.println("---Menu Siakad---");
            System.out.println("1. Tambah data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu = ");
            menu = input.nextInt();
            if(menu == 1){
                tambahData();
            } else if(menu == 2){
                tampilData();
            } else if(menu == 3){
                urutkanData();
            } else if(menu == 4){
                cariData();
            } else if(menu == 5){
                editData();
            } else if(menu == 6){
                hapusData();
            }
        } while (menu != 7);
    }
}