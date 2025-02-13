package SM_Project.DigitalWallet.repositories;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

public class Customer extends User{


    public String walletId;
    public String firstName;
    public String lastName;
    public String email;
    public String currentAddress;
    public String haveTicket;
    public String ticket;
    public String path = "data/users_data.json";
    public Customer(String idType, String idNumber, String password, String phone, String walletId, String firstName, String lastName, String email, String currentAddress, String haveTicket, String ticket) {
        
        this.idType = idType;
        this.idNumber = idNumber;
        this.password = password;
        this.phone = phone;
        
        this.walletId = walletId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.currentAddress = currentAddress;
        this.haveTicket = haveTicket;
        this.ticket = ticket;
        

    }
    
    
   
    public String getId() {
        return idNumber;

    }
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getHaveTicket() {
        return haveTicket;
    }

    public String getTicket() {
        return ticket;
    }
    
  

   
    
    public String getWalletStatus(String walletId) {
        /*    Dao traera estado del json*/
        return walletId;
    }
    

    public void changeAddress(String idNumber, String newAddress) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new FileNotFoundException("File not found: " + path);
            }
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("idNumber").equals(idNumber)) {
                    jsonObject.put("currentAddress", newAddress);
                    break;
                }
            }
            try (FileWriter file = new FileWriter(getClass().getClassLoader().getResource(path).getPath())) {
                file.write(jsonArray.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
