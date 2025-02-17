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
   
    

    
    
}
