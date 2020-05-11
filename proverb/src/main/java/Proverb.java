import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Proverb {

    private List<String> words;
    private List<String> partsOfProverb = new ArrayList<>();

    Proverb(String[] words) {
        this.words = Arrays.asList(words);
    }

    String recite() {
        StringBuilder sB = new StringBuilder();
        if(words != null && words.size()>0) {
            if(words.size()>1) {
                for(int i=0; i<words.size()-1; i++) {
                    String sentence = "For want of a " + words.get(i) + " the " +
                    words.get(i+1) + " was lost.\n";
                    this.partsOfProverb.add(sentence);
                }
            }
            this.partsOfProverb.add("And all for the want of a " + words.get(0) + ".");
            for(String sentence : partsOfProverb) {
                sB.append(sentence);
            }
        }

        return sB.toString();
    }

    public static void main(String[] args) {

        String[] words = {"nail", "shoe"};
        Proverb proverb = new Proverb(words);
        System.out.println(proverb.recite());
    }

}
