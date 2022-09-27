/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2022/8/22
 * @Version 1.0
 **/
import java.util.Arrays;

public class 快排 {
    public static void main(String[] args) {
        int[] nums={11,11,24,5,32,50,34,54,11,76};
        System.out.println("快速排序前:"+ Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println("快速排序后:"+ Arrays.toString(nums));
    }
    public static void quickSort(int[] nums, int start, int end){
        if(start>end) return;
        int i,j,base;
        i=start;
        j=end;
        base=nums[start];
        while (i<j){
            while (i<j && nums[j]>=base) j--;
            while (i<j && nums[i]<=base) i++;
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,start,i);
        quickSort(nums,start,j-1);
        quickSort(nums,j+1,end);
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}

