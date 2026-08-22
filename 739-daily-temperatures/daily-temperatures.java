/*class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] A = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temp = i + 1;
            int count = 0;

            while (temp < temperatures.length &&
                   temperatures[temp] <= temperatures[i]) {
                temp++;
                count++;
            }

             if (temp < temperatures.length) {
                A[i] = count + 1;
            } else {
                A[i] = 0;
            }
        }                          // THIS IS SHOWING TLE(approch is good)

        return A;
           
        
    }
}*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prev = stack.pop();
                ans[prev] = i - prev;
            }

            stack.push(i);
        }

        return ans;
    }
}

