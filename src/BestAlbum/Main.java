package BestAlbum;

import java.util.*;

public class Main {
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