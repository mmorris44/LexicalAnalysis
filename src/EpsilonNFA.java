import java.util.ArrayList;

public class EpsilonNFA {

    public ArrayList<State> states;
    public State startState;
    public ArrayList<State> acceptStates;

    public EpsilonNFA() {
        states = new ArrayList<>();
        acceptStates = new ArrayList<>();
    }

    public EpsilonNFA(RegularExpression r) {
        State start = new State();
        State end = new State();
        start.addTransition(r, end);

        states = new ArrayList<>();
        states.add(start);
        states.add(end);

        startState = start;

        acceptStates = new ArrayList<>();
        acceptStates.add(end);
    }

    public static EpsilonNFA fromConcatenation(RegularExpression r1, RegularExpression r2) {
        EpsilonNFA epsilonNFA = new EpsilonNFA();
        EpsilonNFA e1 = new EpsilonNFA(r1);
        EpsilonNFA e2 = new EpsilonNFA(r2);

        epsilonNFA.states.addAll(e1.states);
        epsilonNFA.states.addAll(e2.states);
        epsilonNFA.startState = e1.startState;
        epsilonNFA.acceptStates.addAll(e2.acceptStates);

        e1.acceptStates.get(0).addTransition(new RegularExpression(""), e2.startState);

        return epsilonNFA;
    }

    public static EpsilonNFA fromOr(RegularExpression r1, RegularExpression r2) {
        EpsilonNFA epsilonNFA = new EpsilonNFA();
        EpsilonNFA e1 = new EpsilonNFA(r1);
        EpsilonNFA e2 = new EpsilonNFA(r2);

        epsilonNFA.states.addAll(e1.states);
        epsilonNFA.states.addAll(e2.states);
        epsilonNFA.startState = new State();
        epsilonNFA.acceptStates.add(new State());

        epsilonNFA.startState.addTransition(new RegularExpression(""), e1.startState);
        epsilonNFA.startState.addTransition(new RegularExpression(""), e2.startState);
        e1.acceptStates.get(0).addTransition(new RegularExpression(""), epsilonNFA.acceptStates.get(0));
        e2.acceptStates.get(0).addTransition(new RegularExpression(""), epsilonNFA.acceptStates.get(0));

        return epsilonNFA;
    }

    public static EpsilonNFA fromClosure(RegularExpression r) {
        EpsilonNFA epsilonNFA = new EpsilonNFA();
        State state = new State();
        state.addTransition(r, state);

        epsilonNFA.startState = state;
        epsilonNFA.acceptStates.add(state);
        return epsilonNFA;
    }

}
