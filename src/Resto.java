import java.util.ArrayList;
import java.util.Scanner;
public class Resto {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Food Ordering System ---\n");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("\n--- Login ---\n");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.print("Enter your choice: ");
                int loginChoice = input.nextInt();

                if (loginChoice == 1) {
                    // Jika login sebagai admin
                    System.out.println("\n--- Admin Menu ---\n");
                    System.out.println("1. View Restaurants");
                    System.out.println("2. Add Restaurant");
                    System.out.println("3. Delete Restaurant");
                    System.out.println("4. Logout");
                    System.out.print("Enter your choice: ");
                    int adminChoice = input.nextInt();
                }
            }
        }
    }
}