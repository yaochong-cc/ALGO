package Zuo_20;
public class Zuo_20 {

    public static int maxValue(int[] arr){
        return f(arr,0,arr.length-1);
    }

    public static int f(int[] arr,int l,int r){
        if(l==r){
            return arr[l];
        }//base case

        int m=(l+r)/2;
        int lmax=f(arr,l,m);
        int rmax=f(arr,m+1,r);
        return Math.max(lmax,rmax);
    }
    
    public static void main(String[] args) {
        int []arr={3,8,7,6,4,5,1,2};
        System.out.println("数组最大值："+maxValue(arr));
    }
}
