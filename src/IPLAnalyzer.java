import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class IPLAnalyzer{
    public static void findMatchesPerSeasons(List<Matches> matches){
        Map<Integer, Integer> matchesPerYear = new HashMap<>();

        for (Matches match : matches){
            int season = match.getSeason();

            if(matchesPerYear.containsKey(season)){
                int oldCount = matchesPerYear.get(season);
                matchesPerYear.put(season, oldCount + 1);
            }
            else {
                matchesPerYear.put(season, 1);
            }
        }

        System.out.println("\n--- Task 1: Matches Played Per Year ---");
        System.out.println(matchesPerYear);
    }

    public static void findMatchesWonByEachTeam(List<Matches> matches){
        Map<String, Integer> matchesWon = new HashMap<>();

        for (Matches match : matches){
            String winner = match.getWinner();

            if(winner != null && !winner.isEmpty()){
                if(matchesWon.containsKey(winner)){
                    int oldCount = matchesWon.get(winner);
                    matchesWon.put(winner, oldCount + 1);
                }
                else{
                    matchesWon.put(winner, 1);
                }
            }
        }
        System.out.println("\n--- Task 2: Matches Won By Each Team ---");
        System.out.println(matchesWon);
    }

    public static void findExtraRunsConcededIn2016(List<Matches> matches, List<Delivery> deliveries){
        List<Integer> matchIdsOf2016 = new ArrayList<>();
        for(Matches match : matches){
            if (match.getSeason() == 2016){
                matchIdsOf2016.add(match.getId());
            }
        }

        Map<String, Integer> extraRunsMap = new HashMap<>();
        for(Delivery delivery : deliveries){
            if (matchIdsOf2016.contains(delivery.getMatchId())){

                String bowlineTeam = delivery.getBowlingTeam();
                int extraRun = delivery.getExtraRun();

                if(extraRunsMap.containsKey(bowlineTeam)){
                    int oldRun = extraRunsMap.get(bowlineTeam);
                    extraRunsMap.put(bowlineTeam, oldRun + extraRun);
                }else {
                    extraRunsMap.put(bowlineTeam, extraRun);
                }
            }
        }
        System.out.println("\n--- Task 3: Extra Runs Conceded in 2016 ---");
        System.out.println(extraRunsMap);
    }

    public static void findEconomicalBowlersIn2015(List<Matches> matches, List<Delivery> deliveries){
        List<Integer> matchIdsOf2015 = new ArrayList<>();

        for(Matches match : matches){
            if(match.getSeason() == 2015){
                matchIdsOf2015.add(match.getId());
            }
        }

        Map<String, Integer> bowlerRunMap = new HashMap<>();
        Map<String, Integer> bowlerBallMap = new HashMap<>();

        for(Delivery delivery : deliveries){
            if(matchIdsOf2015.contains(delivery.getMatchId())){
                String bowler = delivery.getBowler();

                int givenRuns = delivery.getBatsmanRun() + delivery.getWideRun() + delivery.getNoBallRun();

                int validBall = 1;
                if(delivery.getWideRun() > 0 || delivery.getNoBallRun() > 0){
                    validBall = 0;
                }

                if (bowlerRunMap.containsKey(bowler)){
                    bowlerRunMap.put(bowler, bowlerRunMap.get(bowler) + givenRuns);
                }else{
                    bowlerRunMap.put(bowler, givenRuns);
                }

                if(bowlerBallMap.containsKey(bowler)){
                    bowlerBallMap.put(bowler, bowlerBallMap.get(bowler) + validBall);
                }
                else{
                    bowlerBallMap.put(bowler, validBall);
                }
            }
        }

        Map<String, Double> economyMap = new HashMap<>();

        for (String bowler : bowlerRunMap.keySet()){
            int totalRuns = bowlerRunMap.get(bowler);
            int totalBalls = bowlerBallMap.get(bowler);

            if(totalBalls > 0){
                double economy = (totalRuns / (double)totalBalls) * 6.0;
                economyMap.put(bowler, economy);
            }
        }

        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(economyMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        System.out.println("\n--- Task 4: Sorted Bowlers Economy in 2015 ---");

        for (Map.Entry<String, Double> entry : sortedList){
            String bowlerName = entry.getKey();
            Double economy = entry.getValue();

            System.out.println(bowlerName + " = " + economy);
        }

    }

    public static void highestNoOfSixesIn2016(List<Delivery> deliveries, List<Matches> matches){
        List<Integer> matchIdsOf2016 = new ArrayList<>();

        for(Matches match : matches){
            if(match.getSeason() == 2016){
                matchIdsOf2016.add(match.getId());
            }
        }

        Map<String, Integer> highestNoOfSixesMap = new HashMap<>();

        for(Delivery delivery : deliveries){
            if(matchIdsOf2016.contains(delivery.getMatchId())){
                if(delivery.getBatsmanRun() == 6){
                    String batsman = delivery.getBatsman();

                    if(highestNoOfSixesMap.containsKey(batsman)){
                        highestNoOfSixesMap.put(batsman, highestNoOfSixesMap.get(batsman) + 1);
                    }else{
                        highestNoOfSixesMap.put(batsman, 1);
                    }
                }
            }
        }
        int maxSixes = 0;
        String sixerKing = "";

        for(String batsmanName : highestNoOfSixesMap.keySet()){
            int curr = highestNoOfSixesMap.get(batsmanName);

            if(curr > maxSixes){
                maxSixes = curr;
                sixerKing = batsmanName;
            }
        }

        System.out.println("\n--- Task 5: highest no of Sixes in 2016 ---");
        System.out.println("Player: " + sixerKing + " with " + maxSixes + " Sixes!");
    }
}
