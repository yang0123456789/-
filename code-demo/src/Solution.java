import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')','(');
            put(']','[');
            put('}','{');

        }};

        System.out.println(map);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                queue.push(cur);
            } else {
                System.out.println(map.get(cur));
                if (queue.isEmpty() || queue.pop() != map.get(cur)) {
                    return false;
                }
            }

        }
        return queue.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}