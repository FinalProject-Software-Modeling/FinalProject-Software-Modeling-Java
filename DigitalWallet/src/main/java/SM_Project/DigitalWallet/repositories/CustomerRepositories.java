package SM_Project.DigitalWallet.repositories;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerRepositories {

    public List<Customer> customers = new ArrayList<>();
    public final String path = "data/users_data.json";
    @PostConstruct
    public void init() {
        this.loadData();
    }

    private void loadData() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
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
                    jsonObject.getString("currentAddress"),
                    jsonObject.getString("haveTicket"),
                    jsonObject.getString("ticket")
                );
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        JSONArray jsonArray = new JSONArray();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is != null) {
                String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                jsonArray = new JSONArray(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Customer customer : customers) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idType", customer.idType);
            jsonObject.put("idNumber", customer.idNumber);
            jsonObject.put("password", customer.password);
            jsonObject.put("phone", customer.phone);
            jsonObject.put("walletId", customer.walletId);
            jsonObject.put("firstName", customer.firstName);
            jsonObject.put("lastName", customer.lastName);
            jsonObject.put("email", customer.email);
            jsonObject.put("currentAddress", customer.currentAddress);
            jsonObject.put("haveTicket", customer.haveTicket);
            jsonObject.put("ticket", customer.ticket);
            jsonArray.put(jsonObject);
        }

        try (FileWriter file = new FileWriter(getClass().getClassLoader().getResource(path).getPath())) {
            file.write(jsonArray.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<Customer> getById(String customerId) {
        for (Customer customer : this.customers) {
            if (customer.getId().equals(customerId)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public Boolean login(Customer authData) {
        boolean tempBoolean = false;
        for (Customer customer : this.customers) {
            if (customer.getId().equals(authData.getId()) && customer.getPassword().equals(authData.getPassword())) {
                tempBoolean = true;
                return tempBoolean;
            }
        }
        return tempBoolean;
    }

    public Customer register(Customer customer) {
        int lastId = -1;
        for (Customer existingCustomer : this.customers) {
            if (Integer.parseInt(existingCustomer.getId()) > lastId) {
                lastId = Integer.parseInt(existingCustomer.getId());
            }
        }
        lastId += 1;

        Customer newCustomer = new Customer(
            customer.idType,
            String.valueOf(lastId),
            customer.password,
            customer.phone,
            customer.walletId,
            customer.firstName,
            customer.lastName,
            customer.email,
            customer.currentAddress,
            customer.haveTicket,
            customer.ticket
        );

        this.customers.add(newCustomer);
        this.saveData();

        return newCustomer;
    }

    public String getWalletId(String idNumber) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new FileNotFoundException("File not found: " + path);
            }
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("idNumber").equals(idNumber)) {
                    return jsonObject.getString("walletId");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createWalletId(String idNumber) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new FileNotFoundException("File not found: " + path);
            }
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.getString("idNumber").equals(idNumber)) {
                    if (jsonObject.getString("walletId").isEmpty()) {
                        jsonObject.put("walletId", idNumber);
                    } else {
                        return "The user already has a wallet";
                    }
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
        return idNumber;
 
 
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