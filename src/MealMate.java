import java.util.Scanner;

public class MealMate {
    static User users = new User();
    static Scanner input = new Scanner(System.in);
    static Login signin = new Login();

    public static void menu() {
        int check = 2;
        do {
            if (signin.Logins()) {
                check = 1;
                if (signin.users.getStatus().equals("Admin")) {
                    adminMenu.Admin();
                } else if (signin.users.getStatus().equals("Customer")) {
                    customerMenu.Customer();
                }
            } else {
                System.out.println("Username atau Password Salah!");
                System.out.println("Silakan melakukan login ulang!");
            }
        } while (check == 2);
    }
    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("||               M e a l M a t e               ||");
        System.out.println("||           ..Your Food Companion..           ||");
        System.out.println("*************************************************\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("             > L O G I N   H E R E <             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        menu();
    }
}
    // Ditampilkan apabila users telah berhasil login
    /*public static void menu() {
        // apabila status user admin
        if (users.getStatus().equals("admin")) {
            System.out.println("cek12");
            adminMenu admins = new adminMenu();
            admins.Admin();
            // apabila status user customer
        } else if (users.getStatus() == "Customer") {
            customerMenu customers = new customerMenu();
            customers.Customer();
        }
    }

    public static void main(String[] args) {
        if (signin.Logins()) {
            while (true) {
                menu();
            }
        } else {
            System.out.println("Username atau Password Salah!");
        }
    }
}*/
