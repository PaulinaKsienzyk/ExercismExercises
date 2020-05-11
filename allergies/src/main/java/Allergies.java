import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Allergies {

    private List<Allergen> allergens = new ArrayList<>();

    public Allergies(int score) {
        addAllergens(score);
        Collections.sort(this.allergens);
    }

    private void addAllergens(int score) {
        if (score > 0) {
            int number = score;
            int odds = 0;

            while (!isPower(number) ) {
                odds++;
                number--;
            }

            for (Allergen allergen : Allergen.values()) {
                if (allergen.getScore() == number) {
                    this.allergens.add(allergen);
                }
            }

            if (odds > 0){
                addAllergens(odds);
            }
        }
    }

    private boolean isPower(int nr) {
        int pow = 1;
        for(int i=0; i<32; i++) {
            if (pow == nr) {
                return true;
            }
            pow = pow << 1;
        }
        return false;
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergens.contains(allergen);
    }

    public List<Allergen> getList () {
        return new ArrayList<>(allergens);
    }

}