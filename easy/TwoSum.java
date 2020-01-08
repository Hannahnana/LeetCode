package easy;

import java.util.Arrays;
import java.util.HashMap;

//求两数之和
//可以假设每一种输入只对应一个答案，但不能重复利用这个数组中的同样的元素
//示例：nums = [2,7,11,15] target = 9 因为nums[0]+nums[1]=target,所以返回[0,1]
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int target = 9;
		TwoSum ts = new TwoSum();
		int[] res = ts.twoSum2(nums, target);
		System.out.print(Arrays.toString(res));
	}
	//看到题的第一反应……运行时间25ms，Java中仅仅超过了34.75%
	public int[] twoSum(int[] nums, int target) {
		int cha;
		int[] ret = new int[2];
		for(int i=0;i<nums.length;i++) {
			cha = target-nums[i];
			for(int j=i+1;j<nums.length;j++) {
				if(cha==nums[j]) {
					ret[0] = i;
					ret[1] = j;
				}
			}
		}
        return ret;
    }
	//评论中大佬的解法，太厉害了，存到哈希表中时直接存的补数……
	public int[] twoSum2(int[] nums, int target) {
		int[] indexs = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
	}
}
