import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @org.junit.jupiter.api.Test
    void evaluatePostfix() {
        String input = "72+9/35*-";
        assertEquals(-14, ReversePolishNotation.evaluatePostfix(input));
    }

    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        String input = "a+b*c+(d*e+f)*g";
        assertEquals("abc*+de*f+g*+", ReversePolishNotation.infixToPostfix(input));
    }

}