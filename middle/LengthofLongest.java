package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//给定一个字符串，返回其中不含重复字符的最长子串的长度
public class LengthofLongest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		LengthofLongest ll = new LengthofLongest();
		System.out.print(ll.lengthOfLongestSubstring2(s));
	}
	//我这种解法，用时149ms，仅超过7.93%的用户，太慢了hhh。
	public int lengthOfLongestSubstring(String s) {
		if(s.length()==1) {
			return 1;
		}
		if(s.length()==0) {
			return 0;
		}
        HashMap<Character,Integer> map = new HashMap<>();
        int lmax = 0;
        for(int i=0; i<s.length();i++) {
        	char c = s.charAt(i);
        	if(!map.containsKey(c)) { //不存在的话就加入
        		map.put(c, i);
        	}
        	else { //存在的话就找到他的value 并且把所有value<=目标value的元素都移除，然后再加入
        		
        		//在移除前看一下现在的hashmap的大小
        		int sizeofmap = map.size();
        		if(sizeofmap>lmax) {
        			lmax = sizeofmap;
        		}
        		
        		int valueofc = map.get(c);
        		
        		//遍历HashMap的键值对
        		Integer integ = null;
        		Iterator iter = map.entrySet().iterator();
        		ArrayList<Character> toremove = new ArrayList<>();
        		while(iter.hasNext()) {
        		    Map.Entry entry = (Map.Entry)iter.next();
        		    // 获取key
        		    Character key = (Character) entry.getKey();
        		    // 获取value
        		    integ = (Integer)entry.getValue();
        		    if(integ<=valueofc) {
        		    	toremove.add(key);
        		    }else {
        		    	continue;
        		    }
        		}
        		for(Character r:toremove) {
        			map.remove(r);
        		}
        		map.put(c, i);
        	}
        }
		if(map.size()>lmax) {
			lmax = map.size();
		}
		return lmax;
    }
	//leetcode题解
	//我感觉我和他思路一致但是我不会敲
	public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
