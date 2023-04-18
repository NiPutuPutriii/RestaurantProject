public class MealMate {
    static Login signin = new Login();
    static adminMenu admins = new adminMenu();

    public static void menu() {
        int check = 2;
        do {
            //pengecekan kondisi dari method Logins pada class Login
            if (signin.Logins()) {
                check = 1;
                //Pengecekan kondisi apakah true atau false
                if (signin.users.getStatus().equals("Admin")) {
                    admins.Admin();
                } else if (signin.users.getStatus().equals("Customer")) {
                    customerMenu.Customer();
                }
            } else {
                System.out.println("                  !!A L E R T!!                  ");
                System.out.println("          Username atau Password Salah!          ");
                System.out.println("               Silakan Log In ulang              ");
            }
        } while (check == 2);
    }

    //Fungsi utama yang dimunculkan di awal program
    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("||               M e a l M a t e               ||");
        System.out.println("||           ..Your Food Companion..           ||");
        System.out.println("*************************************************");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        menu(); //Memanggil method menu
    }
}

