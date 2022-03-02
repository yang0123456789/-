public class Main {
    public static int process(int[] arr, int L) {
        if (arr == null || arr.length == 0 || L <= 0) {
            return 0;
        }
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int index = bRNum(arr, i, arr[i] + L);
            res = Math.max(res, index - i + 1);
        }
        return res;
    }
    // 查找arr[L...]元素中小于等于value中最大的元素索引
    private static int bRNum(int[] arr, int L, int value) {
        int R = arr.length - 1;
        while (L < R) {
            // 注意med取值方法，若没有+1可能死循环
            int med = ((R - L + 1) >> 1) + L;
            if (arr[med] == value) {
                return med;
            } else if (arr[med] < value) {
                L = med;// 注意这里不+1，防止跳过
            } else {
                R = med - 1;
            }
        }
        return L;
    }

    
}