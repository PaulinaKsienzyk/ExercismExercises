import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final List<String> phrases;


    public House() {
        this.phrases = new ArrayList<>();
        this.phrases.add("This is the house that Jack built.");
        this.phrases.add("the malt that lay in ");
        this.phrases.add("the rat that ate ");
        this.phrases.add("the cat that killed ");
        this.phrases.add("the dog that worried ");
        this.phrases.add("the cow with the crumpled horn that tossed ");
        this.phrases.add("the maiden all forlorn that milked ");
        this.phrases.add("the man all tattered and torn that kissed ");
        this.phrases.add("the priest all shaven and shorn that married ");
        this.phrases.add("the rooster that crowed in the morn that woke ");
        this.phrases.add("the farmer sowing his corn that kept ");
        this.phrases.add("the horse and the hound and the horn that belonged to ");
    }

    public String verse(int verseNumber) {

        String partOne = this.phrases.get(0).substring(0, 8);
        String partTwo = this.phrases.get(0).substring(8);

        StringBuilder sB = new StringBuilder();

        for(int i=verseNumber; i>1; i--) {
            sB.append(phrases.get(i-1));
        }

        String middle = sB.toString();

        if(verseNumber == 1) {
            return partOne + partTwo;
        } else if(verseNumber <= 0) {
            return "";
        }

        return partOne + middle + partTwo;

    }

    public String verses(int startVerse, int endVerse) {

        if(startVerse > endVerse) {
            return "";
        }

        if(startVerse == endVerse) {
            return verse(startVerse) + verses(startVerse + 1, endVerse);
        }

        return  verse(startVerse) + "\n" + verses(startVerse + 1, endVerse);
    }

    public String sing() {
        return verses(1, 12);
    }


}

