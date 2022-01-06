package co.com.sofka.tddavanzado;

import java.util.ArrayList;

public class StringCalculator {
    public int add(String values) throws Exception { //"1,1"
        if(values.length() > 0) {
            int temp;
            String delimiter = null;
            try {
                System.out.println("Char at 0 " + values.charAt(0));
            } catch(Exception e) {
                System.out.println("1" + values.charAt(0));
                if(("" + values.charAt(0)) == "-") {
                    delimiter = null;
                } else {
                    delimiter = "" + values.charAt(0);
                }
            }

            int contador = 0;

            for(int i=0; i<values.length(); i++){
                if(String.valueOf(values.charAt(i)).equals("[")){
                    String substring1 = values.substring(0, i);
                    int index2 = values.indexOf("]");
                    String substring2 = values.substring(index2+1, values.length());
                    values = contador>0 ? substring1 + substring2: substring1+ "," + substring2;
                    contador = contador + 1;
                }

            }

            String[] splittedList = null;
            if(delimiter != null) {
                splittedList = values.substring(1, values.length()).split(delimiter);
            } else {
                splittedList = values.split("[,|\n]");
            }

            ArrayList<Integer> numberList = new ArrayList<Integer>();
            int accumulator = 0;
            for(String element: splittedList) {
                int tempValue = Integer.parseInt(element);
                if(tempValue < 0) {
                    throw new Exception("NegativeNumberException");
                }
                if(tempValue > 1000) {
                    continue;
                }
                numberList.add(tempValue);
            }
            for(Integer number: numberList) {
                accumulator += number;
            }
            return accumulator;
        }
        return 0;
    }
}
