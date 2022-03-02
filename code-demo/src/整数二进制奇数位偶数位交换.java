/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2022/3/2
 * @Version 1.0
 **/
public class 整数二进制奇数位偶数位交换 {
    public static void main(String[] args) {
        process(5);
    }
    private static int process(int pos) {
        int pre = 0xAAAAAAAA; // 1010 1010 1010 1010 1010 1010 1010 1010
        int post = 0x55555555; // 0101 0101 0101 0101 0101 0101 0101 0101
        pre &= pos;
        post &= pos;
        pre >>= 1;
        post <<= 1;
        return pos + post;
    }
}
