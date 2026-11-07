public class Delivery {
    private int matchId;
    private int inning;
    private String battingTeam;
    private String bowlingTeam;
    private int over;
    private int ball;
    private String batsman;
    private String nonStriker;
    private String bowler;
    private boolean isSuperOver;
    private int wideRun;
    private int byeRun;
    private int legByRun;
    private int noBallRun;
    private int penaltyRun;
    private int batsmanRun;
    private int extraRun;
    private int totalRun;
    private String playerDismissed;
    private String dismissalKind;
    private String fielder;

    public Delivery(int matchId, int inning, String battingTeam, String bowlingTeam, int over, int ball, String batsman,
                    String nonStriker, String bowler, boolean isSuperOver, int wideRun, int byeRun, int legByRun, int noBallRun,
                    int penaltyRun, int batsmanRun, int extraRun, int totalRun, String playerDismissed, String dismissalKind, String fielder) {
        this.matchId = matchId;
        this.inning = inning;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.over = over;
        this.ball = ball;
        this.batsman = batsman;
        this.nonStriker = nonStriker;
        this.bowler = bowler;
        this.isSuperOver = isSuperOver;
        this.wideRun = wideRun;
        this.byeRun = byeRun;
        this.legByRun = legByRun;
        this.noBallRun = noBallRun;
        this.penaltyRun = penaltyRun;
        this.batsmanRun = batsmanRun;
        this.extraRun = extraRun;
        this.totalRun = totalRun;
        this.playerDismissed = playerDismissed;
        this.dismissalKind = dismissalKind;
        this.fielder = fielder;
    }

    public int getMatchId() {
        return matchId;
    }
    public int getInning() {
        return inning;
    }
    public String getBattingTeam() {
        return battingTeam;
    }
    public String getBowlingTeam() {
        return bowlingTeam;
    }
    public int getOver() {
        return over;
    }
    public int getBall() {
        return ball;
    }
    public String getBatsman() {
        return batsman;
    }
    public String getNonStriker() {
        return nonStriker;
    }
    public String getBowler() {
        return bowler;
    }
    public boolean isSuperOver() {
        return isSuperOver;
    }
    public int getWideRun() {
        return wideRun;
    }
    public int getByeRun() {
        return byeRun;
    }
    public int getLegByRun() {
        return legByRun;
    }
    public int getNoBallRun() {
        return noBallRun;
    }
    public int getPenaltyRun() {
        return penaltyRun;
    }
    public int getBatsmanRun() {
        return batsmanRun;
    }
    public int getExtraRun() {
        return extraRun;
    }
    public int getTotalRun() {
        return totalRun;
    }
    public String getPlayerDismissed() {
        return playerDismissed;
    }
    public String getDismissalKind() {
        return dismissalKind;
    }
    public String getFielder() {
        return fielder;
    }
}
