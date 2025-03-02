package Zuo_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Zuo_22_ReversePairs {
    
    public static int  MAXN = 500001;   

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!= StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            for(int i = 0; i < n; i++){
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            out.println(reversePairs(arr));
        }
        out.flush();
        out.close();
    }
    public static int reversePairs(int[] nums) {
        return count(nums,0, nums.length-1);
    }

    //翻转对=左侧翻转对+右侧翻转对+跨左右翻转对
    public static int count(int[] arr, int l, int r){
        if(l == r){
            return 0;
        }
        int m=(l+r)/2;
        return count(arr, l, m)+count(arr, m+1, r)+merge(arr,l,m,r);
    }
    //返回跨左右翻转对，整理左右序列
    public static int merge(int[] arr, int l, int m, int r){
        //统计部分
        int ans =0;
        for(int j = m+1, i = l;  i <= m; i++){
            while(j <= r && (long)arr[i] > (long)2*arr[j]){
                j++;
            }
            ans+=j-m-1;
        }

        //正常merge
        int i = l;
        int a = l;
        int b = m+1;
        while(a <= m && b <= r){
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while(a <= m){
            help[i++] = arr[a++];
        }
        while(b <= r){
            help[i++] = arr[b++];
        }
 
        for(i = l;i <= r;i++){
            arr[i]=help[i];
        }
        return ans ;
     }
}
