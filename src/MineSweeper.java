import java.util.Random;
import java.util.Scanner;

// "Değerlendirme formu 5"
public class MineSweeper {
    int rowNumber, colNumber, size,maxRow,maxCol;
    boolean[][] selectedCells;
    String[][] map;
    String[][] board;
    boolean game = true;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    public MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        this.map = new String[rowNumber][colNumber];
        this.board = new String[rowNumber][colNumber];
        selectedCells = new boolean[rowNumber][colNumber];
        this.maxRow = rowNumber;
        this.maxCol = colNumber;
    }

    // Oyunu başlatma metodu
    public void run() {

        int row, col,success = 0;
        prepareGame();
        print(map);
        System.out.println("Oyun başladı!");
        while (game) {
            print(board);
            //Kullanıcıdan seçmek istediği alanın koordinatları isteniyor "Değerlendirme formu 9"
            System.out.print("Satır giriniz : ");
            row = scanner.nextInt();

            System.out.print("Sütünü giriniz:");
            col = scanner.nextInt();

            //Girilen koordinatların sınırları aşıp aşmadığı kontrol ediliyor."Değerlendirme formu 10"
            if (row < 0 || row >= maxRow  || col < 0 || col >= maxCol) {

                System.out.println("Girilen koordinatlar sınırları aşıyor. Lütfen tekrar koordinat giriniz.");
                continue;
            }
            // Girilen koordinatın daha önce girilip girilmediği kontrol ediliyor
            if (selectedCells[row][col]) {
                System.out.println("Bu koordinatı daha önce seçtiniz! Lütfen başka bir koordinat giriniz.");
                continue;
            } else {
                selectedCells[row][col] = true; // Koordinatı işaretle
            }
                //Girilen koordinatta mayın varsa oyunu bitiriyor. "Değerlendirme formu 13"
            if (map[row][col].equals("*")) {
                game = false;
                System.out.println("Game over!"); // ""Değerlendirme formu 15"
            } else {
                int minesAround = check(row, col);
                // Hücrenin etrafındaki mayın sayısını board'a atama
                board[row][col] = String.valueOf(minesAround);
                // "Değerlendirme formu 14"
            }if (!map[row][col].equals("*")){
                check(row,col);
                success++;
                if (success == (size - (size/4))){
                    System.out.println("Tebrikler oyunu kazandınız!"); // "Değerlendirme formu 15//
                    break;
                }
            }
        }
    }

    //İstenilen haritayı ekrana bastıran metot
    public void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void prepareGame() {

        int randomRow, randomCol, count = 0;

        // Tüm haritayı  ("-") ile başlat
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                map[i][j] = "-";
            }
        }
        // Alanın 1/4 ü kadar random mayın yerleştir "Değerlendirme formu 8"
        while (count != (size / 4)) {
            randomRow = random.nextInt(rowNumber);
            randomCol = random.nextInt(colNumber);

            if (!map[randomRow][randomCol].equals("*")) {
                map[randomRow][randomCol] = "*";
                count++;
            }
        }
    }
    
    public int check(int r, int c) {

        int count = 0;
        // Seçilen koordinatın etrafında dolaşarak mayınları say "Değerlendirme formu 12"
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                // Kenarları kontrol et
                if (i >= 0 && i < rowNumber && j >= 0 && j < colNumber) {
                    if (map[i][j].equals("*")) {
                        count++;
                    }
                }
            }
        }
        // Hücrenin kendisi mayın değilse, sayıyı döndür
        return count;
    }
}

























