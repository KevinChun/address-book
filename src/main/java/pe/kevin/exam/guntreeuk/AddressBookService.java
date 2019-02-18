package pe.kevin.exam.guntreeuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
@Service
public class AddressBookService {

    private String dataFilePath = "addressBook-data.txt";

    @Autowired
    private AddressBookDataLoader addressBookDataLoader;

    public long getNumberByGender(Gender gender) {

        List<AddressBook> data = getAddressBooks();
        return data.stream().filter(a -> a.getGender().equals(gender)).count();
    }

    private List<AddressBook> getAddressBooks() {
        return addressBookDataLoader.load(dataFilePath);
    }

    public AddressBook getOldestAddressBook() {
        return getAddressBooks()
                .stream()
                .sorted((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()))
                .findFirst()
                .get();
    }

    public Optional<AddressBook> getByName(String name){
        return getAddressBooks()
                .stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
    }

    public long getDaysBetween(String sourceName, String targetName) {
        Optional<AddressBook> source = getByName(sourceName);
        Optional<AddressBook> target = getByName(targetName);

        if(!source.isPresent() || !target.isPresent()) return 0;

        LocalDate sourceBirthDate = source.get().getBirthDate();
        LocalDate targetBirthDate = target.get().getBirthDate();

        return sourceBirthDate.until(targetBirthDate, ChronoUnit.DAYS) + 1; // because the result excludes end date
    }
}
