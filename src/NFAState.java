import java.util.HashMap;
import java.util.HashSet;

public class NFAState {

    public HashMap<RegularExpression, HashSet<NFAState>> transitions;

    public NFAState() {
        transitions = new HashMap<>();
    }

    public void addTransition (RegularExpression r, NFAState s) {
        if (transitions.containsKey(r)) {
            transitions.get(r).add(s);
        } else {
            HashSet<NFAState> hashSet = new HashSet<>();
            hashSet.add(s);
            transitions.put(r, hashSet);
        }
    }

}
