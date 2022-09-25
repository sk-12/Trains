package org.example;

import java.io.File;
import java.util.*;

public class Main {

        public static class pair{
            String city;
            int dist;
            pair(String city,int dist){
                this.city=city;
                this.dist=dist;
            }
        }


        public static void main(String []args) throws Exception{

            File file = new File("src/input.text");
            Scanner sc = new Scanner(file);
            int idx=0;
            String []input=new String[2];
            while (sc.hasNextLine()){
                input[idx++]=sc.nextLine();
            }
            Map<String,Integer> mapA=new HashMap<>();
            Map<String,Integer> mapB=new HashMap<>();

            mapA.put("CHN",0);
            mapA.put("SLM",350);
            mapA.put("BLR",550);
            mapA.put("KRN",900);
            mapA.put("HYB",1200);
            mapA.put("NGP",1600);
            mapA.put("ITJ",1900);
            mapA.put("BPL",2000);
            mapA.put("AGA",2500);
            mapA.put("NDL",2700);

            mapB.put("TVC",0);
            mapB.put("SRR",350);
            mapB.put("MAQ",600);
            mapB.put("MAO",1000);
            mapB.put("PNE",1400);
            mapB.put("HYB",2000);
            mapB.put("NGP",2400);
            mapB.put("ITJ",2700);
            mapB.put("BPL",2800);
            mapB.put("PTA",3800);
            mapB.put("NJP",4200);
            mapB.put("GHY",4700);


            String[] one =input[0].split(" ");
            List<String> listA= Arrays.asList(one);


            String [] two=input[1].split(" ");
            List<String> listB=Arrays.asList(two);

            PriorityQueue<pair> q=new PriorityQueue<>((p1,p2)->(p2.dist-p1.dist));
            System.out.print("ARRIVAL TRAIN_A ENGINE ");


            for(int i=2;i<listA.size();i++) {
                System.out.print(listA.get(i) + " ");

                if(mapA.containsKey(listA.get(i)) && (mapA.get(listA.get(i)) >= 1200)){

                    System.out.print(listA.get(i) + " ");
                    if (!listA.get(i).equals("HYB")) {
                        q.add(new pair(listA.get(i), mapA.get(listA.get(i))));
                    }

                }
                else if(mapB.containsKey(listA.get(i)) && (mapB.get(listA.get(i)) >= 1200)){
                    System.out.print(listA.get(i) + " ");
                    if (!listA.get(i).equals("HYB")) {
                        q.add(new pair(listA.get(i), mapB.get(listA.get(i))));
                    }
                }
            }

            System.out.println();
            System.out.print("ARRIVAL TRAIN_B ENGINE ");

            for(int i=2;i<listB.size();i++){
                if(mapB.containsKey(listB.get(i)) && (mapB.get(listB.get(i)) >= 2000)){
                    System.out.print(listB.get(i) + " ");
                    if (!listB.get(i).equals("HYB")) {
                        q.add(new pair(listB.get(i), mapB.get(listB.get(i))));
                    }
                }
                else if(mapA.containsKey(listB.get(i)) && (mapA.get(listB.get(i)) >= 2000)){

                    System.out.print(listB.get(i) + " ");
                    if (!listB.get(i).equals("HYB")) {
                        q.add(new pair(listB.get(i), mapA.get(listB.get(i))));
                    }

                }

            }
            System.out.println();
            System.out.print("DEPARTURE TRAIN_AB ENGINE ENGINE ");
            while(!q.isEmpty()){
                pair z=q.poll();
                System.out.print(z.city+" ");
            }


        }
    }
