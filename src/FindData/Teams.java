package FindData;

import entity.MatchData;
import service.MatchDataService;

import java.util.HashSet;
import java.util.ListIterator;

public class Teams {
    HashSet<String> teamset=new HashSet<>();
    public HashSet<String> getTeamset(){
        ListIterator<MatchData> matches= MatchDataService.matchDataList.listIterator();
        while(matches.hasNext()){
            teamset.add(matches.next().getTeam1());
        }
        return teamset;
    }
}
