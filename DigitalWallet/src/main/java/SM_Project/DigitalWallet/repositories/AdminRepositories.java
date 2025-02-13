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
public class AdminRepositories {
    private List<Admin> admins = new ArrayList<>();
    private final String path = "data/admins_data.json";

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

                Admin newAdmin = new Admin(
                    jsonObject.getString("idType"),
                    jsonObject.getString("idNumber"),
                    jsonObject.getString("password"),
                    jsonObject.getString("phone"),
                    jsonObject.getString("firstName"),
                    jsonObject.getString("lastName"),
                    jsonObject.getString("email")
                );
                admins.add(newAdmin);
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

        
        for (Admin admin: admins) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("idType", admin.idType);
            jsonObject.put("idNumber", admin.idNumber);
            jsonObject.put("password", admin.password);
            jsonObject.put("phone", admin.phone);
            jsonObject.put("firstName", admin.firstName);
            jsonObject.put("lastName", admin.lastName);
            jsonObject.put("email", admin.email);
            
            jsonArray.put(jsonObject);
        }

        
        try (FileWriter file = new FileWriter(getClass().getClassLoader().getResource(path).getPath())) {
            file.write(jsonArray.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<Admin> getById(String adminId) {
        for (Admin admin : this.admins) {
            if (admin.getId().equals(adminId)) {
                return Optional.of(admin);
            }
        }
        return Optional.empty();
    }

    public Optional<Admin> login(Admin authData) {
        for (Admin admin : this.admins) {
            if (admin.getId().equals(authData.getId()) && admin.getPassword().equals(authData.getPassword())) {
                return Optional.of(admin);
            }
        }
        return Optional.empty();
    }

    public Admin register(Admin admin) {
        int lastId = -1;
        for (Admin existingAdmin : this.admins) {
            if (Integer.parseInt(existingAdmin.getId()) > lastId) {
                lastId = Integer.parseInt(existingAdmin.getId());
            }
        }
        lastId += 1;

        Admin newAdmin = new Admin(
            admin.idType,
            String.valueOf(lastId),
            admin.password,
            admin.phone,
            admin.firstName,
            admin.lastName,
            admin.email );

        this.admins.add(newAdmin);
        this.saveData();

        return newAdmin;
    }

}
