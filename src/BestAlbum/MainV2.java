package BestAlbum;

import java.util.*;

public class MainV2 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        String[] genres = {"classic", "pop", "classic", "classic", "jazz", "pop", "Rock", "jazz"};
        int[] plays = {500, 600, 150, 800, 2500};
//        int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};
        HashMap<Integer, String> result = new HashMap<>();
        List<Integer> removeList = new ArrayList<>();
        int index = 0;

        //hashmap
        for (int i = 0; i < plays.length; i++) {
            result.put(plays[i], genres[i]);
        }

        Set<String> genreKind = new HashSet<>();
        for (String genre : genres) {
            genreKind.add(genre);
        }
        for (String str : genreKind) {
            int count = 0;
            for (Integer integer : result.keySet()) {
                if (result.get(integer).equals(str) ) {
                    if (count < 2) {
                        count++;
                    } else {
                        removeList.add(integer);
                    }

                }
            }
        }


        for (Integer integer : removeList) {
            result.remove(integer);
        }
        System.out.println(result);
        int[] answerList = new int[result.size()];
        int[] answer = new int[result.size()];

        for (int i = 0; i < genreKind.size(); i++) {
            int maxValueInMap = (Collections.max(result.keySet()));
            int temp = -1;
            answerList[index] = maxValueInMap;
            index++;
            for (Integer integer : result.keySet()) {
                if (integer != maxValueInMap && result.get(integer).equals(result.get(maxValueInMap)) ) {
//                    System.out.println("another "+result.get(integer)+" "+integer);
                    answerList[index] = integer;
                    index++;
                    temp = integer;
                }
            }
            if (temp != -1) {
                result.remove(temp);

            }
            result.remove(maxValueInMap);
        }



        for (int j = 0; j < answer.length; j++) {
            for (int i = 0; i < plays.length; i++) {
                if (answerList[j] == plays[i]) {
                    answer[j]= i;
                }
            }
        }
        for (int i : answerList) {
            System.out.println(i);
        }
        for (int i : answer) {
            System.out.println(i);
        }


    }
}
