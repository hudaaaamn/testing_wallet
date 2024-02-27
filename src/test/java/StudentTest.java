import org.example.Student;
import org.example.Trial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    void tesIsDoingMBKM() {
        Student student = new Student("hud",6,true);
        Assertions.assertEquals(true,student.isDoingMBKM());
    }
}
