package com.gang.leetcode.solution;

import com.gang.leetcode.data.ListNode;

/**
 * @author ligang
 * @desc  two num add
 *        1->2->3 + 2->4->5
 *        3->6->5
 * @source https://leetcode.com/problems/add-two-numbers/description/
 * @date 2018/7/21下午3:23
 **/
public class TwoNumAddSolution {

    public static void main(String[] args){
        ListNode l1 = buildList("101");
        System.out.println("l1:");
        showList(l1);

        ListNode l2 = buildList("999");
        System.out.println("l2:");
        showList(l2);

        TwoNumAddSolution solution = new TwoNumAddSolution();
        ListNode rst = solution.solution(l1, l2);

        System.out.println("rst:");
        showList(rst);
    }

    public ListNode solution(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode currL1 = l1;
        ListNode currL2 = l2;
        int temp;
        while(currL1 != null){

            if(currL2 != null){
                temp = currL1.val + currL2.val;
                currL1.val = temp % 10;
            }else{
                temp = currL1.val;
                currL1.val = temp % 10;
            }

            ListNode tempNode = currL1.next;
            if(tempNode == null){
               if(temp >= 10){
                   tempNode = new ListNode(temp / 10);
                   currL1.next = tempNode;
                   currL1 = currL1.next;
               }else{
                   if(currL2 != null && currL2.next != null){
                       tempNode = new ListNode(0);
                       currL1.next = tempNode;
                       currL1 = currL1.next;
                   }else {
                       break;
                   }
               }

           }else{
               currL1 = currL1.next;
               currL1.val = currL1.val + temp / 10;
           }

            if(currL2 != null){
                currL2 = currL2.next;
            }
        }

        return l1;
    }

    public static void showList(ListNode listNode){

        if(listNode == null){
            System.out.println("listNode is null");
        }

        ListNode curr = listNode;

        while(curr != null){
            if(curr.next != null){
                System.out.print(curr.val + "->");
            }else{
                System.out.print(curr.val);
            }

            curr = curr.next;
        }

        System.out.println();
    }

    public static ListNode buildList(String str){
        if(str == null ||  "".equals(str)){
            return null;
        }

        char[] arr = str.toCharArray();
        ListNode listNode = null;
        ListNode currNode = null;
        for(int i = arr.length -1; i>=0; i--){
            if(listNode == null){
                listNode = new ListNode(Integer.valueOf(""+arr[i]));
                currNode = listNode;
            }else{
                currNode.next = new ListNode(Integer.valueOf(""+arr[i]));
                currNode = currNode.next;
            }
        }

        return listNode;
    }
}
