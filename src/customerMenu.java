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
        System.out.print("                  Choose Menu>> ");
        int option = Integer.parseInt(input.nextLine()); //mengubah string dalam option menjadi int
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (option == 1) {
            Orders.addPesanan();//Pemanggilan method addPesanan pada kelas Orders
            Customer();
        } else if (option == 2) {
            Orders.showPesanan();
            Customer();
        } else if (option == 3) {
            Resto.showResto();
            Customer();
        } else if (option == 4) {
            menus.menu();//Pemanggilan method menu pada kelas MealMate
        } else {
            System.out.println("\n                  !!A L E R T!!                  ");
            System.out.println("              Pilihan Tidak Sesuai!              ");
            System.out.println("               Silakan Input Ulang               ");
            Customer();
        }
    }
}
