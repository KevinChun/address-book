package pe.kevin.exam.guntreeuk;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
@Component
public class AddressBookDataLoader {

    public List<AddressBook> load(String path){

        try(Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(path).toURI()))){
            return stream
                    .map(l-> l.split(","))
                    .map(sa -> new AddressBook(sa[0], Gender.valueOf(sa[1].trim()), LocalDate.parse(sa[2].trim(), DateTimeFormatter.ofPattern("dd/MM/yy"))))
                    .collect(Collectors.toList());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
