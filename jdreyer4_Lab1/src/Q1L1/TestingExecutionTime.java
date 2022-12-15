package Q1L1;
import java.util.Scanner;

public class TestingExecutionTime {

    static int j = 1;                                 //store depth of recursion //global so its not rewritten in the method when method is called recursively
    static int recResult = 1;                         //store result of recursion approach//could have also passed through recursive methods

    public static void main(String[] args){
        myHeader(1);                           //call header
        Scanner inputScan = new Scanner(System.in);    //initialize scanner
        int num = -1;                                 //initialize num to -1 so we can check for a +ve # later. Stores number to calculate factorial of
        double startTime = 0;                         //initialize variable to store start time
        double time = 0;                              //initialize variable to store overall time


        do {                                                                        //run code once before checking
            System.out.println("Enter an Integer to calculate the Factorial of:");
            num = inputScan.nextInt();                                              //store number to calculate factorial of
        } while(num <= 0);                                                          //check user entered zero or positive num. if they did end loop. else ask again

        /**********************************************/
        startTime = System.nanoTime();                                              //store start point in time

        int result = 1;                                                             //initialize result to 1

        if(num == 0) {                                                              //if factorial of 0. answer is zero so output that. will skip for loop due to loops parameters
            result = 0;
        }

        for(int i=2; i<=num; i++){                                                  //calculate factorial. start at 2 because multiplying by 1 doesnt change anything
            result *= i;                                                            //storing factorial result in result
        }

        time = System.nanoTime() - startTime;                                       //calculate overall time to complete task
        System.out.println("Factorial (" + num + ") is " + result);                 //print result
        System.out.printf("Time taken for the iterative solution inside main: %.2e sec\n", time*Math.pow(10, -9)); //print time taken
        /*******************************************/


        startTime = System.nanoTime();           //overwrite with new start time
        result = iterativeMethod(num);           //call iterative solution method for factorial
        time = System.nanoTime()-startTime;     //overwrite overall time with overall time for this task
        System.out.println("Factorial (" + num + ") is " + result); //print result
        System.out.printf("Time taken for the iterative solution inside a method: %.2e sec\n", time*Math.pow(10, -9)); //print time taken

        startTime = System.nanoTime();      //overwrite with new start time
        result = recursiveMethod(num);      //call recursive solution method for factorial
        time = System.nanoTime()-startTime; //overwrite overall time with overall time for this task
        System.out.println("Factorial (" + num + ") is " + result); //print result
        System.out.printf("Time taken for the recursive solution inside a method: %.2e sec\n", time*Math.pow(10, -9)); //print time taken


        myFooter(1); //print footer
    }

    public static void myHeader(int labNum){
        System.out.println("=======================================================================");
        System.out.println("Lab Exercise " + labNum + "-Q1");
        System.out.println("Prepared By: Jacob Dreyer");
        System.out.println("Student Number: 251241714");
        System.out.println("Goal of this Exercise: test execution times of calculating factorials");
        System.out.println("=======================================================================");
    }

    public static void myFooter(int labNum){
        System.out.println("=======================================================================");
        System.out.println("Completion of Lab Exercise " + labNum + "-Q1 is Successfull");
        System.out.println("Signing off - Jacob");
        System.out.println("=======================================================================");
    }

    public static int iterativeMethod(int facNum){   //same functionality as approach in main(). just returns the result. Refer there for comments
        int result = 1;

        if(facNum == 0) {
            result = 0;
            return result;
        }

        for(int i=2; i<=facNum; i++){
            result *= i;
        }

        return result; //returns result
    }

    public static int recursiveMethod(int facNum){

        j++;                //depth of recursion is stored globally and increased each time method is called
        recResult *= j;     //calculating factorial. 1*2*3*4 all the way up to the number you calculate the factorial of

        if(j < facNum){                 //stop when you reach the biggest number in the calculation of factorial
            recursiveMethod(facNum);    //call the method recursively
        }

        return recResult;     //returns result after calculating the factorial
    }
}
