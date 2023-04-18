import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Resto {
    static ArrayList<String> kodeRest, namaRest, alamatRest;
    static String nama, alamat, kodeResto, namaMenu, kodeMenu;
    static ArrayList<Object> restoList = new ArrayList<Object>();
    static ArrayList<Object> menuList = new ArrayList<Object>();
    static Scanner input = new Scanner(System.in);
    public static void addResto() {
        kodeRest = new ArrayList<>();
        namaRest = new ArrayList<>();
        alamatRest = new ArrayList<>();
        int harga;
        System.out.print("Kode Restauran: ");
        kodeResto = input.nextLine();
        System.out.print("Nama Restauran: ");
        nama = input.nextLine();
        System.out.print("Alamat Restauran: ");
        alamat = input.nextLine();
        System.out.print("Banyak Menu: ");
        int banyak = Integer.parseInt(input.nextLine());
        for (int i = 0; i < banyak; i++) {
            System.out.print("Kode Menu: ");
            kodeMenu = input.nextLine();
            System.out.print("Nama Menu: ");
            namaMenu = input.nextLine();
            System.out.print("Harga Menu: ");
            harga = Integer.parseInt(input.nextLine());
            menuList.add(Arrays.asList(kodeResto, kodeMenu, namaMenu, harga));

        }
        restoList.add(Arrays.asList(kodeResto, nama, alamat));
    }

    public static void showResto(){
        System.out.println(restoList.size());
        kodeRest = new ArrayList<>();
        namaRest = new ArrayList<>();
        alamatRest = new ArrayList<>();
        for (int i = 0; i < restoList.size(); i++) {
            StringTokenizer stringtok = new StringTokenizer(
                    restoList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            kodeRest.add(stringtok.nextToken());
            namaRest.add(stringtok.nextToken());
            alamatRest.add(stringtok.nextToken());
        }
        for (int j = 0; j < kodeRest.size(); j++) {
            System.out.print("Index: ");
            System.out.println(j);
            System.out.print("Kode Resto: ");
            System.out.println(kodeRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Nama Resto: ");
            System.out.println(namaRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Alamat Resto: ");
            System.out.println(alamatRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            showMenu(kodeRest.get(j));
        }
    }
    public static void showMenu(String kodeResto) {
        StringTokenizer stringtok = null;
        for (int i = 0; i < menuList.size(); i++) {
            stringtok = new StringTokenizer(menuList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            if (kodeResto.equals(stringtok.nextToken())) {
                System.out.print("Kode Menu: ");
                System.out.println(stringtok.nextToken());
                System.out.print("Nama Menu: ");
                System.out.println(stringtok.nextToken());
                System.out.print("Harga Menu: ");
                System.out.println(stringtok.nextToken());
                System.out.println("========================================================\n");
            }
        }
    }
    public static void deleteResto() {
        if (restoList.size() > 0) {
            System.out.print("Masukkan Nomor Indeks: ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            restoList.remove(index);
            System.out.println("    --Data Telah Terhapus--");
        }
    }

}
