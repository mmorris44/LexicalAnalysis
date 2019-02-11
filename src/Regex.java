/**
 * Front facing class to interact with
 */
public class Regex {

    private String regexString;

    public Regex(String regexString) {
        this.regexString = regexString;
    }

    public void compile() {
        RegularExpression re = new RegularExpression(regexString);
        NFA nfa = new NFA(re);
        nfa.simplify();
    }

    public boolean match(String string) {
        return false;
    }

}
