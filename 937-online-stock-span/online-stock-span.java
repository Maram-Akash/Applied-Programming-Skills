class StockSpanner {
    Stack<Integer> stack;
    int[] prices;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        prices = new int[10000];
        index = 0;
    }
    public int next(int price) {
        prices[index] = price;
        while (!stack.isEmpty() && prices[stack.peek()] <= price) {
            stack.pop();
        }
        int span;
        if (stack.isEmpty()) {
            span = index + 1;
        } else {
            span = index - stack.peek();
        }
        stack.push(index);
        index++;
        return span;
    }
}
