import java.util.Scanner;

public class SelectionSort {
    public static void display(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void selectionSort(int n,int[] arr){
        for(int i=0;i<n-1;i++){
            int index = i;
            for(int j=i+1;j<n;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
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
        selectionSort(n,arr);
        System.out.println("After sorting an array");
        display(n,arr);
    }
}
/*
Time Complexity : O(N^2)
Space Complexity : O(1)
 */