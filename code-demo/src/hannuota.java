class hannuota {


    public static void hanot(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            hanot(n - 1, from, other, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            hanot(n - 1, other, to, from);
        }
    }

    public static void func(int n) {
        if (n > 0) {
            hanot(n, "左", "右", "中");
        }
    }

    public static void main(String[] args) {
        func(3);

    }
}
