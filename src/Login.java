import java.util.Scanner;
public class Login {
    public static boolean Logins() {
        static User users = new User();
        static Scanner input = new Scanner(System.in);
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
}
