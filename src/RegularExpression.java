import java.util.ArrayList;

/**
 * . = any character
 * ? = previous character optional
 * + = 1 or more
 * \ = interpret next character as a literal
 * *, (), and + operate in the usual way
 * Listing characters next to each other is concatenation
 * Empty string for RE is an epsilon transition
 */
public class RegularExpression {

    public static final char[] RESERVED_CHARS = {'?', '+', '\\', '*', '(', ')', '+'};
    public String re;

    public RegularExpression(String re) {
        this.re = re;
    }

    public boolean isSimple() {
        if (re.charAt(0) == '\\' && re.length() == 2) return true; // Escaped character
        if (re.length() >= 2) return false; // Too long
        if (re.isEmpty()) return true; // Empty string

        for (char c : RESERVED_CHARS) {
            if (re.charAt(0) == c) return false; // A reserved character
        }

        return true; // Any other single character
    }

}
