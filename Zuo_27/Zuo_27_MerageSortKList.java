package Zuo_27;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Zuo_27_MerageSortKList{
    public static class ListNode{
        public int val;
        public ListNode next;
    }

    public static ListNode merageKList(ArrayList<ListNode> lists){
        //小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);//谁小谁在堆顶
        //把所有头结点放入小根堆中
        for (ListNode h : lists){
            if(h != null){
                heap.add(h);
            }
        }
        if(heap.isEmpty()){
            return null;
        }
        //先弹出一个节点作为总
        ListNode h = heap.poll();
        ListNode pre = h;
        if(pre.next != null){
            heap.add(pre.next);
        }
        while(!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next != null){
                heap.add(cur.next);
            }
        }
        return h;
    }
}