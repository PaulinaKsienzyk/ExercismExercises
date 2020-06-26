public class QueenAttackCalculator {
    private Queen queen1;
    private Queen queen2;

    public QueenAttackCalculator(Queen queen1, Queen queen2) {
        if (queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (queen1.getColumn() == queen2.getColumn() &&
        queen1.getRow() == queen2.getRow()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    public boolean canQueensAttackOneAnother() {
        if(queen1.getRow() == queen2.getRow()) {
            return true;
        } else if (queen1.getColumn() == queen2.getColumn()) {
            return true;
        } else return isOnDiagonal();
    }

    private boolean isOnDiagonal() {
        int odds1 = queen1.getRow() - queen1.getColumn();
        int odds2 = queen2.getRow() - queen2.getColumn();
        int sum1 = queen1.getRow() + queen1.getColumn();
        int sum2 = queen2.getRow() + queen2.getColumn();

        return odds1 == odds2 || sum1 == sum2;
    }

}