import java.util.ArrayList;

public class NFA {

    public ArrayList<NFAState> states;
    public NFAState startState;
    public ArrayList<NFAState> acceptStates;

    public NFA() {
        states = new ArrayList<>();
        acceptStates = new ArrayList<>();
    }

    public NFA(RegularExpression r) {
        NFAState start = new NFAState();
        NFAState end = new NFAState();
        start.addTransition(r, end);

        states = new ArrayList<>();
        states.add(start);
        states.add(end);

        startState = start;

        acceptStates = new ArrayList<>();
        acceptStates.add(end);
    }

    public static NFA fromConcatenation(RegularExpression r1, RegularExpression r2) {
        NFA nfa = new NFA();
        NFA e1 = new NFA(r1);
        NFA e2 = new NFA(r2);

        nfa.states.addAll(e1.states);
        nfa.states.addAll(e2.states);
        nfa.startState = e1.startState;
        nfa.acceptStates.addAll(e2.acceptStates);

        e1.acceptStates.get(0).addTransition(RegularExpression.EPSILON, e2.startState);

        return nfa;
    }

    public static NFA fromOr(RegularExpression r1, RegularExpression r2) {
        NFA nfa = new NFA();
        NFA e1 = new NFA(r1);
        NFA e2 = new NFA(r2);

        nfa.states.addAll(e1.states);
        nfa.states.addAll(e2.states);
        nfa.startState = new NFAState();
        nfa.acceptStates.add(new NFAState());

        nfa.startState.addTransition(RegularExpression.EPSILON, e1.startState);
        nfa.startState.addTransition(RegularExpression.EPSILON, e2.startState);
        e1.acceptStates.get(0).addTransition(RegularExpression.EPSILON, nfa.acceptStates.get(0));
        e2.acceptStates.get(0).addTransition(RegularExpression.EPSILON, nfa.acceptStates.get(0));

        return nfa;
    }

    public static NFA fromClosure(RegularExpression r) {
        NFA nfa = new NFA();
        NFA e = new NFA(r);

        nfa.states.addAll(e.states);
        nfa.startState = new NFAState();
        nfa.acceptStates.add(new NFAState());

        nfa.startState.addTransition(RegularExpression.EPSILON, e.startState);
        nfa.startState.addTransition(RegularExpression.EPSILON, nfa.acceptStates.get(0));
        e.acceptStates.get(0).addTransition(RegularExpression.EPSILON, e.startState);
        e.acceptStates.get(0).addTransition(RegularExpression.EPSILON, nfa.acceptStates.get(0));

        return nfa;
    }

    public void simplify () {
        while(true) {
            // Check if all states have simple transitions and expand those that don't
            for (int i = 0; i < states.size(); ++i) {
                NFAState state = states.get(i);
                // Check transitions

            }
        }
    }

}
