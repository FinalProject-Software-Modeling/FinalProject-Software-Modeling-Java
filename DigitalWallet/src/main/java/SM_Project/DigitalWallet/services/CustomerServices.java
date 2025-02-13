/** This file contains the definition of the logic to handle a Customer **/


package SM_Project.DigitalWallet.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SM_Project.DigitalWallet.repositories.Customer;
import SM_Project.DigitalWallet.repositories.CustomerRepositories;

@Service
public class CustomerServices {
    @Autowired

    public  CustomerRepositories customerRepositories;

    public Optional <Customer> getById(String customerId) {
        return customerRepositories.getById(customerId);
    }

    public Optional<Customer> login(Customer authData) {
        if (authData.getId() == null || authData.getPassword() == null) {
            return Optional.empty();
        
        }else {
            return customerRepositories.login(authData);
        }
    }

    public Customer register(Customer customer) {
        if (customer.idNumber == null || customer.idType == null || customer.password == null || customer.phone == null  || customer.walletId == null || customer.firstName == null || customer.lastName == null || customer.email == null || customer.currentAddress == null || customer.haveTicket == null || customer.ticket == null) {
            return null;
        }else {
            return customerRepositories.register(customer);
        }

         
    }
    public String getWalletId(String idNumber) {
        return customerRepositories.getWalletId(idNumber);
    }
    public String createWalletId(String idNumber) {
        return customerRepositories.createWalletId(idNumber);
    }
    
    
    
}
