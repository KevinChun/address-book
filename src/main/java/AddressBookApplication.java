import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
@SpringBootApplication
public class AddressBookApplication implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(AddressBookApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
