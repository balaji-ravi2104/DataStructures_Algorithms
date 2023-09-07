import java.util.Scanner;

public class MergeSort {
    public static void display(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int low,int high,int[] arr){
        if(low>=high){
            return;
        }
        int mid = low+(high-low)/2;
        mergeSort(low,mid,arr);
        mergeSort(mid+1,high,arr);
        merge(low,mid,high,arr);
    }
    public static void merge(int low,int mid,int high,int[] arr){
        int i=low,j=mid+1;
        int[] temp = new int[high-low+1];
        int index=0;
        while (i<=mid && j<=high){
            if(arr[i]>arr[j]){
                temp[index++] = arr[j++];
            }else{
                temp[index++] = arr[i++];
            }
        }
        while(i<=mid){
            temp[index++] = arr[i++];
        }
        while (j<=high){
            temp[index++] = arr[j++];
        }
        // Copying array values to original array
//        System.arraycopy(temp, 0, arr, low + 0, temp.length);
        for (int k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];
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
        mergeSort(0,n-1,arr);
        System.out.println("After sorting an array");
        display(n,arr);
    }
}
/*
Time Complexity : O(NlogN)
Space Complexity : O(N)
 */