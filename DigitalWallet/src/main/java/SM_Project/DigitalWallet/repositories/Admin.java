package SM_Project.DigitalWallet.repositories;
import java.util.HashMap;

public class Admin extends User{
    
    public String firstName;
    public String lastName;
    public String email;
    

    public Admin( String idType, String idNumber, String password, String phone, String firstName, String lastName, String email) {
        super();
        this.idType = idType;
        this.idNumber = idNumber;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        grants = new HashMap<>();
        grants.put("CreateTicket", true);
        grants.put("freezeAccount", true);
        grants.put("showTickets", true);
        grants.put("showMovements", true);
        grants.put("reportAccount", true);
    }
    
    
    

    public void createTicket( String walletID, String description) {
        if (grants.get("CreateTicket") == true) {

           
        }
    }
    public void freezeAccount(String walletId, String status) {
        if (grants.get("freezeAccount") == true) {
            
                
        }
        
    }
    public void showTickets(String walletId) {
            if (grants.get("showTickets") == true) {
                
            }
            
    }
    public void showMovements(String wallet_id, Customer customer) {
        // Show movements
        
    }

    public void reportAccount(String wallet_id,Customer customer) {
        if (grants.get("reportAccount") == true) {
           
               
            
            
        }
   
    } 

    
    
}
