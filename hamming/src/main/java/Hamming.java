import java.util.Optional;

class Hamming {
    private String leftStrand, rightStrand;
    int hammingDistance;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if(leftStrand.length()!=rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        int distance = 0;
        for(int i=0; i<leftStrand.length(); i++){
            char char_l = leftStrand.toUpperCase().charAt(i);
            char char_r = rightStrand.toUpperCase().charAt(i);
            if(char_l != char_r){
                distance++;
            }
        }
        this.hammingDistance = distance;

    }

    int getHammingDistance() {
        return hammingDistance;
    }


}
