public class InsertionSort {
    public static void main(String [] args) {

        int [] nums = {5, 2, 1, 4, 3, 8, 6};

        System.out.println("before sorting: ");
        for (int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        insertionSort(nums);

        int i = 2;
        double d = 10.4;
        boolean b = false;
        String s = "sandwich";

        doSomething(i, d, b, s);

        //the variable values are still the original ones set in main,
        //not the changed values in the method
        //-for these data types (int, double, boolean, String) - primitive data types -
        //the values don;'t get changed by other methods
        System.out.println(i + " " + d + " " + b + " " + s);

        System.out.println("after sorting: ");
        for (int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        //arrays passed to methods can be changed by the method logic
        //primitive data (int, double, boolean, string) DON'T get changed by methods

        //this method call will modify the original input array
        doSomethingElse(nums);

        for (int n: nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void doSomething(int i, double d, boolean b, String s) {
        //within the method call, the param values can be changed, but these
        //changes won't be seen outside of the method
        i = 9;
        d = -2.7;
        b = true;
        s = "dinosaur";
        System.out.println("inside doSomething: " + i + " " + d + " " + b + " " + s);
    }

    public static void doSomethingElse(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
        }
    }



    // left of / is sorted, right of / is unsorted
    // / 5, 2, 1, 4, 3, 8, 6
    // 5, / 2, 1, 4, 3, 8, 6
    // 2, 5, / 1, 4, 3, 8, 6
    // 1, 2, 5 /, 4, 3, 8. 6
    // 1, 2, 4, 5 /, 3, 8, 6

    //**similar** to what you do with cards in your hand:
    //moving from left to right, take the next value
    //and put it into the sorted position that's building on
    //the left
    //-if needed, move any higher values up by one position


    //don't need to memorize exact code, but need to recognize the
    //functionality if you saw it
    //-recognize the conceptual difference between selection sort and insertion sort
    //-selection involves swapping
    //-insertion involves moving values up by one position at a time
    public static void insertionSort(int [] n) {

        for (int i = 0; i < n.length; i++) {

            int current = n[i];
            //by saving n[i] to current, this opens up
            //position i to be used for other values

            //find where current needs to go
            //-if needed, move any higher values up by one position

            //keep looking behind position i to see where
            //current should go
            int j = i - 1;

            //to reverse from increasing to decreasing, just change the
            //comparison sign
            while(j >= 0 && n[j] > current) {
                //if n[j] is larger than current, move that value
                //up by one index
                n[j+1] = n[j];

                //look to the next position to the left
                j--;
            }

            //place current into the correct position
            n[j+1] = current;


            //print the progress
            for(int num: n) {
                System.out.print(num);
            }
            System.out.println();
        }

    }
}
