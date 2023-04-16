public class User {
    private String username, password, status;
    private String username_cust, password_cust;

    public String getUsername_cust() {
        return username_cust;
    }

    public void setUsername_cust(String username_cust) {
        this.username_cust = username_cust;
    }

    public String getPassword_cust() {
        return password_cust;
    }

    public void setPassword_cust(String password_cust) {
        this.password_cust = password_cust;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
