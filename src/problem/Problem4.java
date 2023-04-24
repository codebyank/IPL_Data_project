package problem;

import FindData.Bowlers;
import FindData.Matches;
import entity.DeliveryData;
import service.DeliveriesDataService;

import java.text.DecimalFormat;
import java.util.*;

public class Problem4 implements IProblem{
    String bowler;
    Double run;
    HashSet<Integer> over;
    TreeMap<Double,String> map=new TreeMap<>();
    @Override
    public void solution() {
        Matches matches=new Matches();
        HashMap<Integer, List<Integer>> matchMap=matches.getMatches();
        //System.out.println(matchMap);
        List<Integer> matchList=matchMap.get(2015);
        int st=matchList.get(0);
        int en=matchList.get(matchList.size()-1);
        //System.out.println(st+" "+en);
        Bowlers bowlers=new Bowlers();

        HashSet<String > set=bowlers.getBowlers();
        Iterator<String > iterator= set.iterator();

        while(iterator.hasNext()){
            bowler=iterator.next();
            //System.out.println(bowler);
            //ListIterator<Integer> listIterator= matchId.listIterator();
            run=0.0;
            over=new HashSet<>();

                ListIterator<DeliveryData> dataListIterator= DeliveriesDataService.deliveryDataList.listIterator();

                while(dataListIterator.hasNext()){
                    DeliveryData deliveryData= dataListIterator.next();
                    if(deliveryData.getMatchId()>=st && deliveryData.getMatchId()<=en){
                      //  System.out.println(deliveryData.getBowlerName());
                        if(deliveryData.getBowlerName().equals(bowler)) {
                            run += (deliveryData.getNoBallRuns() + deliveryData.getPenaltyRuns() + deliveryData.getBatsmanRuns() + deliveryData.getWideRuns());
                            over.add(deliveryData.getOver());
                       }
                    }

            }
            map.put((run/over.size()),bowler);
        }
        printResult();
    }

    @Override
    public void printResult() {
       DecimalFormat d=new DecimalFormat("#.###");
        System.out.println("Top 10 economical bowlers in IPL season 2015");
        System.out.println("*************************************************************************************");
        System.out.println("Rank\t"+"Bowler name");
        //4System.out.println("Rank\t\tBowler Name\t\t Total run/Over");
        int i=1;
       for(Map.Entry<Double,String>val:map.entrySet()){
           System.out.println(i+"\t    ["+val.getValue()+"]   and their avg run per over is :"+d.format(val.getKey()));
           i++;
           if(i>10){
               return;
           }
       }
    }
}
