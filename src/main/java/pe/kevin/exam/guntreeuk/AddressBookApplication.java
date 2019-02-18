package pe.kevin.exam.guntreeuk;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
@SpringBootApplication
public class AddressBookApplication implements CommandLineRunner {

    @Autowired
    private AddressBookService addressBookService;

    public static void main(String[] args){
        SpringApplication.run(AddressBookApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Let's run exam test. Below presents questions and answers.");
        System.out.println("==========================================================");

        System.out.println(Strings.EMPTY);
        System.out.println("Q1: How many males are in the address book");
        System.out.println(String.format("A1: %d", addressBookService.getNumberByGender(Gender.Male)));

        System.out.println(Strings.EMPTY);
        System.out.println("Q2: Who is the oldest person in the address book?");
        System.out.println(String.format("A2: %s", addressBookService.getOldestAddressBook().getName()));

        System.out.println(Strings.EMPTY);
        System.out.println("Q3: How many days older is Bill than Paul?");
        System.out.println(String.format("A3: %d days", addressBookService.getDaysBetween("Bill McKnight", "Paul Robinson")));

        System.out.println(Strings.EMPTY);
        System.out.println("Test end!");
        System.out.println("==========================================================");
    }
}
