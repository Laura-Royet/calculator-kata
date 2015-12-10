package org.linagora.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    /**
    *    1. An empty (or null) string returns zero ("" -> 0)
    *    2. A single number returns the value ("3" -> 3)
    *    3. Two numbers, comma delimited, returns the sum ("3,4" -> 7)
    *    4. Two numbers, newline delimited, returns the sum ("3\n4" -> 7)
    *    5. Three numbers, delimited either way, returns the sum ("3,4\n2" -> 9)
    *    6. Negative numbers throw an exception ("3,4\n-2" -> Exception)
    *    7. Numbers greater than 1000 are ignored ("3,4\n1002" -> 7)
    **/

    private StringCalculator testee ;

    @Before
    public void setUp(){
        testee = new StringCalculator() ;
    }

    @Test
    public void calculatorShouldReturnZeroWhenEmptyString(){
        int value = testee.calculate("") ;
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void calculatorShouldReturnZeroWhenNullString(){
        int value = testee.calculate(null) ;
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void calculatorShouldReturnValueWhenSingleNumber(){
        int value = testee.calculate("3") ;
        assertThat(value).isEqualTo(3);
    }

    @Test
    public void calculatorShouldReturnSumWhenCommaDelimited(){
        int value = testee.calculate("3,4") ;
        assertThat(value).isEqualTo(7);
    }

    @Test
    public void calculatorShouldReturnSumWhenNewlineDelimited(){
        int value = testee.calculate("3\n4") ;
        assertThat(value).isEqualTo(7);
    }

    @Test
    public void calculatorShouldReturnSumWhenEitherWayDelimited(){
        int value = testee.calculate("3,4\n2") ;
        assertThat(value).isEqualTo(9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculatorShouldThrowWhenNegativeNumber(){
        testee.calculate("3,4\n-2") ;
    }

    @Test
    public void calculatorShouldIgnoreWhenNumberGreaterThan1000(){
        int value = testee.calculate("3,4\n1002") ;
        assertThat(value).isEqualTo(7);
    }
}
