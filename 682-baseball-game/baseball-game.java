class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < operations.length; i++) {

            String op = operations[i];

            if (op.equals("C")) {

                // Remove the last score
                stack.pop();

            } else if (op.equals("D")) {

                // Double the last score
                int lastScore = stack.peek();
                stack.push(lastScore * 2);

            } else if (op.equals("+")) {

                // Add the last two scores
                int first = stack.pop();
                int second = stack.peek();

                int newScore = first + second;

                stack.push(first);      // Put the removed score back
                stack.push(newScore);   // Add the new score

            } else {

                // It is a number
                int score = Integer.parseInt(op);
                stack.push(score);
            }
        }

        int total = 0;

        while (!stack.isEmpty()) {
            total = total + stack.pop();
        }

        return total;
        
    }
}