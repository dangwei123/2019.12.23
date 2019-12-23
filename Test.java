对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len=A.length-1;
        LinkedList<Integer> l=new LinkedList<>();
        int carry=0;
        while(len>=0||K!=0||carry!=0){
            int a=len>=0?A[len--]:0;
            int b=K%10;
            l.addFirst((a+b+carry)%10);
            carry=(a+b+carry)/10;
            K/=10;
        }
        return l;
    }
}

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

方法一：
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> Row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||i==j){
                    Row.add(1);
                }else{
                    Row.add(0);
                }
            }
            res.add(i,Row);
        }

        for(int i=2;i<=rowIndex;i++){
            for(int j=1;j<i;j++){
                List<Integer> cur=res.get(i);
                List<Integer> pre=res.get(i-1);
                cur.set(j,pre.get(j)+pre.get(j-1));
            }
        }
        return res.get(rowIndex);
    }
}

方法二：
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int)cur);
            cur=cur*(rowIndex-i)/(i+1);
        }
        return res; 
    }
}

给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i:nums){
           nums[Math.abs(i)-1]= nums[Math.abs(i)-1]<0?nums[Math.abs(i)-1]:-nums[Math.abs(i)-1];
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}