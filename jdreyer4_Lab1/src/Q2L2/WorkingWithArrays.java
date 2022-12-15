package Q2L2;


import java.util.Scanner;

public class WorkingWithArrays {
    public static void main(String[] args){
        int[] arr;

        Scanner inputScan = new Scanner(System.in);         //initialize scanner
        myHeader(1);                                    //print header

        System.out.println("Enter the size of the Array");
        arr = new int[inputScan.nextInt()];                  //initialize array to size a user enters

        for(int i=0;i<arr.length; i++){                     //request user to fill array
            System.out.println("Enter Value:");
            arr[i] = inputScan.nextInt();
        }

        System.out.println("Here is the Result...");

        double[] doubArr = mma5MethodJacob(arr);            //store returned array(holds max, min, and average of #s divisible by 5 of array passed in, and student #)


        if(doubArr[4] != 0) {                                            //print result of mma5MethodJacob (max, min, avg, student #)
            System.out.println("The max is " + doubArr[0] + ".");
            System.out.println("The min is " + doubArr[1] + ".");
            System.out.println("The average of numbers divisible by 5 is " + doubArr[2] + ".");
            System.out.println("My Student Number is " + (int) doubArr[3] + ".");
        }

        myFooter(1);                                            //print footer
    }

    public static double[] mma5MethodJacob(int[] intArr){
        int counter = 0;
        int max = 0;
        int min = 0;
        double total = 0;
        int numDiv5 = 0;
        double avg = 0;

        for(int i=0; i< intArr.length; i++){        //go through each item of array
            int temp = intArr[i];                   //store in temp
            if(temp%5 == 0){                        //check if # is divisible by 5
                numDiv5++;                          //increase by 1 (stores # of #s divisible by 5)
                total += temp;                        //add # to total of #s divisible by 5
                if(counter == 0){                   //if it is the first value divisible by 5
                    counter++;                      //increase counter so it knows its done this before (wont do it again)
                    max = temp;                     //set/initialize max to this value
                    min = temp;                     //set/initialize min to this value
                }

                max = Math.max(max, temp);          //find bigger value of existing max and this number. store it in max
                min = Math.min(min, temp);          //find smaller value of existing min and this #. store it in min
            }
        }



        if(numDiv5 == 0) {           //if the amount of #s divisible by 5 is 0 set numDiv5 to one so no divide by 0 error is producd
            avg = 0;
            System.out.println("In the array there was no number divisible by 5");
        } else{
            avg = total / numDiv5;
            System.out.println("Jacob found " + numDiv5 + " numbers that are divisible by 5"); //print # of #s divisible by 5
        }

        double[] doubArr = new double[5];  //initialize new array
        doubArr[0] = max;                   //set max to slot 0
        doubArr[1] = min;                   //set min to slot 1
        doubArr[2] = (avg);       //calculate average and set to slot 2
        doubArr[3] = 251241714;             //slot 3 = student #
        doubArr[4] = numDiv5;

        return doubArr;                     //return array
    }

    public static void myHeader(int labNum){
        System.out.println("Lab Exercise " + labNum);
        System.out.println("Prepared By: Jacob Dreyer");
        System.out.println("Student Number: 251241714");
        System.out.println("Goal of this Exercise: test execution times of calculating factorials");
    }

    public static void myFooter(int labNum){
        System.out.println("Completion of Lab Exercise " + labNum + " is Successfull");
        System.out.println("Signing off - Jacob");
    }
}
