package Zuo_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Zuo_22_SmallSum {

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
            out.println(smallSum(0,n-1));
        }
        out.flush();
        out.close();
    }
    //小和=左侧小和+右侧小和+跨左右侧小和
    public static long smallSum(int l,int r){
        if(l == r){
            return 0;
        }
        int m=(l+r)/2;
        return smallSum(l, m)+smallSum(m+1, r)+merge(l,m,r);
    }
    //返回夸左右的小和。让左右侧整体有序
    public static long merge(int l, int m, int r){
        //统计部分
        long ans =0;
        for(int j = m+1, i = l, sum = 0;  j<= r;j++){
            while(i <= m && arr[i] <= arr[j]){
                sum+=arr[i++];
            }
            ans+=sum;
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
