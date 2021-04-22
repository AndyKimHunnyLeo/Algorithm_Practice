package PhoneBook;

import java.util.*;
/*
    We want to check if there are any phone numbers listed in the phone book
    where one number is a prefix of another number.
    If the phone number is as follows, the phone number of the rescue team is the prefix
    of Andy's phone number.
    * rescue team : 112
    * Jack : 97 674 223
    * Andy : 11 2552 4421

    When the array phoneNumList containing the phone numbers written in the phone book is given as a parameter
    of the solution function, write the solution function to return false
    if a number is a prefix of another number, and true otherwise.

    - Condition -
    * Length of each array will be 1 to 20
    * There will be no duplicate String

 */

public class Main {
    public static void main(String[] args) {

        // Dummy Data
        String[] phoneNumList1 = {"119", "97674223", "1195524421"};
        String[] phoneNumList2 = {"123", "456", "789"," 1235467"};
        String[] phoneNumList3 = {"113333", "115555", "345555", "555555", "345444"};

//        Iterate all array twice. It works in all case but not efficient
//        for(String num: phoneNumList3){
//            for(String num1: phoneNumList3){
//                if(num != num1) {
//                    int result = num.indexOf(num1,0);
//                    if(result == 0){
//                        isSameNum++ ;
//                    }
//                }
//            }
//        }

        //Sort array
        Arrays.sort(phoneNumList2);
        boolean result = true;

        // compare with next element if it startwith previous element then result = false
        for (int i = 0; i < phoneNumList2.length - 1; i++) {
            if (phoneNumList2[i + 1].startsWith(phoneNumList2[i])) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
