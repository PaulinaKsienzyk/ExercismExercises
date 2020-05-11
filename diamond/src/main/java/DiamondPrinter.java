
import java.util.Arrays;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        List<String> diamondList;
        int numberOfChar = Character.getNumericValue(a) - Character.getNumericValue('A') + 1;
        int length = numberOfChar + (numberOfChar - 1);
        int count = 0;
        int reverseCount = numberOfChar - 1;

        StringBuilder sB = new StringBuilder();
        while (count < length) {
            for(int i = 1; i<=length; i++) {
                if(count >= numberOfChar) {
                    if(i == (numberOfChar-reverseCount) || i == (numberOfChar + reverseCount)) {
                        sB.append((char) ('A' + reverseCount));
                    } else {
                        sB.append(" ");
                    }
                }else {
                    if(i == (numberOfChar-count) || i == (numberOfChar + count)) {
                        sB.append((char) ('A' + count));
                    } else {
                        sB.append(" ");
                    }
                }
            }


            sB.append("\n");
            count++;

            if(count >= numberOfChar) {
                reverseCount--;
            }
        }

        String[] array = sB.toString().split("\n");
        diamondList = Arrays.asList(array);

        return diamondList;


    }




}
