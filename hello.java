
啊哈哈哈哈哈
6666666
啊实打实的
public static void main(String[] args) {
    int [] nums = {12,13,1,99,56,87};
    //外层循环控制比较轮数
    //每层循环控制每轮比较的次数
    for(int i=1;i<nums.length;i++){
        for(int j=0;j<nums.length-i;j++){
            if(nums[j]>nums[j+1]){
                int tmp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1]=tmp;
            }
        }
    }//排序结束
    for (int num : nums) {
        System.out.println(num);
    }
}
