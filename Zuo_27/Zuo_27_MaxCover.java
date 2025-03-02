package Zuo_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Zuo_27_MaxCover {
    public static int MAXN = 1001;

    public static int[][] line = new int[MAXN][2];

    public static int n;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!= StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                line[i][0] = (int)in.nval;
                in.nextToken();
                line[i][1] = (int)in.nval;
            }
            
        }
        out.flush();
        out.close();
    }

    //本题的核心代码
    public static int compute(){
        //堆的清空
        size = 0;
        //线段有n条，line[i][0]  line[i][1] 左闭右闭
        Arrays.sort(line, 0, n, (a, b) -> a[0] -b[0]);//按照线段开始段 从小到大 排序
        int max = 0;
        for(int i = 0; i < n; i++){
            while(size > 0 && heap[0] <= line[i][0]){//堆不为空，且堆顶元素（某一线段的右端）小于等于堆外线段的左端，将堆顶元素弹出。出循环后将堆外元素的右端放入堆中
                pop();
            }
            add(line[i][1]);//线段右端入堆
            max = Math.max(max,size);
        }
        return max;
    }

    public static int[] heap = new int[MAXN];

    public static int size;

    public static void add(int x){
        heap[size] = x;
        int i = size++;
        //向上调整，构建小根堆
        while(heap[i] < heap[(i - 1) / 2]){
            swap(i, (i - 1) / 2);
            i = (i - 1)/2;
        }
    }

    public static void pop(){
        swap(0, --size);//堆底元素和堆顶元素交换

        //上一步将新入堆的元素放在了堆顶，下面向下进行调整，构建小根堆
        int i = 0, l = 1;
        while(l < size){
            int best = l + 1 < size && heap[l + l] < heap[l] ? l + 1 :l;//若只有左子堆则best为l；若左右子堆均存在，那么数值更小的一方为best
            best = heap[best] < heap[i] ? best : i;//best指向的子堆与父节点比较，更小的一方为最终的best
            if(best == i){
                break;
            }
            swap(i, best);//父节点大于子堆中的小者，交换。构建小子堆
            i = best;//i和l 向下移动
            l = i * 2 +1;

        }
    }

    public static void swap(int a, int b){
        int temp;
        temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
