package assertj;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@ExtendWith(SerenityJUnit5Extension.class)
public class WhenMakingAssertionsInJava {

    int age = 21;
    List<Integer> ages = Arrays.asList(10, 20, 21, 40);
    @Test
    public void traditionalAssertions() {

        Serenity.reportThat("The traditional tests are working",
                () -> {
                    assertEquals("Age equals 21",21, age);
                    assertTrue("List of ages should contain 21", ages.contains(age));
                });
        }

    @Test
    public void assertJAssertions() {
        assertThat(age)
                .isEqualTo(21)
                .isIn(ages);

        assertThat(ages)
                .contains(21)
                .hasSize(4)
                .allMatch(a -> a >= 0 && a <= 100);

    }
}
