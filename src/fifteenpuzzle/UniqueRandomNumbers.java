package fifteenpuzzle;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueRandomNumbers{

    /**Method that generates a specific set of numbers into a list, and then shuffles the numbers
     * This method fakes randomizing by creating all the desired numbers, and the simply shuffling them around
     * @param n Desired amount of numbers
     *          From 0 to n-1
     * @return Returns an arraylist with the shuffled numbers
     */
    public static ArrayList<Integer> generateUniqueRandomNumbers (int n){
        ArrayList<Integer> intList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            intList.add(i);
        }
        Collections.shuffle(intList);
        return intList;
    }

}
