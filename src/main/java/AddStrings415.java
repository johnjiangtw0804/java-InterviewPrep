public class AddStrings415 {
    class Solution {
        public String addStrings(String num1, String num2) {

            int num1Length = num1.length() - 1;
            int num2Length = num2.length() - 1;

            if (num1Length < 0) {
                return num2;
            } else if (num2Length < 0) {
                return num1;
            }

            int sum;
            int carry = 0;

            StringBuilder result = new StringBuilder();
            while (num1Length >= 0 || num2Length >= 0) {
                int current_1 = num1Length < 0 ? 0 : num1.charAt(num1Length) - '0';
                int current_2 = num2Length < 0 ? 0 : num2.charAt(num2Length) - '0';

                // 5 + 9 = 14 sum = 4 carry = 1
                sum = (current_2 + current_1 + carry) % 10;
                carry = (current_2 + current_1 + carry) / 10;

                // 4
                result.append(sum);
                num1Length--;
                num2Length--;
            }
            if (carry != 0) {
                result.append(carry);
            }

            return result.reverse().toString();
        }
    }
}
