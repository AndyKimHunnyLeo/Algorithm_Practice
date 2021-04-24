package BestAlbum;

import java.util.*;

public class MainV2 {
    /*
        We are trying to release the best album by collecting the two most played songs by genre on the streaming site.
        Songs are identified by a unique number, and the criteria for recording songs are as follows.

        1. The genre in which many songs are played are listed first.
        2. Songs that have been played a lot within the genre are recorded first.
        3. Among songs with the same number of plays within a genre, songs with a lower unique number are recorded first.

        Given a string array genres representing the genre of a song and an integer array plays representing the number of times played per song,
        complete the solution function to return the unique numbers of the songs to be in the best album in order.

        * genres[i] is the genre of the song with the unique number i
        * plays[i] is the number of times a song with unique number i has been played
        * The lengths of genres and plays are the same, which is 1 or more and 10,000 or less. There are less than 100 genre types.
        * If there is only one song in the genre, select only one song
        * Every genre has a different number of plays
     */


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
