package org.linagora.stringcalculator;

public class StringCalculator {

    public int calculate(String valueAsString)throws IllegalArgumentException {
        if (valueAsString == null || valueAsString.isEmpty()  ){
            return 0;
        }
        String[] numbers = valueAsString.split(",|\n");

        int sum = 0;
        for(String number : numbers){
            int result = Integer.valueOf(number);
            if(result < 0){
                throw new IllegalArgumentException();
            }
            if (result > 1000){
                continue;
            }
            sum +=  result;
        }

        return sum;
    }
}
