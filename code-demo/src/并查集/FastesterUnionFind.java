package 并查集;

/**
 * @author chilcyWind
 * @Description
 * @Author Yang
 * @Date 2022/5/26
 * @Version 1.0
 **/
public class FastesterUnionFind {
    private int[] parent;
    private int[] weight;
    private int size;//代表并查集中元素个数
    private int groups;//代表并查集中有多少个集合（小组）

    public FastesterUnionFind(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        this.size = size;
        this.groups = size;//因为初始的时候每个人自成一组，所以有多少人就有多少组
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[i] = 1;
        }
    }

    public int find(int element) {
        while (element != parent[element]) {
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);

        //如果已经属于同一个集合了，就不用再合并了。
        if (firstRoot == secondRoot) {
            return;
        }

        if (weight[firstRoot] > weight[secondRoot]) {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        } else {//weight[firstRoot] <= weight[secondRoot]
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        }

        //合并 firstElement 和 secondElement 所在的两个组后，就少了一组。
        this.groups--;
    }

    public int getGroups() {
        return this.groups;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int size = scanner.nextInt();
            FastesterUnionFind union = new FastesterUnionFind(size);
            int input = scanner.nextInt();
            for (int j = 0; j < input; j++) {
                //因为测试数据是从1开始，而我们的并查集是从数组的第0位开始
                int first = scanner.nextInt() - 1;
                int second = scanner.nextInt() - 1;
                union.unionElements(first, second);
            }
            System.out.println(union.getGroups());
        }
    }
}
