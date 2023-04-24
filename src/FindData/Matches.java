package FindData;

import entity.MatchData;
import service.MatchDataService;

import java.util.*;

public class Matches {
  public Integer season;
  public List<Integer> matchId;
  HashMap<Integer,List<Integer>> map=new HashMap<>();
  public HashMap<Integer,List<Integer>> getMatches(){
      Seasons seasons=new Seasons();
      HashSet<Integer> seasonset=new HashSet<>();
      seasonset=seasons.getSeasonset();
      Iterator<Integer> seasonlist=seasonset.iterator();
      while(seasonlist.hasNext()){
          int i=0;
          season=seasonlist.next();
          matchId=new ArrayList<>();
          ListIterator<MatchData> matchDataList= MatchDataService.matchDataList.listIterator();
          while (matchDataList.hasNext()){
              if(matchDataList.next().getSeason()==season){
                  matchId.add(MatchDataService.matchDataList.get(i).getMatchId());
              }
              i++;
          }
          map.put(season,matchId);
      }
      return map;
  }
}
