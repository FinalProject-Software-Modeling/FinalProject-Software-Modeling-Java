package SM_Project.DigitalWallet.repositories;


import java.util.Map;

public class User implements UserFacade {
 
   
        public User() {
           
        }

        public String idType;
        public String idNumber;
        public String password;
        public String phone;
        
        public Map<String, Boolean> grants;
        
        

        

        public void verifyGrants() {
            // TODO Auto-generated method stub
            
        }
        public String getGrants() {
            return grants.toString();
        }

        public void addGrant(String grant) {
            this.grants.put(grant, true);
        }
}

