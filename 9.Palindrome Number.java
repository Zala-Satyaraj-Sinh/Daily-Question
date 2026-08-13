public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (e.g., -121 -> 121-)
        // Numbers ending in 0 (except 0 itself) are also not palindromes (e.g., 10 -> 01)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        // Reverse only the second half of the number to prevent integer overflow
        while (x > reversed) {
            int pop = x % 10;
            reversed = reversed * 10 + pop;
            x /= 10;
        }

        // For even-length numbers: x == reversed (e.g., 1221 -> x = 12, reversed = 12)
        // For odd-length numbers: x == reversed / 10 (e.g., 121 -> x = 1, reversed = 12)
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPalindrome(121));  // Output: true
        System.out.println(isPalindrome(-121)); // Output: false
        System.out.println(isPalindrome(10));   // Output: false
        System.out.println(isPalindrome(0));    // Output: true
    }
}
