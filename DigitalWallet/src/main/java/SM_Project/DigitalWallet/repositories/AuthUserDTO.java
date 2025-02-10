package SM_Project.DigitalWallet.repositories;

public class AuthUserDTO {

    private String userId = null;
    private String password= null;

    public AuthUserDTO( String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    public String getUserId(){
        return this.userId;
        
    }

}