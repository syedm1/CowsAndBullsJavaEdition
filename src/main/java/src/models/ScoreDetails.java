package src.models;


public class ScoreDetails {
    int bullsCount = 0;
    int cowsCount = 0;
    boolean isWinner = false;

    public int getBullsCount() {
        return bullsCount;
    }

    public int getCowsCount() {
        return cowsCount;
    }

    public boolean getIsWinner() {
        return isWinner;
    }

    public void perfectScore() {
        isWinner = true;
    }

    public void incrementBulls() {
        this.bullsCount += 1;
    }

    public void incrementCows() {
        this.cowsCount += 1;
    }
}
