import java.util.Scanner;

public class U4Examples {

    //if you declare a variable at the class level, that variable can be seen and used throughout all methods in the class
    public static int classLvlNum = 7;

    public static void main(String [] args) {

        //works because declared at class level
        System.out.println("classLvlNum in main() before calling primitive(): " + classLvlNum);


        // primitive variable scope - int, double, boolean, (Strings)
        int a = 4;
        int b = 5;
        int d = primitive(b);

        //System.out.println(e);
        //System.out.println(c);
        // these don't work because e and c are declared in primitive() -
        // therefore they can only be seen/accessed in primitive()

        //we can declare c and e variables in main(). These are SEPARATE from the variables in primitive()
        int c = 1;
        int e = 2;
        System.out.println("In main(): c is " + c + ", e is " + e);

        //the returned value from calling primitive(b);
        System.out.println(d);

        //class level variables can be modified by methods and the changes will be seen throughout the class
        System.out.println("classLvlNum in main() after calling primitive(): " + classLvlNum);




        System.out.println();




        //object variable scope
        //For now, arrays are the only objects we've seen. Technically Strings are objects too, but they behave like primitives
        int [] nums = {1, 2, 3};
        int [] nums2 = {1, 1, 1};
        System.out.println("nums2[0] before calling method: " + nums2[0]);

        object(nums2);
        System.out.println("nums2[0] after calling method: " + nums2[0]);


        System.out.println();

        System.out.println("recursion1(): ");
        recursion1(10);

        System.out.println();

        System.out.println("recursion2(): ");
        recursion2(10);
        System.out.println();
        System.out.println();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a word (lowercase)");
        String s1 = s.nextLine();
        System.out.println("Enter another word (lowercase)");
        String s2 = s.nextLine();

        System.out.println(s1 + ".compareTo(" + s2 + ") is " +(s1.compareTo(s2)));
        if (s1.compareTo(s2) < 0)
            System.out.println(s1 + " comes alphabetically BEFORE " + s2);
        if (s1.compareTo(s2) > 0)
            System.out.println(s1 + " comes alphabetically AFTER " + s2);
        if (s1.compareTo(s2) == 0)
            System.out.println(s1 + " is alphabetically the SAME as " + s2);


    }


    //primitive data types are int, double, and boolean and will all have the same behavior
    //String is technically not a primitive, but will act the same way.
    //When you pass a primitive to a method, you create a separate copy of the data for the method that only exists for the method.
    public static int primitive(int c) {
        //works because declared at class level
        System.out.println("classLvlNum in primitive(): " + classLvlNum);

        //you can modify class level variables in methods and that change will be seen elsewhere
        classLvlNum = 100;

        //System.out.println(a);
        //doesn't work because a was declared in main() - therefore it can only be seen/accessed in main()

        int e = 5;

        //you can change the value of a primitive-type parameter in a method,
        // but this change does NOT carry back out to where the method
        // was called from (see the printout of c in main())
        c = 20;

        // primitive()'s variables, NOT the ones from main()
        System.out.println("In primitive(): c is " + c + ", e is " + e);

        return -1;
    }

    //arrays (any type) are the only kind of object we've seen so far.
    //When you pass an object to a method, any changes that the method
    //makes to the object will be kept and seen everywhere else
    public static void object(int [] array) {

        //System.out.println(nums[0]);
        //doesn't work because nums was declared in main() - therefore it can only be seen/accessed in main()

        //when you change an object passed as a parameter in a method, that change will be seen wherever that object can be seen
        //-see printout from main()
        array[0] = -1;
    }


    //recursive methods call themselves until the base case is met

    public static void recursion1(int n) {
        //base case (stopping case), i.e. when recursion stops is n == 0
        if (n == 0)
            System.out.println();

            //recursive case - when n is not 0
            //print BEFORE the recursive method call
        else {
            System.out.print(n + " ");
            recursion1(n-1);
        }
    }

    public static void recursion2(int n) {

        //base case (stopping case), i.e. when recursion stops is n = 0. In this version of the method,
        //the line break printed will appear BEFORE all the numbers because the base case is reached before
        //any of the print() statements in the if-statement can run
        if (n == 0)
            System.out.println();

            //print AFTER the recursive method call,
            //meaning the recursive call needs to finish running before the current value of n is printed
        else {
            recursion2(n-1);
            System.out.print(n + " ");
        }

    }



}