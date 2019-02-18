import org.junit.Test;
import pe.kevin.exam.guntreeuk.AddressBook;
import pe.kevin.exam.guntreeuk.AddressBookDataLoader;
import pe.kevin.exam.guntreeuk.Gender;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
public class AddressBookDataLoaderTest {

    @Test
    public void test_load_data_successfully() {
        String givenPath = "addressBook-data.txt";
        List<AddressBook> data = new AddressBookDataLoader().load(givenPath);

        assertThat(data).isNotNull();
        assertThat(data.size()).isEqualTo(5);

        AddressBook firstAddressBook = data.get(0);
        assertThat(firstAddressBook.getName()).isEqualTo("Bill McKnight");
        assertThat(firstAddressBook.getGender()).isEqualTo(Gender.Male);
        // java recognize yy formatted year data is 20yy, not 19yy
        // after finish the implementation, let me investigate it.
        assertThat(firstAddressBook.getBirthDate()).isEqualTo(LocalDate.of(1977, 3, 16).plusYears(100));
    }
}
