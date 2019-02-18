import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */

@Getter
@Setter
public class AddressBook {
    private String name;

    private Genter gender;

    private LocalDate birthDate;
}
