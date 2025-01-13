

import java.util.Map;

public class User {
 
   
        public User() {
           this.state = "active";
        }

        public String walletId;
        public String password;
        public String phone;
        public Map<String, Boolean> grants;
        public String state;
        

        

       
            
        public String getGrants() {
            return grants.toString();
        }

        public void addGrant(String grant) {
            this.grants.put(grant, true);
        }
}

