import java.util.Scanner;

public class customerMenu {
    static Scanner input = new Scanner(System.in);
    static MealMate menus = new MealMate();

    public static void Customer(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("         > C U S T O M E R   M E N U <           ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("||  [1] Order           ||  [3] Find Resto     ||");
        System.out.println("||  [2] Check Order     ||  [4] Back to Login  ||");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Choose Menu: ");
        int pilihan = Integer.parseInt(input.nextLine());
        if (pilihan == 3) {
            Resto.showResto();
            Customer();
        } else if (pilihan == 1) {
            Orders.addPesanan();
            Customer();
        } else if (pilihan == 2) {
            Orders.showPesanan();
            Customer();
        } else if (pilihan == 4) {
            menus.menu();
        } else {
            System.exit(0);
        }
    }
}
