import java.util.ArrayList;
import java.util.List;

public class Authentication {

  private List<Admin> admins = new ArrayList<>();
  private List<Customer> customers = new ArrayList<>();

  public boolean register(String walletId, String password, String usertype) {
    if (usertype.equals("admin")) {
      Admin admin = new Admin();
      admin.walletId = walletId;
      admin.password = password;
      admin.state = "active";
      admins.add(admin);
      return true;
    } else if (usertype.equals("customer")) {
      Customer customer = new Customer(walletId, password, "active");
      customers.add(customer);
      return true;
    } else {
      return false;
    }
  }

  public boolean authenticate(String walletId, String password, String usertype) {
    if (usertype.equals("admin")) {
      for (Admin admin : admins) {
        if (admin.walletId.equals(walletId) && admin.password.equals(password)) {
          return true;
        }
      }
    } else if (usertype.equals("customer")) {
      for (Customer customer : customers) {
        if (customer.walletId.equals(walletId) && customer.password.equals(password)) {
          return true;
        }
      }
    }
    return false;
  }
}



