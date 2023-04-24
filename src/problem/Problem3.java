package problem;

import FindData.Matches;
import FindData.Teams;
import entity.DeliveryData;
import service.DeliveriesDataService;

import java.util.*;

public class Problem3 implements IProblem{
    String team;

    Integer matchId;
    HashMap<String ,Integer> map=new HashMap<>();

    @Override
    public void solution() {
        Teams teams=new Teams();
        HashSet<String> set=teams.getTeamset();
        Iterator<String> teamItr=set.iterator();
        Matches matches=new Matches();
        HashMap<Integer, List<Integer>> matchMap=matches.getMatches();
        //System.out.println(matchMap);
        List<Integer> matchList=matchMap.get(2016);
        int st=matchList.get(0);
        int en=matchList.get(matchList.size()-1);
        System.out.println(st+" "+en);
        System.out.println(matchList.size());
        while(teamItr.hasNext()){
            team=teamItr.next();
           // System.out.println(team);
            ListIterator<Integer> iterator= matchList.listIterator();
            Integer extraRun=0;

                ListIterator<DeliveryData> deliveryDataList= DeliveriesDataService.deliveryDataList.listIterator();

                while(deliveryDataList.hasNext()){
                    DeliveryData deliveryData= deliveryDataList.next();
                    if(deliveryData.getMatchId()<=en && deliveryData.getMatchId()>=st){
                        if(deliveryData.getBowlingTeam().equals(team)) {
                            System.out.println(team+ " "+ deliveryData.getExtraRuns());
                            extraRun += deliveryData.getExtraRuns();
                        }
                    }
                }

            map.put(team,extraRun);
        }
    printResult();


    }

    @Override
    public void printResult() {

        System.out.println("In IPL season 2016 extra run conceded per team data!");
        System.out.println("**********************************************************");
        for(Map.Entry<String,Integer>val: map.entrySet()){
            System.out.println("* Extra run conceded by team "+val.getKey()+" is :"+val.getValue());
        }
    }

}
