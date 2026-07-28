class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {

            long value = b;
            int multiple = 1;

            while (a >= (value << 1)) {
                value = value << 1;
                multiple = multiple << 1;
            }

            a -= value;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
