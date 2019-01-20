package ussu.pims.Model;

public class LeaderboardDataPoint {

    private String rank;
    private String userName;
    private String testCount;

    public LeaderboardDataPoint(String rank, String userName, String testCount) {
        this.rank = rank;
        this.userName = userName;
        this.testCount = testCount;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTestCount() {
        return testCount;
    }

    public void setTestCount(String testCount) {
        this.testCount = testCount;
    }
}
