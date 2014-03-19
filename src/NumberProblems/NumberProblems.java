package NumberProblems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by neel on 3/19/14.
 */
public class NumberProblems {


    /*
        GIVEN AN ARRAY RETURN ALL TRIPLETS IN THE ARRAY THAT EQUAL 0
        - Takes O(n) space and O(n^2) runtime
        TODO: get rid of duplicate triplets
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        //let's hash all the numbers
        for(int i = 0; i<num.length; i++)
            map.put(num[i],true);

        for(int a = 0; a<num.length; a++)
        {
            for(int b = 0; b<num.length; b++)
            {
                if(a == b);//do nothing so we don't count same number
                else
                {
                    int sum = num[a] + num[b]; //sum so far
                    int seek = 0 - sum; //number we are looking for
                    if(seek == num[a] || seek == num[b]);//we don't want to count the same number twice
                    else
                    {
                        if(map.containsKey(seek))
                        {
                            //add the triplet to the list
                            ArrayList<Integer> triplet = new ArrayList<Integer>();
                            triplet.add(num[a]);
                            triplet.add(num[b]);
                            triplet.add(seek);
                            list.add(triplet);
                        }
                    }

                }

            }
        }

        return list;

    }


    //NEED TO COVER EDGE CASES
    public static boolean twoSums(int [] input, int sum)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< input.length; i++)
        {
            int seek = sum - input[i];

            boolean found = map.containsKey(seek);

            //check for duplicate elements
            if(seek == input[i])
            {
                if(map.get(seek) == 2 && found)
                    return true;
            }

            //found key
            if(map.containsKey(seek))
                return true;

                //if key not found then add to map
            else
            {
                int old_val = 1;
                if(map.containsKey(input[i]))
                {
                    old_val = map.get(input[i]);
                    old_val = old_val + 1;
                }
                map.put(input[i],old_val);
            }

        }

        //means that the sum doesn't exist
        return false;
    }


    public static boolean isScorePossible(int[] points, int value){
        int status [] =new int [value+1];
        status [0]=1;
        for (int i=0;i<points.length;++i){
            for (int j=points[i];j<=value;++j){
                status[j]+=status[j-points[i]];
            }
        }


        return status[value]>0;

    }

}
