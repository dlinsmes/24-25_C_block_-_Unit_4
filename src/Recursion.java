public class Recursion {

    public static void main(String [] args) {
        System.out.println("2^5 is " + exponent(2, 5));


        System.out.println("2^5 is " + expRecursive(2, 5));

        countDownFrom(5);

        System.out.println();
        countUpTo(10);
        System.out.println();

        System.out.println(fib(6));

        for (int i = 1; i <= 10; i++)
            System.out.print( fib(i) + " ");

        System.out.println();

        for (int i = 1; i <= 10; i++)
            System.out.print( fibLoop(i) + " ");

        System.out.println();

        for (int i = 1; i <= 50; i++)
            System.out.print( fibLoop(i) + " ");


        //if one recursive method call requires multiple recursive calls, the run time grows exponentially
        //-it can take a lot longer to run, even though the code is shorter than the looped version

        System.out.println();
        for (int i = 1; i <= 50; i++)
            System.out.print( fib(i) + " ");
    }

    //warm up
    //write a method, exponent(int base, int pow), that
    //calculates the exponent of base raised to pow
    //returns that value
    public static int exponent(int base, int pow) {
        int ans = 1;
        for (int i = 0; i < pow; i++) {
            ans *= base;
        }
        return ans;
    }

    public static void sayHi() {
        System.out.println("hi");
        sayHi();
    }

    //recursion is when a method calls itself
    //-need to limit the number of recursive method calls otherwise
    //it rus infinitely (like loops)

    //2^5 = 2 * 2 * 2 * 2 * 2
    //    = 2 * 2^4
    //2^4 = 2 * 2^3
    //2^3 = 2 * 2^2
    //2^2 = 2 * 2^1
    //2^1 = 2 * 2^0
    //2^0 = 1 -- this is true of any base - power of 0 is 1

    //2^n = 2 * 2^(n-1)

    //base case - simplest form of the problem where the answer is known
    //for exponents, the base case is when the power is 0 --> 1

    public static int expRecursive(int b, int p) {

        //when p is any number besides 0, you go in the recursive case (else)
        //which calls the method again with a modified p value

        //base case - power is 0
        if(p == 0) {
            return 1;
        }

        //whenever the power is greater than 0, return the base times one less exponent
        else {
            // same as b * b^(p-1)
            // when the initial b is 2 and p is 2 --> 2 * expRecursive(2, 1)
            // expRecursive(2, 1) --> 2 * expRecursive(2, 0)
            // expRecursive(2, 0) --> 1
            return b * expRecursive(b, p-1);
        }
    }

    //on the test and on ap, you only need to be able to
    //interpret provided recursive methods for MC,
    //-never required to use recursion on FRQs

    //any method written recursively can always be written
    //with a loop as well

    //countDownFrom(5) - prints 5 4 3 2 1
    public static void countDownFrom(int n) {

        //base case is when n is 1
        //bc for any n value, 1 is always eventually
        //printed
        if (n == 1)
            System.out.print(n + " ");

        //recursive case - n is greater than 1
        else {
            System.out.print(n + " ");
            countDownFrom(n-1);
            //make a call to itself but change the argument from
            //the original so that eventually the base case is reached
            //(like making sure a while loop condition eventually becomes false)
        }

    }

    //countUpTo(5) prints 1 2 3 4 5
    public static void countUpTo(int n) {

        //even though the base case is the last step reached, in this example
        //it's the first number that gets output bc in the recursive case, no numbers
        //will print until the previous numbers have printed
        if (n == 1)
            System.out.print(n + " ");
        else {
            countUpTo(n-1);

            //this is only reached after the recursive method call finishes
            //so when the original n value is 10, 10 won't be printed until after
            //countUpTo(9) finishes
            System.out.print(n + " ");
        }
    }

    //fibonacci numbers

    // 1 1 2 3 5 8 13 21
    //f(1) --> 1 -- base case
    //f(2) --> 1 -- base case
    //f(3) --> 1 + 1 = 2
    //        = f(1) + f(2)
    //f(n) = f(n-2) + f(n-1)

    public static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            //each method call in the recursive
            //case needs the sum of two other
            //method calls
            return fib(n-2) + fib(n-1);
    }


    //same thing but with loop
    public static int fibLoop(int n) {
        int prev2 = 0;
        int prev1 = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            prev2 = prev1;
            prev1 = current;
            current = prev2 + prev1;
        }
        return current;
    }

}
