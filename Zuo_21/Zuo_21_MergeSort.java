package Zuo_21;

import java.io.*;

public class Zuo_21_MergeSort {
    
    public static int  MAXN = 501;   

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!= StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                arr[i] = (int)in.nval;
            }
            mergeSort2();
            out.print(arr[0]);
            for(int i=1;i<n;i++){
                out.print(""+arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    //递归版
    public static void mergeSort1(int l,int r){
        if(l==r){return;}
        int m=(l+r)/2;
        mergeSort1(l, m);
        mergeSort1(m+1, r);
        merge(l,m,r);
    }//由master公式：时间复杂度O(N*logN)

    //非递归版
    public static void mergeSort2(){
        //步长初始化为1，每次乘以2
        for(int l,m,r,step=1;step<n;step <<= 1){//step*=2
            l=0;
            while(l<n){
                m=l+step-1;
                if(m+1>=n){//已经没有右侧
                    break;
                }
                //求右边界
                r=Math.min(l+(step<<1)-1,n-1);
                merge(l,m,r);

                l=r+1;//进行下一组 按照步长排序
            }
        }
    }//时间复杂度为O(N*logN)

    public static void merge(int l,int m,int r){
        int i = l;   
        int a = l;//左部分指针
        int b = m+1;//右部分指针

        while(a<=m&&b<=r){//两部分都未耗尽
            help[i++] = arr[a]<arr[b] ? arr[a++] : arr[b++];
        }//while结束后两部分必有一个越界

        while(a<=m){
            help[i++] = arr[a++];
        }

        while(b<=r){
            help[i++] = arr[b++];
        }
        //将有序的数字导入原来的数组arr内
        for(i=l;i<=r;i++){
            arr[i] = help[i];
        }
    }
}
