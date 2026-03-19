// Question: Given a string s, return true if it is a palindrome, otherwise return false.
// A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
// Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).

// Example 1:

// Input: s = "Was it a car or a cat I saw?"
// Output: true

class Solution {
    public boolean isPalindrome(String s) {
        // char [] chars = s.toCharArray(); 
        // since the string consistes or numbes letters etc we cant make an array of a specific type 
        // we also need to ignore all non alphanumeric chars like space, coma etc
        // are if one letter is uppercase and the same letter is lowercase it wont think its same

        int i = 0;
        int j = s.length() - 1;

        while (i < j){

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;


            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;

        // We dont have to use the helper class Charater, we can make our own functions using ascii
        //     return (c >= 'a' && c <= 'z') ||
        //    (c >= 'A' && c <= 'Z') ||
        //    (c >= '0' && c <= '9');   
        // Something like this
    }
}
