import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class State {

    public HashMap<RegularExpression, HashSet<State>> transitions;

    public State() {
        transitions = new HashMap<>();
    }

    public void addTransition (RegularExpression r, State s) {
        if (transitions.containsKey(r)) {
            transitions.get(r).add(s);
        } else {
            HashSet<State> hashSet = new HashSet<>();
            hashSet.add(s);
            transitions.put(r, hashSet);
        }
    }

}
