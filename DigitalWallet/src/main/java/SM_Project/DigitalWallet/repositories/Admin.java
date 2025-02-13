package SM_Project.DigitalWallet.repositories;
import java.util.HashMap;
import java.util.Map;
public class Admin extends User{
    
    public String firstName;
    public String lastName;
    public String email;
    public Map<String, Boolean> grants;
        
        

        

        
       

    public Admin( String idType, String idNumber, String password, String phone, String firstName, String lastName, String email) {
        
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
    
    
    public String getId() {
        return idNumber;

    }
    public String getPassword() {
        return password;
    }
    
    public String getGrants() {
        return grants.toString();
    }

    public void addGrant(String grant) {
        this.grants.put(grant, true);
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
    public void showMovements(String wallet_id) {
        // Show movements
        
    }

    public void reportAccount(String wallet_id) {
        if (grants.get("reportAccount") == true) {
                
        }
    }       

    
    
}
