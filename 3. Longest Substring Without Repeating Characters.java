import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        // Map to store the most recent index of each character
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is seen and its index is within the current window
            if (lastSeen.containsKey(currentChar)) {
                left = Math.max(left, lastSeen.get(currentChar) + 1);
            }
            
            // Update the last seen position of the character
            lastSeen.put(currentChar, right);
            
            // Update maximum window length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

