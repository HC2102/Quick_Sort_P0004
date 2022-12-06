/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort.p0004;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author HE170417
 */
public class QuickSortP0004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int input;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        try{
            System.out.println("Please enter an integer:");
            input = sc.nextInt();
            if(input == 0) throw new Exception("The value is 0");
            int [] numberList = new int[input];
            for(int i=0; i <input; i ++){
                numberList[i]=rand.nextInt(input);
            }
            System.out.println("Array before sort");
            display(numberList);
            quickSort(numberList,0,input-1);
            System.out.println("Array after sort");
            display(numberList);
            
        }
        catch(Exception e){
            System.out.println("Invalid input!");
            System.out.println(e);
        }
        
        
        
        
        
    }       
    public static void display(int[]numberList){
        System.out.print("{");
        for(int i=0;i<numberList.length;i++){
            System.out.print(numberList[i]+" ");
        }
        System.out.println("}");
    }
    /** Idea of quick sort
     * is a recursive algorithm
     * Correct position in final, sorted array
     * Items to the left are smaller
     * Item to the right are larger 
     * between 2 side is pivot ( 3 type of choose)
     */
    public static void quickSort(int[] numberList, int low, int high){
        if(low<high){ //until high >=low 
            int pivotLocation= partition(numberList, low, high); //setup a pivot
            quickSort(numberList, low, pivotLocation-1); //continue to quicksort the left side of pivot
            quickSort(numberList,pivotLocation+1, high); //continue to quicksort the right side of pivot
        }
    }
    public static int partition(int[] numberList, int low, int high){
        int pivot = numberList[high]; // we will choose the last element to be the pivot
        int leftWall = low-1; //set a barrier betweeen low and high side compared to pitvot
        for(int i =low;i<=high-1;i++){
            //swap the low side to the left
            if(numberList[i]<=pivot){
                //increase the leftWall by one to search another
               leftWall++;               
               swap(numberList,leftWall,i);
            }
        }
        //swap the pivot to the leftWall( which is finally sort the array into 2 parts)
        swap(numberList,leftWall+1,high);
        return leftWall+1; // return the index of current pivot;
    }
    public static void swap(int[] numberList, int i, int j){ //swap 2 value in an array
        int temp = numberList[i];
        numberList[i] = numberList[j];
        numberList[j]=temp;
    }
}
