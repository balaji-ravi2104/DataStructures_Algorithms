import java.util.Scanner;

public class BubbleSort {
    public static void display(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void bubbleSort(int n,int[] arr){
        for(int i=0;i<n-1;i++){
            boolean flag = false;
            for(int j=0;j<(n-i-1);j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
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
        bubbleSort(n,arr);
        System.out.println("After sorting an array");
        display(n,arr);
    }
}
/*
Time Complexity : O(N^2)
Best Case TC : O(N)
Space Complexity : O(1)
 */