/*Soal
Buatlah tampilan sperti di bawah ini dengan jumlah 
baris sama dengan nilai "n" yang dimasukkan. Contoh:
n = 5
    *
   **
  ***
 ****
*****
*/

import java.util.Scanner;

public class RataKanan {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai n = ");
        n = input.nextInt();
        int k = 1;
        while(k <= n) {
            int i = k;
            while (i < n) {
                System.out.print(" ");
                i = i + 1;
            }
            int j = 1;
            while (j <= k) {
                System.out.print("*");
                j = j + 1;
            }
            System.out.println();
            k = k + 1;
        }
    }
}