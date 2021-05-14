package algo;

public class AddBinary {
    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuilder builder = new StringBuilder(maxLength + 1);

        for (int i = 1; i <= maxLength; i++) {
            int aVal = a.length() - i >= 0 ? a.charAt(a.length() - i) - '0' : 0;
            int bVal = b.length() - i >= 0 ? b.charAt(b.length() - i) - '0' : 0;
            int sum = aVal + bVal + carry;

            builder.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) builder.append(carry);
        return builder.reverse().toString();
    }
}
