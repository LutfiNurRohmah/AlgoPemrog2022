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
        System.out.println("--- CARI DATA ---");
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
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama/ NIM yang dicari: ");
        String cari = input.nextLine();
        int hasil = 0;
        for(int i = 0; i < jumlahData; i++){
            String nama = mahasiswa[i].getNama();
            String nim = mahasiswa[i].getNim();
            if(cari.equals(nama)){
                System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
                hasil++;
            } else if(cari.equals(nim)){
                System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
                hasil++; 
            } 
        }
        if(hasil == 0){
            System.out.println("Data tidak ditemukan!");
        }
        
    }

    public static void binarySearch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM yang dicari: ");
        String cari = input.next();
        Integer index = bSearch(mahasiswa, cari, 0, jumlahData - 1);
        if(index != null){
            System.out.println("Data yang anda cari :");
            System.out.println(mahasiswa[index].getNim() + " " + mahasiswa[index].getNama());
        } else{
            System.out.println("Data tidak ditemukan!");
        }
    }

    public static Integer bSearch(Mahasiswa[] arr, String filter, int low, int high) {
        quickSort(mahasiswa, 0, jumlahData - 1);
            if (low > high){
                return null;
            } else {
                int mid = (low + high) / 2;
                int temp2 = Integer.parseInt(arr[mid].getNim());
                if(Integer.valueOf(filter) == temp2){
                    return mid;
                }
                else if(Integer.valueOf(filter) > temp2){
                    return bSearch(mahasiswa, filter, mid + 1, high);
                }
                else{
                   return bSearch(mahasiswa, filter, low, mid - 1);
                }
            }
    }

    public static void editData() {
        Scanner input = new Scanner(System.in);
        System.out.println("--- EDIT DATA ---");
        for(int i = 0; i < jumlahData; i++){
            System.out.print((i + 1) + ". ");
            System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
        }
        System.out.print("Masukkan Nomor Data yang akan diedit: ");
        int edit = input.nextInt() - 1;
        input.nextLine();
        System.out.print("NIM Baru: ");
        String nim = input.nextLine();
        System.out.print("Nama Baru: ");
        String nama = input.nextLine();
        mahasiswa[edit].setNim(nim);
        mahasiswa[edit].setNama(nama);
    }

    public static void hapusData() {
        Scanner input = new Scanner(System.in);
        System.out.println("--- HAPUS DATA ---");
        for(int i = 0; i < jumlahData; i++){
            System.out.print((i + 1) + ". ");
            System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
        }
        System.out.print("Masukkan Nomor Data yang akan dihapus: ");
        int hapus = input.nextInt() - 1;
        System.out.println("Nama : " + mahasiswa[hapus].getNama());
        System.out.println("Nim : " + mahasiswa[hapus].getNim());
        System.out.print("Hapus Data ini? (y/n): ");
        String pilihan= input.next();
        if(pilihan.equalsIgnoreCase("y")){
            mahasiswa[hapus] = null;
            for(int i = 0; i < jumlahData - 1; i++){
                Mahasiswa temp;
                if(mahasiswa[i] == null){
                    temp = mahasiswa[i + 1];
                    mahasiswa[i] = mahasiswa[i+1];
                    mahasiswa[i + 1] = null;
                }
            }
            jumlahData = jumlahData - 1;
            System.out.println("Data berhasil dihapus!");
        }
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