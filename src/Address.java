
public class Address{

    private String street;  
    private String apartment;
    private String city;
    private String country; 
    private String zipCode;


    @Override
    public String toString() {
        return street + ", " + (apartment != null ? "Apt " + apartment + ", " : "") + city + ", " + country + " - " + zipCode;
    }
}