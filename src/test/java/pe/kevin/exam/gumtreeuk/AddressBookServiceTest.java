package pe.kevin.exam.gumtreeuk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pe.kevin.exam.guntreeuk.AddressBook;
import pe.kevin.exam.guntreeuk.AddressBookApplication;
import pe.kevin.exam.guntreeuk.AddressBookService;
import pe.kevin.exam.guntreeuk.Gender;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AddressBookApplication.class)
@ContextConfiguration
public class AddressBookServiceTest {

    @Autowired
    private AddressBookService addressBookService;

    @Test
    public void test_given_Male_then_matchingCount_successfully() {
        long count = addressBookService.getNumberByGender(Gender.Male);

        assertThat(count).isEqualTo(3);
    }

    @Test
    public void test_given_Female_then_matchingCount_successfully() {
        long count = addressBookService.getNumberByGender(Gender.Female);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void test_pick_oldestPerson() {
        AddressBook oldest = addressBookService.getOldestAddressBook();

        assertThat(oldest.getName()).isEqualTo("Wes Jackson");
    }

    @Test
    public void test_comparison_daysOld_between_Bill_And_Paul() {
        String sourceName = "Bill McKnight";
        String targetName = "Paul Robinson";
        long days = addressBookService.getDaysBetween(sourceName, targetName);
        assertThat(days).isEqualTo(2863);
    }
}
