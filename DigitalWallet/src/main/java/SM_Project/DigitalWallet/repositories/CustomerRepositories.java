package SM_Project.DigitalWallet.repositories;
import org.springframework.stereotype.Repository;



import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.json.JSONArray;
import org.json.JSONObject;

import SM_Project.DigitalWallet.repositories.AuthUserDTO;
import SM_Project.DigitalWallet.repositories.Customer;








@Repository
public class CustomerRepositories {
    
    private List <Customer> customers = new ArrayList<Customer>();


    @PostConstruct
    public void init(){
        this.loadData();

    }
    private void loadData(){
       String path = "data/users.json";
       try(InputStream is = getClass().getClassLoader().getResourceAsStream(path)){
          if (is == null) {
              throw new FileNotFoundException("File not found " + path);
          }
          String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
          JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                
                Customer customer = new Customer(
                    jsonObject.getString("idType"),
                    jsonObject.getString("idNumber"),
                    jsonObject.getString("password"),
                    jsonObject.getString("phone"),
                    jsonObject.getString("walletId"),
                    jsonObject.getString("firstName"),
                    jsonObject.getString("lastName"),
                    jsonObject.getString("email"),
                    jsonObject.getString("currentAddress")
        
                );
                customers.add(customer);

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Optional<Customer> getById(String customerId) {
        for (Customer customer : this.customers) {
            if (customer.idNumber.equals(customerId)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }
    public Optional<Customer> login(Customer authData) {
        for (Customer customer : this.customers) {
            if (customer.idNumber.equals(authData.getId()) && customer.password.equals(authData.getPassword())) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }




    public Customer register(Customer customer) {
        int lastId =  - 1;
        for (Customer existingCustomer : this.customers) {
            if (Integer.parseInt(existingCustomer.idNumber) > lastId) {
                lastId = Integer.parseInt(existingCustomer.idNumber);
            }
        }
        lastId+=1;

        Customer newCustomer= new Customer(
            customer.idType,
            String.valueOf(lastId),
            customer.password,
            customer.phone,
            customer.walletId,
            customer.firstName,
            customer.lastName,
            customer.email,
            customer.currentAddress
        );
        
        this.customers.add(newCustomer);

        return newCustomer;
    }
}


    