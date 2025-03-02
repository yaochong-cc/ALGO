package Zuo_26;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

public class Zuo_26_TreeSetAndTreeMap {
    public static void main(String[] args) {
        //有序表TreeMap 底层是红黑树
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "这是5");
        treeMap.put(7, "这是7");
        treeMap.put(1, "这是1");
        treeMap.put(2, "这是2");
        treeMap.put(3, "这是3");
        treeMap.put(4, "这是4");
        treeMap.put(8, "这是8");
        
        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(10));
        System.out.println(treeMap.get(4));
        treeMap.put(4, "张三是4");//修改了treeMap4
        System.out.println(treeMap.get(4));

        treeMap.remove(4);
        System.out.println(treeMap.get(4) == null);

        //HashMap不具有的：
        //TreeMap中最小的key
        System.out.println(treeMap.firstKey());
        //TreeMap中最大的key
        System.out.println(treeMap.lastKey());
        //TreeMap中所有小于等于4，且离4最近的key
        System.out.println(treeMap.floorKey(4));
        //TreeMap中所有大于等于4，且离4最近的key
        System.out.println(treeMap.ceilingKey(4));

        System.out.println("==========TreeSet=========");

        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);
        System.out.println("有序表大小" + set.size());//大小仅为2
        while(!set.isEmpty()){
            System.out.println(set.pollFirst());//从小到大组织
            System.out.println(set.pollLast());//从大到小组织
        }

        //堆，（默认是小根堆）如果要大根堆，需要定制比较器。
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(3);
        heap.add(3);
        heap.add(4);
        heap.add(4);
        System.out.println("堆的大小是；"+ heap.size());//大小为4
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
        

    }
}
