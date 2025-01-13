import java.util.Map;

public class Customer extends User{
    public Customer(String walletId, String password, String state) {
        super();
        this.walletId = walletId;
        this.state = state;
    }
    public String firstName;
    public String lastName;
    public String email;
    public String idType;
    public String idNumber;
    public Address currentAddress;
    public String haveTicket;
    public static Map<String, String> tickets;


   

    public void addAddress(Address address) {
        this.currentAddress = address;
        
    }
    
    public String getWalletId() {
        return walletId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
