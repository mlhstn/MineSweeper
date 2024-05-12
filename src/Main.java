import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int row, col;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mayın tarlası oyununa hoş geldiniz !!");
        //Kullanıcıdan satır ve sütün değerleri isteniyor. "Değerlendirme formu 7"

        System.out.print("Lütfen satır sayınısını giriniz : ");
        row = scanner.nextInt();

        System.out.print("Lütfen sütün sayısını giriniz : ");
        col = scanner.nextInt();

        while (row < 2 || col <2 ){ // Satır ve sütün sayısının 2 den az olup olmadığını kontrol ediyor eğer az ise tekrardan değer isteniyor.
            System.out.print("lütfen satır sayısını tekrar giriniz : ");
            row= scanner.nextInt();
            System.out.print("lütfen sütün sayısını tekrar giriniz : ");
            col = scanner.nextInt();
        }
        MineSweeper mineSweeper = new MineSweeper(row,col);
        mineSweeper.run();
    }
}
