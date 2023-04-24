package problem;

import FindData.Matches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1  implements IProblem{
    HashMap<Integer, List<Integer>> map=new HashMap<>();
    @Override
    public void solution() {
        Matches matches=new Matches();
         map=matches.getMatches();
       printResult();
    }

    @Override
    public void printResult() {
        System.out.println("Number of matches played per season data!");
        System.out.println("*******************************************");
        for(Map.Entry<Integer,List<Integer>>val: map.entrySet()){
            System.out.println("* Matches played in season "+val.getKey()+" : "+val.getValue().size());
        }
    }
}
