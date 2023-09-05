import java.util.Scanner;

public class SegementTree {
    public static int[] seg;
    public SegementTree(int n){
        seg = new int[4*n+1];
    }

//    building a tree
    public static void buildTree(int st_ind, int[] arr, int start, int end){
        if(start>end){
            return;
        }
        if(start==end){ //Leaf node
            seg[st_ind] = arr[start]; //just assign start index to the start value
            return;
        }
        int mid = start+(end-start)/2;
        buildTree(2*st_ind,arr,start,mid); // left call
        buildTree(2*st_ind+1,arr,mid+1,end); // right call
        seg[st_ind] = seg[2*st_ind]+seg[2*st_ind+1];
    }

//    Querying a values

    public static int query(int qs,int qe,int st_index,int start,int end){
        if(qs > end || qe <start){ //No Overlapping
            return 0;
        }
        if(start>=qs && end<=qe){ // Total Overlapping
            return seg[st_index];
        }
        int mid = start+(end-start)/2; //partial Overlapping
        int leftSum = query(qs,qe,2*st_index,start,mid); //left call
        int rightSum = query(qs,qe,2*st_index+1,mid+1,end); // right call
        return leftSum+rightSum; // adding the result
    }

//    Updating a tree
    public static void update(int start_index,int start,int end,int pos,int newValue){
        if(start>pos || end<pos){ // No Overlapping
            return;
        }
        if(start==end){
            seg[start_index] = newValue;
            return;
        }
        int mid = start+(end-start)/2;
        update(2*start_index,start,mid,pos,newValue);
        update(2*start_index+1,mid+1,end,pos,newValue);
        seg[start_index] = seg[2*start_index]+seg[2*start_index+1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        SegementTree segementTree = new SegementTree(n);
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
//        One based indexing so st_index is 1
        int st_index=1;
        int start=0,end=n-1;
//        building a tree
        buildTree(st_index,arr,start,end);
        for(int i=0;i<=4*n;i++){
            System.out.print(seg[i]+" ");
        }
        System.out.println();
//        Query an array
        System.out.println(query(2,4,st_index,start,end));
        System.out.println(query(1,4,st_index,start,end));
        System.out.println(query(2,2,st_index,start,end));

//        Update an array
        update(st_index,start,end,2,100);

//        for(int i=0;i<=4*n;i++){
//            System.out.print(seg[i]+" ");
//        }
//        System.out.println();
        System.out.println(query(2,4,st_index,start,end));
        System.out.println(query(1,4,st_index,start,end));
        System.out.println(query(2,2,st_index,start,end));

    }
}
