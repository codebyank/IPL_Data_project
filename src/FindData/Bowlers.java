package FindData;

import entity.DeliveryData;
import service.DeliveriesDataService;

import java.util.HashSet;
import java.util.ListIterator;

public class Bowlers {
    HashSet<String> bowlers=new HashSet<>();
    public HashSet<String> getBowlers(){
        ListIterator<DeliveryData> dataListIterator= DeliveriesDataService.deliveryDataList.listIterator();
        while(dataListIterator.hasNext()){
            bowlers.add(dataListIterator.next().getBowlerName());
        }
        return bowlers;
    }
}
