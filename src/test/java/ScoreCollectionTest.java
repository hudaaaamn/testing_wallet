import org.example.ScoreCollection;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCollectionTest {
    @Test
    void testScore() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(5);
        scoreCollection.addScore(3);
        Assertions.assertEquals(4, scoreCollection.averageScore());
    }}