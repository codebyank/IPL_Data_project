package FindData;

import entity.MatchData;
import service.MatchDataService;

import java.util.HashSet;
import java.util.ListIterator;

public class Seasons {
    HashSet<Integer> seasonset=new HashSet<>();
    public HashSet<Integer> getSeasonset(){
        ListIterator<MatchData> matchDataList= MatchDataService.matchDataList.listIterator();
        while(matchDataList.hasNext()){
            seasonset.add(matchDataList.next().getSeason());
        }
        return seasonset;
    }
}
