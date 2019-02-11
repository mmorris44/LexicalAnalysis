/**
 * . = any character
 * \ = interpret next character as a literal
 * *, (), and + operate in the usual way
 * Listing characters next to each other is concatenation
 * Empty string for RE is an epsilon transition
 */
public class RegularExpression {

    public static final char[] RESERVED_CHARS = {'\\', '*', '(', ')', '+'};
    public static final RegularExpression EPSILON = new RegularExpression("");

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

    public boolean match (char character) throws UnsimplifiedRegexException {
        if (!isSimple()) throw new UnsimplifiedRegexException();

        if (re.charAt(0) == '\\') return re.charAt(1) == character; // Literal
        if (re.charAt(0) == '.') return true; // Anything
        return re.charAt(0) == character; // Check for same
    }

}
