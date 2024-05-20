package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class leftPadTest {

    @Test
    public void test01() {
        assertEquals("esqdrt", LeftPad.leftPad("drt", 6, "esq"));
    }

    @Test
    public void test02() {
        assertEquals("drt", LeftPad.leftPad("drt", 6, "."));
    }

    @Test
    public void test03() {
        assertEquals("abdef", LeftPad.leftPad("def", 5, "abc"));
    }

    @Test
    public void strNull() {
        assertNull(LeftPad.leftPad(null, 5, "-"));
    }

    @Test
    public void strEmpty() {
        assertEquals("-----", LeftPad.leftPad("", 5, "-"));
    }

    @Test
    public void padStrNull() {
        assertEquals("  abc", LeftPad.leftPad("abc", 5, null));
    }

    @Test
    public void PadStrEmpty() {
        assertEquals("  abc", LeftPad.leftPad("abc", 5, ""));
    }

    @Test
    public void strings() {
        assertEquals("12abc", LeftPad.leftPad("abc", 5, "12"));
    }

    @Test
    public void sizeNegative() {
        assertNull(LeftPad.leftPad("abc", -1, "-"));
    }

    @Test
    public void sizeGreaterThanOne() {
        assertEquals("abc", LeftPad.leftPad("abc", 2, "-"));
    }

    @Test
    public void sizeGreaterThanOne2() {
        assertEquals("---abc", LeftPad.leftPad("abc", 6, "-"));
    }

    @Test
    public void sizeZero() {
        assertEquals("abc", LeftPad.leftPad("abc", 0, "-"));
    }

    @Test
    public void sizeEqualsStr() {
        assertEquals("wxyz", LeftPad.leftPad("wxyz", 4, "a"));
    }

    @Test
    public void sizeEqualspadStr() {
        assertEquals("wxya", LeftPad.leftPad("a", 4, "wxyz"));
    }

    @Test
    public void sizeEqualsStrPluspadStr() {
        assertEquals("abcdef", LeftPad.leftPad("def", 6, "abc"));
    }

    @Test
    public void sizeEqualsExtremer() {
        assertEquals("------------------------------------------------------------------------------------------------test", LeftPad.leftPad("test", 100, "-"));
    }

    @Test
    public void testPadStrContainsSpecialCharacters() {
        assertEquals("#*!#*!abc", LeftPad.leftPad("abc", 9, "#*!"));
    }

    @Test
    public void testPadStrContainsNewLine() {
        assertEquals("abc", LeftPad.leftPad("abc", 3, "\n"));
    }    

}
