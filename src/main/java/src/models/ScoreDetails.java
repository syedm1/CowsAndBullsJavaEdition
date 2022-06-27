package src.models;


public class ScoreDetails {
    int bullsCount = 0;
    int cowsCount = 0;

    public int getBullsCount() {
        return bullsCount;
    }

    public int getCowsCount() {
        return cowsCount;
    }

    public void incrementBulls() {
        this.bullsCount += 1;
    }

    public void incrementCows() {
        this.cowsCount += 1;
    }
}
