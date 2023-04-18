import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Orders {
    static ArrayList<Object> orderList = new ArrayList<Object>();
    static ArrayList<Object> menuList = new ArrayList<Object>();
    static String kodeResto;
    static Scanner input = new Scanner(System.in);
    public static void addPesanan() {
        int jarak = (int) (Math.random()*3) + 2;
        System.out.print("Masukan kode resto: ");
        kodeResto = input.nextLine();
        Resto.showMenu(kodeResto);
        int[] harga = new int[100];
        int[] sub_total = new int[100];
        int[] kuantitas = new int[100];
        String[] menu = new String[100];
        String[] kode = new String[100];
        String[] kode_menu = new String[100];
        int total = 0;
        // proses pemesanan
        StringTokenizer stringtok = null;
        for (int i = 0; i < menuList.size(); i++) {
            stringtok = new StringTokenizer(menuList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            if (kodeResto.equals(stringtok.nextToken())) {
                kode[i] = stringtok.nextToken().trim();
                menu[i] = stringtok.nextToken().trim();
                harga[i] = Integer.parseInt(stringtok.nextToken().trim());
            }
        }
        System.out.print("Banyak Pesanan: ");
        int banyak = Integer.parseInt(input.nextLine());
        for (int i = 0; i < banyak; i++) {
            System.out.print("Masukkan kode menu: ");
            kode_menu[i] = input.nextLine();
            System.out.print("Kuantitas: ");
            kuantitas[i] = Integer.parseInt(input.nextLine());
            if (kode_menu[i].equals(kode[i])) {
                sub_total[i] = kuantitas[i] * harga[i];
                System.out.println("Sub Total: "+sub_total[i]);
            }
            total += sub_total[i];
            orderList.add(Arrays.asList(jarak, kodeResto, kode_menu[i], kuantitas[i], sub_total[i]));
        }
        System.out.println("Total Pemesanan: " + total);
    }
    public static void showPesanan() {
        StringTokenizer stringtok = null;
        for (int i = 0; i < orderList.size(); i++) {
            stringtok = new StringTokenizer(orderList.toArray()[i].toString().replace("[", "").replace("]", ""), ",");
            System.out.print("Jarak: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Kode Resto: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Kode Menu: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Kuantitas: ");
            System.out.println(stringtok.nextToken());
            System.out.print("Sub Total: ");
            System.out.println(stringtok.nextToken());
        }
        System.out.println(orderList.toString());
        System.out.println(orderList.size());
    }

}
