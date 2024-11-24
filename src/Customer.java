


public class Customer extends User{
    public Customer() {
    super();
    
    
    }
    public String firstName;
    public String lastName;
    public String email;
    public String idType;
    public String idNumber;
    public Address currentAddress;

    public void addAddress(Address address) {
        this.currentAddress = address;
    }

}
