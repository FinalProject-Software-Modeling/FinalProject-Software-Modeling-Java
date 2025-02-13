/**This file has the definition of the Admin endpoints int the application **/
package SM_Project.DigitalWallet.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SM_Project.DigitalWallet.repositories.Admin;
import SM_Project.DigitalWallet.services.AdminServices;


@RestController
@RequestMapping("v1/admin")
public class AdminController {
     @Autowired
    private AdminServices adminServices;
    
    
   
    @GetMapping("/getById/{IdAdmin}")
    public  Optional <Admin> getById(@PathVariable("IdAdmin") String adminId) {
        return adminServices.getById(adminId);
    } 

    @PostMapping("/login")
    public Optional<Admin> login(@RequestBody Admin authData) {
        return adminServices.login(authData);

    }

   

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminServices.register(admin);
    }

    
}
