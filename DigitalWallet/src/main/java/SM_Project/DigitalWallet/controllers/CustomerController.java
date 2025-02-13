/**This file has the definition of the Customer endpoints int the application **/

package SM_Project.DigitalWallet.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SM_Project.DigitalWallet.repositories.Customer;
import SM_Project.DigitalWallet.services.CustomerServices;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/getById/{IdCustomer}")
    public  Optional <Customer> getById(@PathVariable("IdCustomer") String customerId) {
        return customerServices.getById(customerId);
    } 

    @PostMapping("/login")
    public Optional<Customer> login(@RequestBody Customer authData) {
        return customerServices.login(authData);

    }

   

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        return customerServices.register(customer);
    }



   
    
    
    

}
