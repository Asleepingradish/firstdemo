sdasdasdadsasdada
啊哈5555555
啊实打实的
public static void main(String[] args) {
    int [] nums = {12,13,1,99,56,87};
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
