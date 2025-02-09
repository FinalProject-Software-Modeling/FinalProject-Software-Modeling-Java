
import java.util.Map;

public class Admin extends User{
    public Admin() {
        super();
    }
    public String firstName;
    public String lastName;
    public String email;
    public String idType;
    public String idNumber;
    
    

    public void createTicket( String walletId, String description, Customer customer) {
        if (grants.get("CreateTicket") == true) {
            if (customer.walletId.equals(walletId)) {
                
                customer.haveTicket = "true";
                
                customer.tickets.put(customer.walletId, description); 
            }
        }
    }
    public void freezeAccount(String walletId, Customer customer) {
        if (grants.get("freezeAccount") == true) {
            
                if (customer.getWalletId().equals(walletId) && customer.haveTicket.equals("true")) {
                    customer.setState("frozen");
                    System.out.println("Account with walletId"+ walletId + " has been frozen");
                }
                else {
                System.out.println("The account with walletId "+ walletId + " does not exist");
                }
        }
        
    }
    public String showTickets(String walletId, Customer customer) {
            if (grants.get("showTickets") == true) {
                if (customer.walletId.equals(walletId) && customer.tickets.size() > 0) {    
                    return customer.tickets.toString();

                }
                else {
                    return "The account with walletId "+ walletId + "does not have  tickets";
                }
            }
            return "You do not have the grants to view the tickets";
            
    }
    public void showMovements(String wallet_id, Customer customer) {
        // Show movements
        
    }

    public void reportAccount(String wallet_id,Customer customer) {
        if (grants.get("reportAccount") == true) {
           
                if (customer.getWalletId().equals(walletId) && customer.haveTicket.equals("true")) {
                    customer.setState("Reported");
                    System.out.println("Account with walletId"+ walletId + " has been reported");
                } 
                else {
                    System.out.println("The account with walletId "+ walletId + " does not exist");
                }
            
            
        }
   
    } 

    
    
}
