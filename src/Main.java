import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){

        //Matches
        String path = "Data/matches.csv";
        String line = "";

        List<Matches> matches = new ArrayList<>();
        System.out.println("--- Reading IPL Matches Data ---");

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();

            while((line = br.readLine()) != null){
                String[] value =  line.split(",");

                int id = Integer.parseInt(value[0]);
                int season = Integer.parseInt(value[1]);
                String city = value[2];
                String date = value[3];
                String team1 = value[4];
                String team2 = value[5];
                String tossWinner = value[6];
                String tossDecision = value[7];
                String result = value[8];
                boolean isDlApplied = value[9].equals("1");
                String winner = value[10];
                int winByRuns = Integer.parseInt(value[11]);
                int winByWickets = Integer.parseInt(value[12]);
                String playerOfMatch = value[13];
                String venue =  value[14];

                String umpire1 = (value.length > 15) ? value[15] : "";
                String umpire2 = (value.length > 16) ? value[16] : "";

                Matches match = new Matches(id, season, city, date, team1, team2, tossWinner, tossDecision,
                        result, isDlApplied, winner, winByRuns, winByWickets,
                        playerOfMatch, venue, umpire1, umpire2);

                matches.add(match);

            }
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }

        //Delivery
        String path2 = "Data/deliveries.csv";

        List<Delivery> deliveries = new ArrayList<>();
        System.out.println("--- Reading IPL Deliveries Data ---");

        try(BufferedReader br2 = new BufferedReader(new FileReader(path2))){
            br2.readLine();

            while((line = br2.readLine()) != null){
                String[] value =  line.split(",");

                int matchId = Integer.parseInt(value[0]);
                int inning = Integer.parseInt(value[1]);
                String battingTeam = value[2];
                String bowlingTeam = value[3];
                int over = Integer.parseInt(value[4]);
                int ball = Integer.parseInt(value[5]);
                String batsman = value[6];
                String nonStriker = value[7];
                String bowler = value[8];

                boolean isSuperOver = value[9].equals("1");

                int wideRun = Integer.parseInt(value[10]);
                int byeRun = Integer.parseInt(value[11]);
                int legByRun = Integer.parseInt(value[12]);
                int noBallRun = Integer.parseInt(value[13]);
                int penaltyRun = Integer.parseInt(value[14]);
                int batsmanRun = Integer.parseInt(value[15]);
                int extraRun = Integer.parseInt(value[16]);
                int totalRun = Integer.parseInt(value[17]);

                String playerDismissed = (value.length > 18) ? value[18] : "";
                String dismissalKind = (value.length > 19) ? value[19] : "";
                String fielder = (value.length > 20) ? value[20] : "";

                Delivery delivery = new Delivery(matchId, inning, battingTeam, bowlingTeam, over, ball,
                        batsman, nonStriker, bowler, isSuperOver, wideRun, byeRun,
                        legByRun, noBallRun, penaltyRun, batsmanRun, extraRun,
                        totalRun, playerDismissed, dismissalKind, fielder);

                deliveries.add(delivery);
            }
        }catch (IOException e){
            System.out.println("Error reading deliveries file: " + e.getMessage());
        }

        // --- TASKS CALLING ---
        IPLAnalyzer.findMatchesPerSeasons(matches);

        IPLAnalyzer.findMatchesWonByEachTeam(matches);

        IPLAnalyzer.findExtraRunsConcededIn2016(matches, deliveries);

        IPLAnalyzer.findEconomicalBowlersIn2015(matches, deliveries);

        IPLAnalyzer.highestNoOfSixesIn2016(deliveries, matches);
    }
}