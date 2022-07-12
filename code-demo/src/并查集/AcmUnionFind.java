package 并查集;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2022/5/26
 * @Version 1.0
 **/
public class AcmUnionFind {
    /**
     * 记录并查集对应位置的父亲结点位置
     */
    private int[] parent;
    /**
     * 记录并查集对应结点的重量
     */
    private int[] weight;
    /**
     * 表示并查集的元素个数
     */
    private int size;
    /**
     * 表示并查集中集合的个数(组数)
     */
    private int groups;

    public AcmUnionFind(int size) {
        this.size = size;
        this.groups = size;
        this.parent = new int[size];
        this.weight = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[1] = 1;
        }
    }

    public int find(int element) {
        while (element != parent[element]) {
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    public boolean isConneted(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {
            return;
        }
        if (weight[firstRoot] < weight[secondRoot]) {
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        } else {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += secondRoot;
        }

        this.groups--;
    }

    public int getGroups() {
        return this.groups;
    }
}

class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int size = scanner.nextInt();
        while (size != 0) {
            int input = scanner.nextInt();
            AcmUnionFind union = new AcmUnionFind(size);
            for (int i = 0; i < input; i++) {
                //因为测试数据中是从1开始技术。而我们的并查集是从0开始，所以每个输入都减1
                int first = scanner.nextInt() - 1;
                int second = scanner.nextInt() - 1;
                union.unionElements(first, second);
            }
            //最后剩下的组数 - 1 就是最后的答案。因为连接M组的话，需要M-1条连线就可以了
            System.out.println(union.getGroups() - 1);
            size = scanner.nextInt();
        }
    }
}
