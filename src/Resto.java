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
    public void addResto() {
        kodeRest = new ArrayList<>();
        namaRest = new ArrayList<>();
        alamatRest = new ArrayList<>();
        int harga;
        System.out.print("Restaurant Code  : ");
        kodeResto = input.nextLine();
        System.out.print("Restaurant Name  : ");
        nama = input.nextLine();
        System.out.print("Restaurant Adress: ");
        alamat = input.nextLine();
        System.out.print("Jumlah Menu      : ");
        int banyak = Integer.parseInt(input.nextLine());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < banyak; i++) {
            System.out.print("Menu Code        : ");
            kodeMenu = input.nextLine();
            System.out.print("Menu Name        : ");
            namaMenu = input.nextLine();
            System.out.print("Price            : ");
            harga = Integer.parseInt(input.nextLine());
            menuList.add(Arrays.asList(kodeResto, kodeMenu, namaMenu, harga));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        restoList.add(Arrays.asList(kodeResto, nama, alamat));
    }

    public static void showResto(){
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
            System.out.print("Index number     : ");
            System.out.println(j);
            System.out.print("Restaurant Code  : ");
            System.out.println(kodeRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Restaurant Name  : ");
            System.out.println(namaRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.print("Restaurant Adress: ");
            System.out.println(alamatRest.toArray()[j].toString().replace("[", "").replace("]", ""));
            System.out.println("_  __  __  __  __  __  __  __  __  __  __  __  __");
            showMenu(kodeRest.get(j));//pemanggilan fungsi showMenu
        }
    }
    public static void showMenu(String kodeResto) {
        StringTokenizer stringtok = null;
        for (int i = 0; i < menuList.size(); i++) {
            stringtok = new StringTokenizer(menuList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            if (kodeResto.equals(stringtok.nextToken())) {
                System.out.print("Menu Code        : ");
                System.out.println(stringtok.nextToken());
                System.out.print("Menu Name        : ");
                System.out.println(stringtok.nextToken());
                System.out.print("Price            : ");
                System.out.println(stringtok.nextToken());
                System.out.println("_  __  __  __  __  __  __  __  __  __  __  __  __");
            }
        }
    }
    public void deleteResto() {
        if (restoList.size() > 0) {
            System.out.print("Index Number  : ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            restoList.remove(index);
            System.out.println("~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~");
            System.out.println("                  !!A L E R T!!                  ");
            System.out.println("           Data Restoran Telah Dihapus           ");
            System.out.println("~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~");

        }
    }

}
