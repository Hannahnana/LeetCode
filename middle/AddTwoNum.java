package middle;

import java.util.Scanner;

public class AddTwoNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(-1);
		ListNode head = node0;
		ListNode _node0 = new ListNode(-1);
		ListNode _head = _node0;
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		if(n1<=0 || n2<=0) {
			return;
		}
		while(n1>0) {
			head.next = new ListNode(sc.nextInt());
			head = head.next;
			n1--;
		}
		while(n2>0) {
			_head.next = new ListNode(sc.nextInt());
			_head = _head.next;
			n2--;
		}
		sc.close();
		AddTwoNum atn = new AddTwoNum();
		ListNode p = atn.addTwoNumbers(node0.next, _node0.next);
		while(p!=null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
	//我太强了，我的解法超过了99.96%的人哈哈哈2ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode ret = new ListNode(-1);
    	ListNode head = ret;
    	int val1,val2;
    	boolean flag = false;
    	while(l1!=null && l2!=null) {
    		val1 = l1.val;
    		val2 = l2.val;
    		if(flag) { //进位了
    			if(val1+val2+1>=10) {
    				head.next = new ListNode(val1+val2-10+1);
    				flag = true;
    			}else {
    				head.next = new ListNode(val1+val2+1);
    				flag = false;
    			}
    		}
    		else { //不进位
    			if(val1+val2>=10) {
    				head.next = new ListNode(val1+val2-10);
    				flag = true;
    			}else {
    				head.next = new ListNode(val1+val2);
    				flag = false;
    			}
    		}
    		head = head.next;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	while(l1!=null) {  //l1没加完
    		val1 = l1.val;
    		if(flag) { // 例如991+9
    			if(val1+1==10) {
    				head.next = new ListNode(0);
    				flag = true;
    			}
    			else {
    				head.next = new ListNode(val1+1);
    				flag = false;
    			}
    			head = head.next;
    			l1 = l1.next;
    		}else {
    			head.next = l1;
    			break;
    		}
    	}
    	while(l2!=null){  //l2没加完
    		val2 = l2.val;
    		if(flag) {
    			if(val2+1==10) {
    				head.next = new ListNode(0);
    				flag = true;
    			}
    			else {
    				head.next = new ListNode(val2+1);
    				flag = false;
    			}
    			head = head.next;
    			l2 = l2.next;
    		}else {
    			head.next = l2;
    			break;
    		}
    	}
    	if(flag) head.next = new ListNode(1);  //两个列表都访问结束了，还有进位
        return ret.next;
    }

}
