import java.util.Scanner;

public class QuickSort {
    public static void display(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex>=highIndex){
            return;
        }
        int pivot = arr[highIndex];
        int leftPointer = partition(arr,lowIndex,highIndex,pivot);
        quickSort(arr,lowIndex,leftPointer-1);
        quickSort(arr,leftPointer+1,highIndex);
    }

    public static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while(leftPointer<rightPointer){
            while (arr[leftPointer]<=pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while (arr[rightPointer]>=pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            //swap left pointer finds the larger element & right pointer finds the smallest element
            int temp = arr[leftPointer];
            arr[leftPointer] = arr[rightPointer];
            arr[rightPointer] = temp;
        }
        // swap left pointer with high index(pivot element)
        int temp = arr[leftPointer];
        arr[leftPointer] = arr[highIndex];
        arr[highIndex] = temp;
        return leftPointer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in an array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Before sorting an array");
        display(n,arr);
        quickSort(arr,0,n-1);
        System.out.println("After sorting an array");
        display(n,arr);
    }
}

/*
Time Complexity : O(NlogN)
Worst Case TC : O(N^2)
Space Complexity : O(N)
In the worst-case scenario, Quick Sort can use O(n) additional memory space on the call stack.
 */