package service;

import entity.DeliveryData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveriesDataService {
    public static List<DeliveryData> deliveryDataList = new ArrayList<DeliveryData>();

    public void readData(){

        String csvFile = "/home/ankit/Documents/csvfile/deliveries.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                if(skip == 0){
                    skip++;
                    continue;
                }
                // using comma as separator here
                String[] match = line.split(cvsSplitBy);
                storeData(match);


            }
        }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void storeData(String[] data){

        DeliveryData deliveries = new DeliveryData();

        int data0 = Integer.parseInt(data[0]);
        int data1 = Integer.parseInt(data[1]);
        int data4 = Integer.parseInt(data[4]);
        int data5 = Integer.parseInt(data[5]);
        //int data8 = Integer.parseInt(data[8]);
        int data9 = Integer.parseInt(data[9]);
        int data10 = Integer.parseInt(data[10]);
        int data11 = Integer.parseInt(data[11]);
        int data12 = Integer.parseInt(data[12]);
        int data13 = Integer.parseInt(data[13]);
        int data14 = Integer.parseInt(data[14]);


        int data15 = Integer.parseInt(data[15]);
        int data16 = Integer.parseInt(data[16]);
        int data17 = Integer.parseInt(data[17]);


        deliveries.setMatchId(data0);
        deliveries.setInnings(data1);
        deliveries.setBattingTeam(data[2]);
        deliveries.setBowlingTeam(data[3]);
        deliveries.setOver(data4);
        deliveries.setBall(data5);
        deliveries.setBatsmanName(data[6]);
        deliveries.setBowlerName(data[8]);
        deliveries.setWideRuns(data10);
        deliveries.setByeRuns(data11);
        deliveries.setLegByeRuns(data12);
        deliveries.setNoBallRuns(data13);
        deliveries.setPenaltyRuns(data14);
        deliveries.setBatsmanRuns(data15);
        deliveries.setExtraRuns(data16);
        deliveries.setTotalRuns(data17);

        deliveryDataList.add(deliveries);

//      System.out.println("**********");
//      System.out.println(deliveriesData.get(0).getBatsmanName());
//      System.out.println("**********");
    }
}
