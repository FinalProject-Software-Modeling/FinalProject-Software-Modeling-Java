package SM_Project.DigitalWallet.repositories;
import java.util.Map;


public class Customer extends User{


    public String walletId;
    public String firstName;
    public String lastName;
    public String email;
    public String currentAddress;
    public String haveTicket;
    public static Map<String, String> tickets;
   
    public Customer(String idType, String idNumber, String password, String phone, String walletId, String firstName, String lastName, String email, String currentAddress) {
        super();
        this.idType = idType;
        this.idNumber = idNumber;
        this.password = password;
        this.phone = phone;
        
        this.walletId = walletId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.currentAddress = currentAddress;
        

    }
        
    
   

    
    
    public String getWalletId(String id_number) {
        return walletId;
    }
    public String getId() {
        return idNumber;

    }
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getHaveTicket() {
        return haveTicket;
    }

    public static Map<String, String> getTickets() {
        return tickets;
    }
    public String getWalletStatus(String walletId) {
        /*    Dao traera estado del json*/
        return walletId;
    }
    public void setWalletStatus(String status) {
      
    }

    public void changeAddress(String address) {
        this.currentAddress = address;
        
    }

    
}
