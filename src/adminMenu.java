import java.util.Scanner;
public class adminMenu {
    static Scanner input = new Scanner(System.in);
    static MealMate menus = new MealMate();
    static Resto adding = new Resto();
    public static void Admin() {
        int option;
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("             > A D M I N   M E N U <             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("||  [1] Tambah Resto    ||  [3] Lihat Resto    ||");
        System.out.println("||  [2] Hapus Resto     ||  [4] Back to Login  ||");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Choose Menu: ");
        option = Integer.parseInt(input.nextLine());
        if (option == 1) {
            adding.addResto();
            Admin();
        } else if (option == 2) {
            adding.deleteResto();
            Admin();
        } else if (option == 3) {
            adding.showResto();
            Admin();
        } else if (option == 4) {
            menus.menu();
        } else {
            System.exit(0);
        }
    }
}
