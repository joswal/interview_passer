package array_challenges.interleaving_string;

class Solution {
    public boolean solution(String S, String T, String U) {
        // Rule 1: Length of U must be equal to the sum of lengths of S and T
        if (U.length() != S.length() + T.length()) {
            return false;
        }

        // Dynamic programming table to store interleaving results
        boolean[][] dp = new boolean[S.length() + 1][T.length() + 1];

        // Initialize the dp table
        dp[0][0] = true; // Empty strings interleave to form an empty string

        // Fill in the table for S only
        for (int i = 1; i <= S.length(); i++) {
            dp[i][0] = dp[i - 1][0] && S.charAt(i - 1) == U.charAt(i - 1);
        }

        // Fill in the table for T only
        for (int j = 1; j <= T.length(); j++) {
            dp[0][j] = dp[0][j - 1] && T.charAt(j - 1) == U.charAt(j - 1);
        }

        // Fill in the rest of the table
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                char uChar = U.charAt(i + j - 1);
                dp[i][j] = (dp[i - 1][j] && S.charAt(i - 1) == uChar) || 
                           (dp[i][j - 1] && T.charAt(j - 1) == uChar);
            }
        }

        // The result is in the bottom-right corner of the table
        return dp[S.length()][T.length()];
    }
}
