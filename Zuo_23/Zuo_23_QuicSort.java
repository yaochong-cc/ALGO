package Zuo_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Zuo_23_QuicSort {
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
            out.println();
        }
        out.flush();
        out.close();
    }
    //经典版本
    public static void quickSort1(int l,int r){
        if(l==r){
            return;
        }

        int x=arr[l+(int)(Math.random()*(r-l+1))];//等概率取l到r的随机坐标
        int mid = partition1(l,r,x);
        quickSort1(l,mid-1);
        quickSort1(mid, r);
    }

    public static int partition1(int l,int r,int x){
        int a=l,xi=0;
        for(int i = l; i <= r;i++){
            if(arr[i]<= x){
                swap(a,i);//把小于选取数的数字放到选取数的左侧。特别的，对于在左侧区域外的数字，可以通过交换放到左侧区域中
                if(arr[a] == x){
                    xi=a;//xi记录选取的数的坐标
                }
                a++;
            }
        }
        //把选取的数放在分界点上
        swap(xi,a-1);
        return a-1;
    }

    //优化
    public static void quickSort2(int l, int r){
        if(l >= r){
            return;
        }

        int x = arr[l+(int)(Math.random()*(r-l+1))];
        partition2(l,r,x);
        //用临时变量记录first和last，防止全局变量被更新
        int left=first;
        int right = last;
        quickSort2(l,left-1);
        quickSort2(right+1,r);
    }
    public static int first, last;
    //荷兰国旗问题
    public static void partition2(int l, int r, int x){
        first = l;
        last = r;
        int i = l;
        while(i <= last){
            if(arr[i] == x){
                i++;
            }else if(arr[i] < x){
                swap(first++,i++);
            }else{
                swap(last--,i);
            }
        }
    }
    public static void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
