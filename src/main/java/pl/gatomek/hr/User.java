package pl.gatomek.hr;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString( includeFieldNames = false, onlyExplicitlyIncluded = true)
public class User {
    @ToString.Include
    private String name;

    @ToString.Exclude
    private String surname;

    @ToString.Include
    private int age;
    private List<Address> adresses;
}
