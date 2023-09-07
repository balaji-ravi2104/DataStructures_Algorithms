import java.util.Scanner;

public class HeapSort {
    public static void display(int n,int[] arr){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void heapSort(int n,int[] arr){
        // Build a max heap (rearrange the array)
        // start building a heapify from the right most internal node
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        // One by one extract elements from the heap
        for(int i=n-1;i>=0;i--){
            // Move the current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);

        }
    }

    public static void heapify(int[] arr,int size,int curr){
        int largest = curr;
        int left = 2*curr+1;
        int right = 2*curr+2;

        if(left<size && arr[left]>arr[largest]){
            largest = left;
        }

        if(right<size && arr[right]>arr[largest]){
            largest = right;
        }

        if(largest!=curr){
            int swap = arr[curr];
            arr[curr] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr,size,largest);
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
        heapSort(n,arr);
        System.out.println("After sorting an array");
        display(n,arr);
    }
}

/*
Time Complexity : O(NlogN)
Space Complexity : O(1)
In the worst-case scenario, Heap Sort can use O(log n) additional memory space on the call stack.
 */
