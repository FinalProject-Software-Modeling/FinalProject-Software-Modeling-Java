package SM_Project.DigitalWallet.repositories;

public class AuthUserDTO {

    private String userId;
    private String password;

    public AuthUserDTO( String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public String getUserId(){
        return this.userId;
        
    }
    public String getPassword(){
        return this.password;
    }

}