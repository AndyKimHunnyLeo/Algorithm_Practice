package BestAlbum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //dummy Data
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        HashMap<Integer, String> result = new HashMap<>();
        List<Integer> sortedPlays = new ArrayList<>();

        //sort array
        for(int i = 0; i < plays.length;i++){
            sortedPlays.add(Arrays.stream(plays).sorted().toArray()[i]);
        }
        Collections.reverse(sortedPlays);


        //hashmap
        for(int i = 0; i < plays.length;i++){
            result.put(plays[i], genres[i]);
        }

        //
        Set<String> genreKind = new HashSet<>();
        for (String genre : genres) {
            genreKind.add(genre);
        }

        System.out.println(genreKind.size());
        int[] answer = new int[genreKind.size()*2];

        int index = 0;

        for (String s : genreKind) {
            int[] temp = new int[2];
            int count = 0;
//            System.out.println(Arrays.stream(plays).max().getAsInt());
            for(int i=0;i < result.size();i++){

//                System.out.println(sortedPlays.get(i));
                if(result.get(sortedPlays.get(i)) == s ){

                    if(count < 2){
                        for(int t = 0; t < plays.length;t++){
                            if(sortedPlays.get(i) == plays[t])

                            answer[index] = t;
                        }
                        count++;
                        index++;
//                        System.out.println(sortedPlays.get(i));
                    }else break;;
                }
            }

        }


//        for(int i: result.keySet()) {
//            if (i == sortedPlays.get(0)) {
//                int count = 0;
//                System.out.println(result.get(i));
//                if (count > 3) {
//                    System.out.println(count);
//                    count++;
//                }
//            }
//        }

//        for (int i : answer) {
//            System.out.println(i);
//        }

    }
}


//put values in hashmap
//        HashMap<String, Integer> result = new HashMap<>();
//        for(int i = 0; i < plays.length;i++){
//            result.put(genres[i], plays[i]);
//        }
//        System.out.println(result.keySet());