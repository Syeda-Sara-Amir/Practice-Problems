// QUESTION: Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false
// Constraints: s and t consist of lowercase English letters.

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false; // if there arent same amount of char in both we automatically know they are diff
        }

//         // ================================ MY SOLUTION =================================================//
//         // i would save one string into a hashmap, and the compare that hasmap to the other string
//         // since hashmap has key value pairs, we will check if the letter in hashmap is in the other string and if it is we chenge its value to 1
//         // if it isnt then we chnage value to 0 
//         // after that we check if we have any 0 in the values, if we do then it is NOT an anagram 

//         //why this doesnt work? -> this only works when there are no duplicates, the values mix up if there are duplicates

        // ==================== MOST EFFICIENT SOLUTION ==============================//

        int[] count = new int[26]; // we are making exactly 26 indexed array cause there are total of 26 lowercase english letters

        for (int i = 0; i < s.length; i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

            // why are we substracting a from the char in s and t
            // since all letters are ascii and they have a value, like a = 97
            // and every slot in the array is for one letter eg [ 0 for a, 1 for b, 2 for c, ...] So whats happening is:
            // 'a' - 'a' = 97 - 97 = 0  → slot 0
            // 'b' - 'a' = 98 - 97 = 1  → slot 1
            // 'c' - 'a' = 99 - 97 = 2  → slot 2   Basically its a trick to covnert the letter into its respective index without trying too much

            // why are we decreasing t? if both have the same letters the array would be null array in the end
        }

        for(int val : count){
            if(val != 0) return false;
        }
        return true;
    }
}

// array lookup is faster than hashmaps
// time complexity: O(n)
// space complexity: O(1)

