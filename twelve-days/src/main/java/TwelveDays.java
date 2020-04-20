import java.util.Arrays;
import java.util.List;

class TwelveDays {

    private List<String> gifts = Arrays.asList(" a Partridge in a Pear Tree.\n", " two Turtle Doves, and",
            " three French Hens,", " four Calling Birds,", " five Gold Rings,", " six Geese-a-Laying,",
            " seven Swans-a-Swimming,", " eight Maids-a-Milking,", " nine Ladies Dancing,", " ten Lords-a-Leaping,",
            " eleven Pipers Piping,", " twelve Drummers Drumming,");

    private String specifyDay(int number) {
        String day = "";
        switch (number) {
            case 1:
                day = "first";
                break;
                case 2:
                    day = "second";
                    break;
            case 3:
                day = "third";
                break;
            case 4:
                day = "fourth";
                break;
            case 5:
                day = "fifth";
                break;
            case 6:
                day = "sixth";
                break;
            case 7:
                day = "seventh";
                break;
            case 8:
                day = "eighth";
                break;
            case 9:
                day = "ninth";
                break;
            case 10:
                day = "tenth";
                break;
            case 11:
                day = "eleventh";
                break;
            case 12:
                day = "twelfth";
                break;
            default:
                return "incorrect number";

        }
        return "On the " + day + " day of Christmas my true love gave to me:";
    }

    String verse(int verseNumber) {
        int number = verseNumber;
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(gifts.get(number - 1));
            number--;
        }
        String connectedGifts = sb.toString();
        return specifyDay(verseNumber) + connectedGifts;
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();
        for(int i=startVerse; i<= endVerse; i++) {
            sb.append(verse(i));
            if(i!=endVerse) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }



}
