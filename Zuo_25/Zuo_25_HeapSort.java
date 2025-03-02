package Zuo_25;

public class Zuo_25_HeapSort {
    
    //经典堆排序,时间复杂度：O(N*logN),额外的空间复杂度为O(1)
    public static void heapSort1(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            heapInsert(arr,i);
        }//从顶到底建立大根堆 时间复杂度：O(N*logN)

        int size = n;
        while(size > 1){//依次弹出最大值，时间复杂度：O(N*logN)
            swap(arr, 0, --size);//0位置数与最后一个位置数交换，确定最后一个数，size--
            heapify(arr, 0, size);
        }
    }

    //从底到顶建堆
    public static void heapSort2(int[] arr){
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--){
            heapify(arr, i, n);//从底到顶建堆,时间复杂度为O(N)
        }

        int size = n;
        while(size > 1){//依次弹出最大值，时间复杂度：O(N*logN)
            swap(arr, 0, --size);//0位置数与最后一个位置数交换，确定最后一个数，size--
            heapify(arr, 0, size);
        }
    }



    //i位置的数，向上调整大根堆
    //一直往上，找到不必父节点大或者到达根节点位置
    public static void heapInsert(int[] arr, int i){
        while(arr[i] > arr[(i-1)/2]){//子节点大于父节点，则交换
            swap(arr, i, (i-1)/2);
            i = (i-1)/2;//i向上移
        }
    }

    //i位置的数，向下调整大根堆: 节点变小，向该节点的子树向下调整
    //当前数组大小为size
    public static void heapify(int[] arr, int i, int size){
        int l = i*2 + 1;
        while(l < size){
            //有左孩子 l
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;//有右孩子 l+1 ，并且左右孩子中大的那个为记为best与父节点交换
            best = arr[best] > arr[i] ? best : i;//当前的数与最强孩子的比较
            if(best == i){//经过上个语句后，如果父节点的数字大于孩子结点，best和i都指向父节点，循环结束
                break;
            }
            swap(arr, best, i);
            i = best;//经过交换后，i和l向下移
            l = i * 2 + 1;
        }

    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
