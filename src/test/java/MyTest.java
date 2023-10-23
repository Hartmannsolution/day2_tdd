import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("R1: Given a string with a name When calling methodForTest returns a greeting with Hello")
    public void firstTest(){
        String actual = new ClassForTest().methodForTest("Arthur");
        String expected = "Hello Arthur.";
        assertEquals( expected, actual);
    }
    @Test
    @DisplayName("R2: Given a null value When calling methodForTest returns a greeting with Hello, my Friend")
    public void secondTest(){
        String actual = new ClassForTest().methodForTest(null);
        String expected = "Hello, My Friend.";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("R3: Given an Object value When calling methodForTest returns a greeting with Hello + input")
    public void thirdTest(){
        String actual = new ClassForTest().methodForTest("Jane").toString();
        String expected = "Hello Jane.";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("R4: Given a String array When calling methodForTest returns a greeting with Hello names separated by 'and'")
    public void fourthTest(){
        String actual = new ClassForTest().methodForTest(new String[]{"Nanna", "Pernille"}).toString();
        String expected = "Hello Nanna and Pernille.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("R5: Given a String array with more than 2 names When calling methodForTest returns a greeting with Hello names separated by first commas and lastly 'and'")
    public void fifthTest(){
        String actual = new ClassForTest().methodForTest(new String[]{"Nanna","Paula","Pernille"}).toString();
        String expected = "Hello Nanna, Paula and Pernille.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("R6: Given a String array with mixed Shouting and non-shouting names When calling methodForTest returns 2 different greetings with normal hello and shouting HELLO respectively")
    public void sixthTest(){
        String actual = new ClassForTest().methodForTest(new String[]{"Nanna","PAULA","Pernille"}).toString();
        String expected = "Hello Nanna and Pernille. AND HELLO PAULA!";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("R7: Given a String array with strings containing comma When calling methodForTest Then return a greeting with names both from the array and from the comma separated string")
    public void seventhTest(){
        String actual = new ClassForTest().methodForTest(new String[]{"Nanna","PAULA","Pernille,Hanna,Susan"}).toString();
        String expected = "Hello Nanna, Pernille, Hanna and Susan. AND HELLO PAULA!";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("R8: Given a String array with strings containing comma, but in quotes When calling methodForTest Then return a greeting with name unsplit")
    public void eighthTest(){
        String actual = new ClassForTest().methodForTest(new String[]{"Bob", "\"Charlie, Diane\""}).toString();
        String expected = "Hello Bob and Charlie, Diane.";
        assertEquals(expected, actual);
    }
}
