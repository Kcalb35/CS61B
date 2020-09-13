import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("cattac"));
        assertTrue(palindrome.isPalindrome("catac"));
        assertTrue(palindrome.isPalindrome("a"));

        var obo = new OffByOne();

        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("aaa", obo));

        var ob3 = new OffByN(3);

        assertTrue(palindrome.isPalindrome("abcfed", ob3));
    }
}
