package problem;

import FindData.Seasons;
import FindData.Teams;
import entity.MatchData;
import service.MatchDataService;

import java.util.*;

public class Problem2 implements IProblem{
    Integer year;
    String team;
    List<Integer> matchId;
    HashMap<String,List<Integer>> temp;
    HashMap<Integer, HashMap<String,List<Integer>>> map=new HashMap<>();
    @Override
    public void solution() {
        Seasons seasons=new Seasons();
        Teams teamObject=new Teams();
        HashSet<String> teamset=teamObject.getTeamset();
       // Iterator<String > teams= teamset.iterator();
        HashSet<Integer> set=seasons.getSeasonset();
        Iterator<Integer> years= set.iterator();
        while(years.hasNext()){
            year=years.next();
            temp=new HashMap<>();
            Iterator<String > teams= teamset.iterator();
            while(teams.hasNext()){
                team=teams.next();
                matchId=new ArrayList<>();
                int i=0;
                ListIterator<MatchData> matchDataList=MatchDataService.matchDataList.listIterator();
                while(matchDataList.hasNext() && i<636){
                    if(MatchDataService.matchDataList.get(i).getSeason()==year ){
                        if(MatchDataService.matchDataList.get(i).getWinner().equals(team)){
                            matchId.add(MatchDataService.matchDataList.get(i).getMatchId());
                        }
                    }
                    i++;
                }
                temp.put(team,matchId);
            }
            map.put(year,temp);
        }
        printResult();
        //System.out.println(map);
    }

@Override
    public void printResult(){
        for(Map.Entry<Integer,HashMap<String ,List<Integer>>>val: map.entrySet()){
            year= val.getKey();
            System.out.println("In IPL season :"+year);
            System.out.println("*************************");
            temp=val.getValue();
            for(Map.Entry<String,List<Integer>>var: temp.entrySet()){
                System.out.println("* Number of matches won by "+var.getKey()+" is : "+var.getValue().size());
            }
            System.out.println("============================================================================");
           // System.out.println("---------------------------------------------------------------------------");
        }

    }
}
//&& matchDataList.next().getTeam1().equals(team)