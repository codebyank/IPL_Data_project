package service;

import problem.Problem1;
import problem.Problem2;
import problem.Problem3;
import problem.Problem4;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SolutionService implements ISolutionService{
    Scanner sc=new Scanner(System.in);
    DeliveriesDataService deliveriesDataService=new DeliveriesDataService();
    MatchDataService matchDataService=new MatchDataService();

    @Override
    public void solveProblems() {
        deliveriesDataService.readData();
        matchDataService.readData();
        System.out.println("Enter problem no which you want to solve...");
        int n=sc.nextInt();
        while(n<100){
              switch (n){
                  case 1:{
                      Problem1 problem1=new Problem1();
                      problem1.solution();
                      break;
                  }
                  case 2:{
                      Problem2 problem2=new Problem2();
                      problem2.solution();
                      break;
                  }
                  case 3:{
                      Problem3 problem3=new Problem3();
                      problem3.solution();
                      break;
                  }
                  case 4:{
                      Problem4 problem4=new Problem4();
                      problem4.solution();
                      break;
                  }
                  default:{
                      System.out.println("successfully exit!");
                      return;
                  }
              }
            System.out.println("Enter problem no. or for exit enter any no greater than 5");
              n= sc.nextInt();
        }
    }
}
