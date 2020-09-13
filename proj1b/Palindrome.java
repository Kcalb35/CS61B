public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            var head = deque.removeFirst();
            var tail = deque.removeLast();
            if (head.charValue() != tail.charValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dq = wordToDeque(word);
        while (dq.size() > 1) {
            var head = dq.removeFirst();
            var tail = dq.removeLast();
            if (!cc.equalChars(head.charValue(), tail.charValue())) {
                return false;
            }
        }
        return true;
    }
}
