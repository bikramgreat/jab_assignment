import java.util.Arrays;

public class assignment {
    //this function separates positive and negative (0 and -v int) int values in array
    // and puts all the positive int values in left side of array
    public int getMissingPositive(int[] inputArr)
    {
        int arraySize=inputArr.length;
        //taking all the positive int into left side of array
        // this a variable will be used to count number of positive int value in array
        // and will be also used for swapping the values in array
        int a=0;
        for(int i=0;i<arraySize; i++){
            if(inputArr[i]>0)
            {
                //swapping to put positive int value to left in array
                int tempNegativeInt=inputArr[a];
                inputArr[a]=inputArr[i];
                inputArr[i]=tempNegativeInt;
                a++;
            }
        }
        //System.out.println(Arrays.toString(inputArr));
        return findMissingPositiveInt(inputArr,a);
    }

    //this function takes modified array where all the positive int values are in left side of array
    //returns missing positive Int
    public int findMissingPositiveInt(int[] arr, int numberOfPositiveInt)
    {


        //loop only for positive int values
        for (int i = 0; i < numberOfPositiveInt; i++)
        {
                // here we manipulate  the array here
                // we take the value of the index and make positive value
                int abs = Math.abs(arr[i]);

                //here positive int is start from 1 and array index start from 0 so 1 is subtracted
                //if abs - 1 is smaller than numberOfPositiveInt and if value of the index abs - 1 has positive int then
                //we go to the index (abs - 1) and change into negative value
                if (abs - 1 < numberOfPositiveInt && arr[abs - 1] > 0)
                    arr[abs - 1] = -arr[abs - 1];
        }

        //now we check manipulated values in array
        //the missing positive int is index+1 where the value of that index is positive
        // 1 is added because index start from 0
        for (int i = 0; i < numberOfPositiveInt; i++)
            if (arr[i] > 0)
                return i + 1;

        return numberOfPositiveInt + 1;

    }

    public static void main(String[] arg)
    {
        int[] arr={-1,0,0,2,3,5,1,7,15};
        assignment as=new assignment();
        System.out.println("the missing positive int is :"+as.getMissingPositive(arr));
    }
}
