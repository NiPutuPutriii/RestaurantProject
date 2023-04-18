import java.util.Scanner;
public class Login{
    static User users = new User();
    static Scanner input = new Scanner(System.in);
    public static boolean Logins() {
        boolean isCheck = false;
        users.setUsername("admin");
        users.setPassword("admin");

        users.setUsername_cust("customer");
        users.setPassword_cust("customer");

        String username ,password;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("             > L O G I N   H E R E <             ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();

        //Pengecekan kondisi menggunakan operator logika
        if (users.getUsername().equals(username) || users.getUsername_cust().equals(username)) {
            if (users.getPassword().equals(password)) {
                users.setStatus("Admin");
                isCheck = true;
            } else if (users.getPassword_cust().equals(password)) {
                users.setStatus("Customer");
                isCheck = true;
            }
        }
        return isCheck;
    }
}
