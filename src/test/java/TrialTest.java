
import org.example.Trial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TrialTest {
    @Test
    void testTrialMethod() {
        Trial trial = new Trial();
        assertEquals("Test",trial.trialMethod());
    }

    @Test
    void testTrialMethod2() {
        System.out.println("Testing");
    }

    @Test
    void testTrialMethod3() {
        Trial trial = new Trial();
        assertSame("Test",trial.trialMethod());
    }

}

