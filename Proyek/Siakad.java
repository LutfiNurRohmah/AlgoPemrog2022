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
                quickSort(mahasiswa, 0, jumlahData-1);
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
        for(int i = 0; i < jumlahData; i++){
            for(int j = 1; j < jumlahData - i; j++){
                if(mahasiswa[j - 1].getNim().compareTo(mahasiswa[j].getNim()) >= 1){
                    Mahasiswa temp = mahasiswa[j - 1];
                    mahasiswa[j - 1] = mahasiswa[j];
                    mahasiswa[j] = temp;
                } 
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        } 
    }

    public static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j].getNim().compareTo(arr[low].getNim())<=-1)
                swap(arr, ++p, j);
        swap(arr, low, p);
        return p;
    }

    public static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void shellSort() {
        for(int interval = jumlahData / 2; interval > 0; interval /= 2){
            for(int i = interval; i < jumlahData; i++){
                Mahasiswa temp = mahasiswa[i];
                int j;
                for(j = i; j >= interval && mahasiswa[j-interval].getNim().compareTo(temp.getNim()) >= 1; j -= interval){
                    mahasiswa[j] = mahasiswa[j - interval];
                }
                mahasiswa[j] = temp;
            }
        }
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