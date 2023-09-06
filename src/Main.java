import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSınav Notu Hesaplama Uygulaması");
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Not Ortalamasını Hesapla");
            System.out.println("3. En Yüksek Notu Bul");
            System.out.println("4. En Düşük Notu Bul");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    ogrenciEkle();
                    break;
                case 2:
                    notOrtalama();
                    break;
                case 3:
                    enYuksekNot();
                    break;
                case 4:
                    enDusukNot();
                    break;
                case 5:
                    System.out.println("Sistemden Çıkılıyor.");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
                    break;
            }
        }
    }

    private static void ogrenciEkle() {
        System.out.print("Öğrenci Adı: ");
        String ad = scanner.nextLine();

        System.out.print("Öğrenci Soyadı: ");
        String soyad = scanner.nextLine();

        System.out.print("Öğrenci Numarası: ");
        int numara = scanner.nextInt();

        System.out.print("Sınav Notu: ");
        double sınavNotu = scanner.nextDouble();

        Student yeniOgrenci = new Student(ad, soyad, numara, sınavNotu);
        students.add(yeniOgrenci);

        System.out.println("Öğrenci Eklendi: " + yeniOgrenci);
    }

    public static void notOrtalama() {
        if (students.isEmpty()) {
            System.out.println("Kayıtlı Öğrenci Yok.");
            return;
        }
        double toplamNot = 0;

        for (Student student : students) {
            toplamNot += student.getNote();
        }

        double ortalama = toplamNot / students.size();

        System.out.println("Tüm Öğrencilerin Not Ortalaması: " + ortalama);
    }

    public static void enYuksekNot() {
        if (students.isEmpty()) {
            System.out.println("Kayıtlı Öğrenci Yok.");
            return;
        }
        double enYuksekNot = Collections.max(students, (o1, o2) -> Double.compare(o1.getNote(), o2.getNote())).getNote();
        System.out.println("En Yüksek Not: " + enYuksekNot);
    }

    public static void enDusukNot() {
        if (students.isEmpty()) {
            System.out.println("Kayıtlı Öğrenci Yok.");
            return;
        }

        double enDusuk = Collections.min(students, (o1, o2) -> Double.compare(o1.getNote(), o2.getNote())).getNote();
        System.out.println("En Düşük Not: " + enDusuk);
    }
}
