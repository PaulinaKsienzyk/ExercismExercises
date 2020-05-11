import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    private List<String> proteins;

    public ProteinTranslator() {
        this.proteins = new ArrayList<>();
    }

    List<String> translate(String rnaSequence) {

       for(int i=0; i<rnaSequence.length(); i++) {
           String codon = "";
           if(i==0) {
               codon = rnaSequence.substring(0, 3);
           } else if( i%3 == 0) {
               codon = rnaSequence.substring(i, (i + 3));
           }

               switch (codon) {
                   case "AUG":
                       this.proteins.add("Methionine");
                       continue;
                   case "UUU":
                   case "UUC":
                       this.proteins.add("Phenylalanine");
                       continue;
                   case "UUA":
                   case "UUG":
                       this.proteins.add("Leucine");
                       continue;
                   case "UCU":
                   case "UCC":
                   case "UCA":
                   case "UCG":
                       this.proteins.add("Serine");
                       continue;
                   case "UAU":
                   case "UAC":
                       this.proteins.add("Tyrosine");
                       continue;
                   case "UGU":
                   case "UGC":
                       this.proteins.add("Cysteine");
                       continue;
                   case "UGG":
                       this.proteins.add("Tryptophan");
                       continue;
                   case "UAA":
                   case "UAG":
                   case "UGA":
                       return this.proteins;
               }

           }

       return this.proteins;
    }

}
