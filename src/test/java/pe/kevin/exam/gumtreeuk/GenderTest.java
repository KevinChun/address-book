package pe.kevin.exam.gumtreeuk;

import org.junit.Test;
import pe.kevin.exam.guntreeuk.Gender;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Kevin Chun (kechun@ebay.com)
 * Date: 2019-02-19
 */
public class GenderTest {

    @Test
    public void test_convertFromString_successfully() {
       String test = "Male";

       Gender gender = Gender.valueOf(test);
       assertThat(gender).isEqualTo(Gender.Male);
    }
}
