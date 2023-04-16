import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.print.DocFlavor.STRING;

public class Resto2 {
    static String fileName, customerFile, menuFile;
    static int pilihan;
    // untuk menampung array dari program agar mudah dihapus dan diedit
    static ArrayList<String> restoLists, customerList, menuLists;
    static Scanner input = new Scanner(System.in);

    static User users = new User();

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
                try {
                    showResto();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (pilihan == 3) {
                deleteResto();
            } else if (pilihan == 2) {
                editResto();

            } else if(pilihan==5) {
                logins();
            }else{
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
                try {
                    showResto();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (pilihan == 1) {
                try {
                    addPesanan();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if (pilihan == 2) {
                try {
                    showPesanan();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else if(pilihan==4)  {
                logins();
            }else{
                System.exit(0);
            }
        }
    }

    // BAGIAN PEMESANAN
    // meload file pesanan
    public static void cust_inisiasi() {
        try {
            File file = new File(customerFile);
            Scanner fileReader = new Scanner(file);
            customerList.clear();
            // apabila file tidak kosong, maka masukkan kedalam array diawal program
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                customerList.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }

    public static void addPesanan() throws IOException {
        FileWriter filee;
        try {
            // untuk menentukan jarak, scara random
            int jarak = (int) Math.random() + 2;
            // membaca file menu yang telah dibuat
            fl = new FileReader("menu.txt");
            bf = new BufferedReader(fl);

            System.out.print("\nMasukan kode resto: ");
            String kode_resto = input.nextLine();

            // tampilkan data yang ingin diupdate

            String data = bf.readLine();
            System.out.println("\nKode Menu \t |\t Nama Menu |\t Harga");
            System.out.println("---------------------------------------------------");
            int[] harga = new int[100];
            int[] sub_total = new int[100];
            int[] kuantitas = new int[100];
            String[] menu = new String[100];
            String[] kode = new String[100];
            String[] kode_menu = new String[100];

            int count = 0;
            // tampilkan data menu
            while (data != null) {
                StringTokenizer st = new StringTokenizer(data, ",");
                if (kode_resto.equals(st.nextToken())) {
                    kode[count] = st.nextToken();
                    menu[count] = st.nextToken();
                    harga[count] = Integer.parseInt(st.nextToken());
                    // dalam bentuk table
                    System.out.printf("|%3s\t", kode[count]);
                    System.out.printf("\t|%-20s", menu[count]);
                    System.out.printf("|%s", harga[count]);
                    System.out.print("\n");
                    count++;
                }
                data = bf.readLine();
            }
            int total = 0;
            // proses pemesanan

            System.out.print("Banyak Pesanan: ");
            int banyak = Integer.parseInt(input.nextLine());
            filee = new FileWriter(customerFile, true);
            for (int i = 0; i < banyak; i++) {
                System.out.print("Masukkan kode menu: ");
                kode_menu[i] = input.nextLine();
                System.out.print("Kuantitas: ");
                kuantitas[i] = Integer.parseInt(input.nextLine());
                if (kode_menu[i].equals(kode[i])) {
                    sub_total[i] = kuantitas[i] * harga[i];
                    System.out.println(sub_total[i]);
                }
                total += sub_total[i];
                // penulisan kedalam file pesanan
                filee.append(kode_resto + ", ");
                filee.append(kode_menu[i].toString() + ", ");
                filee.append(kuantitas[i] + ", ");
                filee.append(sub_total[i] + ", ");
                filee.append(String.format("%s%n", jarak));
            }
            filee.close();
            System.out.println("Total Pemesanan: " + total);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // method melihat semua pesanan
    public static void showPesanan() throws IOException {
        try {
            fl = new FileReader("pesanan.txt");
            bf = new BufferedReader(fl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n|Resto\t|KD. Menu|Qty|Sub-Total |Jarak");
        System.out.println("-----------------------------------------");
        String data = bf.readLine();
        while (data != null) {
            StringTokenizer stringtok = new StringTokenizer(data, ",");
            System.out.printf("|%s\t", stringtok.nextToken());
            System.out.printf("|%s\t ", stringtok.nextToken());
            System.out.printf("|%s ", stringtok.nextToken());
            System.out.printf("|%s\t", stringtok.nextToken());
            System.out.printf("|%s\t", stringtok.nextToken());
            System.out.print("\n");
            data = bf.readLine();
        }
    }

    // BAGIAN RESTAURANT
    // menampung data file resto
    public static void resto_inisiasi() {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            restoLists.clear();
            // apabila file tidak kosong, maka masukkan kedalam array diawal program
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                restoLists.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }

    static FileReader fl, fm;
    static BufferedReader bf, bm;

    // method melihat resto
    public static void showResto() throws IOException {
        try {
            fl = new FileReader("resto.txt");
            bf = new BufferedReader(fl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n| Nomor | Kode Resto \t |\t Nama Resto |\t Alamat");
        System.out.println("---------------------------------------------------");
        // membaca data resto
        String data = bf.readLine();
        int nomor = 0;
        while (data != null) {
            StringTokenizer stringtok = new StringTokenizer(data, ",");
            System.out.printf("|%2d\t", nomor);
            System.out.printf("|%3s\t", stringtok.nextToken());
            System.out.printf("\t|%-20s", stringtok.nextToken());
            System.out.printf("|%s", stringtok.nextToken());
            System.out.print("\n");
            nomor++;
            data = bf.readLine();
        }

    }

    public static void deleteResto() {
        resto_inisiasi();
        if (restoLists.size() > 0) {
            System.out.print("Masukkan Nomor Indeks: ");
            int index = Integer.parseInt(input.nextLine());
            // menghapus resto dari index
            restoLists.remove(index);
            try {
                // memperbarui data file
                FileWriter filee = new FileWriter(fileName, false);
                for (String data : restoLists) {
                    filee.append(String.format("%s%n", data));
                }
                filee.close();

                System.out.println("Berhasil dihapus!");
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan karena: " + e.getMessage());
            }
        } else {
            System.out.println("Tidak ada data!");
        }
    }

    // method mengubah resto
    public static void editResto() {
        resto_inisiasi();
        // arrylist untuk menampung resto sementara
        ArrayList<Object> resto_list = new ArrayList<Object>();
        if (restoLists.size() > 0) {
            System.out.print("Masukkan Nomor Indeks: ");
            // cari index, dimulai dari 0
            int index = Integer.parseInt(input.nextLine());
            // restoLists.remove(index);
            String nama, alamat, kode_resto;
            System.out.print("Kode Restauran: ");
            kode_resto = input.nextLine();
            System.out.print("Nama Restauran: ");
            nama = input.nextLine();
            System.out.print("Alamat Restauran: ");
            alamat = input.nextLine();
            resto_list.add(kode_resto);
            resto_list.add(nama);
            resto_list.add(alamat);
            // masukkan dalam arraylist
            restoLists.set(index, resto_list.toString().replace("[", "").replace("]", ""));
            try {
                FileWriter filee = new FileWriter(fileName, false);
                // write new data
                for (String data : restoLists) {
                    filee.append(data);
                    filee.append(String.format("%n", ""));
                }
                filee.close();

                System.out.println("Berhasil diubah!");
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan karena: " + e.getMessage());
            }

        }

    }

    // method menambah resto
    public static void addResto() {
        String nama, alamat, menu, kode, kode_menu;
        int banyak_input, harga;

        System.out.print("Kode Restauran: ");
        kode = input.nextLine();
        System.out.print("Nama Restauran: ");
        nama = input.nextLine();
        System.out.print("Alamat Restauran: ");
        alamat = input.nextLine();
        System.out.print("Banyak menu yang diingnikan: ");
        banyak_input = Integer.parseInt(input.nextLine());

        // input menu
        FileWriter file_2;
        for (int i = 0; i < banyak_input; i++) {
            System.out.print("Kode menu: ");
            kode_menu = input.nextLine();
            System.out.print("Nama menu: ");
            menu = input.nextLine();
            System.out.print("Harga: ");
            harga = Integer.parseInt(input.nextLine());
            try {
                file_2 = new FileWriter(menuFile, true);
                file_2.append(kode + ",");
                file_2.append(kode_menu + ",");
                file_2.append(menu + ",");
                file_2.append(String.format("%n", String.valueOf(harga)));
                file_2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // input resto
        FileWriter file_1;
        try {
            file_1 = new FileWriter(fileName, true);
            file_1.append(kode + ",");
            file_1.append(nama + ",");
            file_1.append(alamat);
            file_1.append(String.format("%n", ""));
            file_1.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void main(String[] args) {
        restoLists = new ArrayList<>();
        String filePath = System.console() == null ? "/src/resto.txt" : "/resto.txt";
        fileName = System.getProperty("user.dir") + filePath;

        customerList = new ArrayList<>();
        String filePath2 = System.console() == null ? "/src/pesanan.txt" : "/pesanan.txt";
        customerFile = System.getProperty("user.dir") + filePath2;

        String filePath3 = System.console() == null ? "/src/menu.txt" : "/menu.txt";
        menuFile = System.getProperty("user.dir") + filePath3;

        if (logins()) {
            while (true) {
                menu();
            }
        } else {
            System.out.println("Username atau Password Salah!");
        }
    }
}
