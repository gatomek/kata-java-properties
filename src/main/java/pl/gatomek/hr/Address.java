package pl.gatomek.hr;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Address {

    public Address( String city)
    {
        this.city = city;
    }

    private String city;
    private String street;
    private int streetNo;
    private String postalCode;
}
