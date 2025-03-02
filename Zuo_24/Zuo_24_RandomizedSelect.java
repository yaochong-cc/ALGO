package Zuo_24;

public class Zuo_24_RandomizedSelect {
    
    public static int findKthLargest(int[] nums,int k){
        //randomizedSelect将数组按升序，找出第k小的数，因此randomizedSelect(nums,nums.lengeth - k)即为第k大的数字
        return randomizedSelect(nums,nums.length - k);
    }

    public static int randomizedSelect(int[] arr, int i){
        int ans = 0;//ans 表示第i小的数字
        //采用分治的思想
        for(int l = 0, r = arr.length - 1; l <= r;){
            partition2(arr, l, r, arr[l+(int)(Math.random()*(r - l + 1))]);
            //若需要的i在first左侧，则对first左侧的部分进行分治，而不用考虑右侧
            //对应i在last右侧的情况亦然
            //如果在first和last中间(first和last中间的数字都相同)，说明已经找到，返回结果，结束循环
            if(i < first){
                r = first - 1;
            }else if(i > last){
                l = last + 1;
            }else{
                ans = arr[i];//命中i,返回结果
                break;
            }
        }
        return ans;
    } 

    public static int first, last;
    //荷兰国旗问题
    public static void partition2(int[] arr, int l, int r, int x){
        first = l;
        last = r;
        int i = l;
        while(i <= last){
            if(arr[i] == x){
                i++;
            }else if(arr[i] < x){
                swap(arr, first++,i++);
            }else{
                swap(arr, last--,i);
            }
        }
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
