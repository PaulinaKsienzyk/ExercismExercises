import java.util.*;

public class FoodChain {

    private final Map<Integer, String> animals;
    private final List<String> phrases;

    public FoodChain() {
        this.animals = new HashMap<>();
        this.animals.put(1, "fly");
        this.animals.put(2, "spider");
        this.animals.put(3, "bird");
        this.animals.put(4, "cat");
        this.animals.put(5, "dog");
        this.animals.put(6, "goat");
        this.animals.put(7, "cow");
        this.animals.put(8, "horse");
        this.phrases = new ArrayList<>();
        this.phrases.add("I don't know why she swallowed the fly. Perhaps she'll die.");
        this.phrases.add("It wriggled and jiggled and tickled inside her.\n");
        this.phrases.add("How absurd to swallow a bird!\n");
        this.phrases.add("Imagine that, to swallow a cat!\n");
        this.phrases.add("What a hog, to swallow a dog!\n");
        this.phrases.add("Just opened her throat and swallowed a goat!\n");
        this.phrases.add("I don't know how she swallowed a cow!\n");
        this.phrases.add("I know an old lady who swallowed a horse.\n" +
                "She's dead, of course!");

    }

    public String verse(int verseNumber) {

        if(verseNumber == 8) {
            return phrases.get(verseNumber - 1);
        }

        StringBuilder sB = new StringBuilder();

        String beginning = "I know an old lady who swallowed a " + animals.get(verseNumber) + ".\n";
        sB.append(beginning); // The beginning begins depending on the animal. I can add it outside of the loop.
        sB.append(phrases.get(0)); // I need the end of the song to loop and it always occurs.
        int endOfTheFirstRow = sB.indexOf("I don't know why"); // That's why I needed  the end of the song ->
                                                               // to "fill" the center.

        if(verseNumber > 1) {
            for (int i = 1; i<verseNumber; i++) {
                // I fill it from top to bottom
                String middleRow = "She swallowed the " + animals.get(i + 1) + " to catch the " +
                        animals.get(i) + ".\n";
                sB.insert(endOfTheFirstRow, middleRow);

                if(i == 1) {
                    sB.insert(endOfTheFirstRow, phrases.get(i));
                }
            }
        }


        if( verseNumber > 2) {
            sB.insert(endOfTheFirstRow, phrases.get(verseNumber - 1));
            return sB.toString().replaceFirst(".\nIt", " that");
        }
        return sB.toString();
    }



    public String verses(int start, int end) {

        while (start < end) {
            return verse(start) + "\n\n" + verses(start + 1, end);
        }
        return verse(start);
    }


}
