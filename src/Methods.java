public class Methods {

    public static void main(String [] args) {

        //write code that will calculate the sum of values
        //between 2 provided numbers
        //ex: 4 and 8 --> 4 + 5 + 6 + 7 + 8

        int small = 4;
        int big = 8;
        int sum = 0;
        for(int i = small; i < big+1; i++) {
            sum += i;
        }
        System.out.println(sum);

        //methods (aka functions) let you define code that can be reused
        //multiple times throughout the program

        //call the method but we don't use the returned data so it
        //gets thrown out
        sumBetween(6, 10);

        //save the returned value to a var
        int s = sumBetween(1, 5);
        System.out.println(s);

        //directly print the returned value
        System.out.println( sumBetween(2, 7) );

        //the values that get passed to the method call are called arguments
        //(get subbed into the parameters)

        //the quantity, data type, and sequence of arguments needs to match
        //the defined parameters
        //sumBetween(2, 5, 7);

        //data type needs to match
        //sumBetween(false, "something");

        //can pass in int variables
        int num = 2;
        int num2 = 7;
        System.out.println( sumBetween(num, num2) );

        //can pass in a method call that returns the correct data type
        //-in this ex, sumBetween() returns an int, which can be passed
        //to another method call of sumBetween()
        System.out.println( sumBetween( sumBetween(1, 4), 8  ) );


        System.out.println("5 factorial is " + factorial(5));


        print("chris");

        //no return value - nothing to save
        //String st = print("chris");

        //no value produced/returned by print()
        //System.out.println( print("chris") );

        //argument type doesn't match the param type
        //print(8);

        //can concatenate anything to a string
        print("" + 8);

        printFact(6);

        print("good? " + isGood());

        boolean g = isGood();
        print(g + "");

        //since isGood() returns a boolean, it can be used
        //as a condition for an if-statement or while loop
        if ( isGood() ) {
            print("good");
        }
        else {
            print("bad");
        }
    }

    //for now, all methods start with public static
    //int is the return type - the method needs to produce data of
    //this type
    //-void is a valid return type but means there's no return (like in main)
    //-small and big are parameters - like variables that get used
    //in the method code that can modify how the code runs or what gets
    //output, need to declare the data type
    //-sumBetween is the method name
    public static int sumBetween(int small, int big) {

        //small and big in this method are different variables than
        //small and big in main()
        int sum = 0;
        for(int i = small; i < big+1; i++) {
            sum += i;
        }

        //sum is the int value produced by this method that gets returned
        return sum;

        //the return value needs to match the defined return type for the
        //method
//        return "something";
    }

    //factorial method - one param
    public static int factorial(int n) {

        int product = 1;
        for (int i = n; i > 0; i--) {
            product *= i;
        }

        return product;
    }

    public static void print(String s) {

        System.out.println(s);

        //no return needed/expected for a void return type
        //return -1;
    }

    //can call methods in other methods
    public static void printFact(int n) {
        print( factorial(n) + "");
    }

    //a method call can only return one value
    public static boolean isGood() {
        double r = Math.random();
        if (r < 0.5) {
            //the first return statement reached will run,
            //then no other code in the method will run
            return true;
        }

        //doesn't need else bc when the if-statement is true, the
        //return statement in there is reached, then the method stops
        return false;
    }
}
