public class Palindrome {
    /*what the first method got to do is converting
    *a string type to a deque with the original order
    */
    public  Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }
    /*to make a judgement whether word is a Palindrome or not
    */
    public   boolean isPalindrome(String word) {
        Deque a = wordToDeque(word);
        Deque b = new ArrayDeque<>();
        int count = a.size() - 1;
        for (; count >= 0; count--) {
            b.addLast(a.get(count));
        }
      return isPalindromeHelper(a, b);
    }

    private  boolean isPalindromeHelper(Deque x1, Deque x2) {
        int m = 0;
        for (int i = 0; i < x1.size(); i++) {
            if (x1.get(i).equals(x2.get(i))) {
                m++;
            }
        }
        if (m == x1.size()) {
            return true;
        }
        return false;
    }
    /*to make a judgement whether a string is have some OffOne character */

     public  boolean isPalindrome(String word, CharacterComparator cc) {
         int i = 0;
         int counter = 0;
      for (; i < (word.length()) / 2; i++) {
          int back = word.length() - i - 1;
        if (cc.equalChars(word.charAt(i), word.charAt(back)) == true) {
            counter++;
        }
      }
         return counter == word.length() / 2 ? true : false;
    }
    /*the code above is by myself*/

}
//remember to delete the static decoration
