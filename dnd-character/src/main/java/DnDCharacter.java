import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DnDCharacter {

    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final int constitution;
    private int hitPoints;

    private final Dice dice = new Dice(6);

    public DnDCharacter() {
        this.strength = ability();
        this.dexterity = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.constitution = ability();
        this.hitPoints = 10 + modifier(this.constitution);

    }


    int ability() {
        List<Integer> rolls = new ArrayList<>();
        for(int i=0; i<4; i++) {
            rolls.add(dice.roll());
        }
        Collections.sort(rolls);
        rolls.remove(0);

        int ability = 0;
        for(int roll : rolls) {
            ability += roll;
        }

        return ability;
    }

    int modifier(int input) {
        double modifier = (((double)input - 10) / 2);
        System.out.println(modifier);
        return (int) Math.floor(modifier);
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getHitpoints() {
        return hitPoints;
    }



}
