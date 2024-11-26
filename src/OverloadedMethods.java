public class OverloadedMethods {

    //string methods -
    //-length() - int return - number of chars in the string
    //-equals(String other) - boolean return - true when the
    //two strings are the same, false otherwise


    //-substring(int beginning) - String return - part of the
    //string starting at beginning until the end of the string
    //-substring(int beginning, int end) - String - part of the
    //string starting at beginning, until end (exclusive)

    //new:
    //indexOf(String b) - int return - gives the index of the
    //first occurrence of b in the larger string, or -1 if it
    //doesn't exist

    //compareTo(String other) - int return - used to compare/sequence two strings
    //return value will be:
    //-negative if the calling string comes sequentially (alphabetically) before other
    //-positive if the calling string comes after other
    //-zero if the calling string is the same as other

    public static void main(String [] args) {
        print("index of n in banana is " + "banana".indexOf("n"));

        //when the substring is multiple letters, indexOf() will give
        //the starting index of where it's found in the string
        print("index of an in banana is " + "banana".indexOf("an"));

        //-1 when the substring isn't in the string
        print("index of c in banana is " + "banana".indexOf("c"));

        //if the strings are already in alphabetical order, you get a negative
        print("apple compared to banana: " + "apple".compareTo("banana"));

        //if out of order, you get a positive
        print("banana compared to apple: " + "banana".compareTo("apple"));

        //if same, you get 0
        print("banana compared to banana: " + "banana".compareTo("banana"));

        //the actual value doesn't matter - just check the sign of the return value
        print("banana compared to bomb: " + "banana".compareTo("bomb"));

        //used for sorting lists/arrays of strings

        //all uppercase letters come sequentially before all lowercase letters
        print("ZEBRA compared to apple: " + "ZEBRA".compareTo("apple"));

        //call the version of max with two int params
        print("max of 4 and 2 is " + max(4, 2));

        //call the other version with 3 int params
        print("max of 4, 2, and 3 is " + max(4, 2, 3));

        //the type of argument also affects which overloaded method is called
        print("max of 4. and 2.7 is " + max(4.1, 2.7));

        print(3);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    //overload print() to use an int param
    public static void print(int i) {
        //can call another version of the method
        print(""+ i);
    }

    //overloaded methods - multiple methods have the same name
    //but a different method signature (sequence, quantity, and data type) of params
    //substring() has two versions - one with one int param, another with two int params
    //-the version of the method that gets called depends on what arguments are passed

    public static int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    public static int max(int a, int b, int c) {
        if (a > b &&  a > c)
            return a;
        else if (b > a && b > c)
            return b;
        return c;
    }

    public static double max(double a, double b) {
        if (a > b)
            return a;
        return b;
    }

    //invalid bc the signature (set of params) matches the previous method
//    public static double max(double c, double d) {
//        return -1;
//    }
}
