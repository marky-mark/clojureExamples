package chapter2;

public class StatefulInteger extends Number {
    private int state;
    public StatefulInteger (int initialState) {
        this.state = initialState;
    }
    public void setInt (int newState) {
        this.state = newState;
    }

    public int intValue () {
        return state;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public int hashCode () {
        return state;
    }

    @Override
    public boolean equals (Object obj) {
        return obj instanceof StatefulInteger &&
                state == ((StatefulInteger)obj).state;
    }
}
