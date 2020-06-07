package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        //先压先前最小值
        //再压一个当前最小值，保证最小值一直存在
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

}