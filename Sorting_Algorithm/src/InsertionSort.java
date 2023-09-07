import java.util.Scanner;

public class InsertionSort {
    public static void display(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void insertionSort(int n,int[] arr){
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                 int temp = arr[j];
                 arr[j] = arr[j-1];
                 arr[j-1] = temp;
                j--;
            }
        }
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
        insertionSort(n,arr);
        System.out.println("After sorting an array");
        display(n,arr);
    }
}
/*
Time Complexity : O(N^2)
Best Case TC : O(N)
Space Complexity : O(1)
 */