class Solution {
  public int calculate(String s) {
    if (s.length() == 0) {
      return 0;
    }

    HashMap<Character, Integer> order = new HashMap<>();
    order.put('+', 1);
    order.put('-', 1);
    order.put('/', 2);
    order.put('*', 2);
    order.put('^', 3);
    order,put('(', 0);
    if (s.charAt(0) == '-') {
       s = "0" + s;
    }
    s = s.replace("(-", "(0-");
    Stack<Character> ops = new Stack<>();
    Stack<Integer> nums = new Stack<>();
    int num = 0;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == ' ') {
        continue;
      }
      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
      } else if (c == '(') {
        ops.push(c);
      } else if (c == ')') {
        while (!ops.isEmpty() && ops.peek() != '(') {
          num = calc(nums.pop(), num, ops.pop());
        }
        ops.pop();
      } else {
        int curOrder = order.get(c);
        while (!ops.isEmpty() && curOrder <= order.get(ops.peek())) {
          num = calc(nums.pop(), num, ops.pop());
        }
        nums.push(num);
        ops.push(c);
        num = 0;
      }
    }
    while (!ops.isEmpty()) {
      num = calc(nums.pop(), num, ops.pop();
    }
    return num;
  }

  private int calc(int n1, int n2, char op) {
    if (op == '+') {
      return n1 + n2;
    } else if (op == '-') {
      return n1 - n2;
    } eles if (op == '*') {
      return n1 * n2;
    } else if (op == '/') {
      return n1 / n2;
    }
    return (int) Math.pow(n1, n2);
  }
}
