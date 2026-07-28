class Solution {
    public boolean isNumber(String s) {

        s = s.trim();

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Digit
            if (ch >= '0' && ch <= '9') {

                digitSeen = true;

                if (exponentSeen) {
                    digitAfterExponent = true;
                }
            }

            // Decimal point
            else if (ch == '.') {

                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // e or E
            else if (ch == 'e' || ch == 'E') {

                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitAfterExponent = false;
            }

            // Sign
            else if (ch == '+' || ch == '-') {

                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else
            else {
                return false;
            }
        }

        return digitSeen && digitAfterExponent;
    }
}
