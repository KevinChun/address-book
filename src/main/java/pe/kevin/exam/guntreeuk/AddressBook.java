package pe.kevin.exam.guntreeuk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */

@Getter
@Setter
@AllArgsConstructor
public class AddressBook {
    private String name;

    private Gender gender;

    private LocalDate birthDate;
}
