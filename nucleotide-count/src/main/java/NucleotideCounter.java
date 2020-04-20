
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NucleotideCounter {
    private final Map<Character, Integer> nucleotides;
    private String bottomChain;

    public NucleotideCounter(String bottomChain) {
        if(bottomChain.matches(".*[^ACTG]+.*")) throw new IllegalArgumentException();
        this.bottomChain = bottomChain;
        this.nucleotides = new LinkedHashMap<>();
        this.nucleotides.put('A', 0);
        this.nucleotides.put('C', 0);
        this.nucleotides.put('G', 0);
        this.nucleotides.put('T', 0);
        for(char c1 : this.nucleotides.keySet()) {
            int count = 0;
            for(char c2 : this.bottomChain.toCharArray()) {
                if (c1 == c2) {
                    count++;
                    this.nucleotides.replace(c1, count);
                }
            }
        }
    }

    public Map<Character, Integer> nucleotideCounts() {
        return new HashMap<>(nucleotides);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for(char c : this.nucleotideCounts().keySet()) {
            result += (Character.hashCode(c) + this.nucleotides.get(c));
        }
        return result * prime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        NucleotideCounter other = (NucleotideCounter) obj;
        for(char c : this.nucleotides.keySet()) {
            if((int) this.nucleotides.get(c) != other.nucleotides.get(c)) {
                return false;
            }
        }
        return true;
    }
}