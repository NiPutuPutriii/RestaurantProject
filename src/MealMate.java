import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MealMate to {
    static User users = new User();
    static Scanner input = new Scanner(System.in);
    static int pilihan;
    static ArrayList<Object> restoList = new ArrayList<Object>();
    static ArrayList<Object> menuList = new ArrayList<Object>();
    static String nama, alamat, kodeResto;
    static String namaMenu, kodeMenu;

    // Ditampilkan apabila users telah berhasil login
    public static void menu() {
        // apabila status user admin
        if (users.getStatus() == "Admin") {
            System.out.println("1. Tambah Resto");
            System.out.println("2. Edit Resto");
            System.out.println("3. Hapus Resto");
            System.out.println("4. Lihat Resto");
            System.out.println("5. Back to Login");
            pilihan = Integer.parseInt(input.nextLine());
            if (pilihan == 1) {
                addResto();
            } else if (pilihan == 4) {
                showResto();
            } else if (pilihan == 3) {
            } else if (pilihan == 2) {
                editResto();
            } else if (pilihan == 5) {
                logins();
            } else {
                System.exit(0);
            }
            // apabila status user customer
        } else if (users.getStatus() == "Customer") {
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Lihat Resto");
            System.out.println("4. Back to Login");
            pilihan = Integer.parseInt(input.nextLine());
            if (pilihan == 3) {
                showResto();
            } else if (pilihan == 1) {
                addPesanan();
            } else if (pilihan == 2) {
                showPesanan();
            } else if (pilihan == 4) {
                logins();
            } else {
                System.exit(0);
            }
        }
    }

    // method login
    public static boolean logins() {
        boolean oke = false;
        users.setUsername("admin");
        users.setPassword("admin");

        users.setUsername_cust("customer");
        users.setPassword_cust("customer");

        String username, password;
        System.out.print("Masukkan username: ");
        username = input.nextLine();
        System.out.print("Masukkan password: ");
        password = input.nextLine();

        if (users.getUsername().equals(username) || users.getUsername_cust().equals(username)) {
            if (users.getPassword().equals(password)) {
                users.setStatus("Admin");
                oke = true;
            } else if (users.getPassword_cust().equals(password)) {
                users.setStatus("Customer");
                oke = true;
            }
        }

        return oke;
    }

    public static void addResto() {
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

    static ArrayList<String> kodeRest, namaRest, alamatRest;
    // static ArrayList<Integer> hargaMenu;

    public static void showResto() {
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

    public static void editResto() {
        if (restoList.size() > 0) {
            System.out.print("Masukkan Nomor Indeks: ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            System.out.print("Kode Restauran: ");
            kodeResto = input.nextLine();
            System.out.print("Nama Restauran: ");
            nama = input.nextLine();
            System.out.print("Alamat Restauran: ");
            alamat = input.nextLine();
            // masukkan dalam arraylist
            restoList.set(index, Arrays.asList(kodeResto, nama, alamat));
        }
    }

    public static void deleteResto() {
        if (restoList.size() > 0) {
            System.out.print("Masukkan Nomor Indeks: ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            restoList.remove(index);
        }
    }

    static ArrayList<Object> orderList = new ArrayList<Object>();

    public static void addPesanan() {
        int jarak = (int) (Math.random()*3) + 2;
        System.out.print("Masukan kode resto: ");
        kodeResto = input.nextLine();
        showMenu(kodeResto);
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

    public static void main(String[] args) {
        kodeRest = new ArrayList<>();
        namaRest = new ArrayList<>();
        alamatRest = new ArrayList<>();
        // kodeRestMen = new ArrayList<>();
        // namaMenu2 = new ArrayList<>();
        // hargaMenu = new ArrayList<>();
        // kodeMenu2 = new ArrayList<>();
        if (logins()) {
            while (true) {
                menu();
            }
        } else {
            System.out.println("Username atau Password Salah!");
        }
        // if (logins()) {
        // } else {
        // System.out.println("Username atau Password Salah!");
        // }
    }
}
