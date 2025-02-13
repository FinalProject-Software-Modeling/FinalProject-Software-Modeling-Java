/** This file contains the definition of the logic to handle a Admin **/

package SM_Project.DigitalWallet.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SM_Project.DigitalWallet.repositories.Admin;
import SM_Project.DigitalWallet.repositories.AdminRepositories;
import SM_Project.DigitalWallet.repositories.Admin;
import SM_Project.DigitalWallet.repositories.Customer;
import SM_Project.DigitalWallet.repositories.AuthUserDTO;

@Service
public class AdminServices {
    
    @Autowired

    public  AdminRepositories adminRepositories;

    public Optional <Admin> getById(String adminId) {
        return adminRepositories.getById(adminId);
    }

    public Optional<Admin> login(Admin authData) {
        if (authData.getId() == null || authData.getPassword() == null) {
            return Optional.empty();
        
        }else {
            return adminRepositories.login(authData);
        }
    }

    public Admin register(Admin admin) {
        if (admin.idNumber == null || admin.idType == null || admin.password == null || admin.phone == null  || admin.firstName == null || admin.lastName == null || admin.email == null) {
            return null;
        }else {
            return adminRepositories.register(admin);
        }

         
    }


    public void createTicket(String walletId, String description) {
        adminRepositories.createTicket(walletId, description);
    }

    public String showTickets(String walletId) {
        return adminRepositories.showTickets(walletId);
    }
    
    public void reportAccount(String walletId) {
        adminRepositories.reportAccount(walletId);
    }
}
