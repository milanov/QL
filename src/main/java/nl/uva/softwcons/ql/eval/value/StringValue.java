package nl.uva.softwcons.ql.eval.value;

public class StringValue extends Value {
    private final String stringValue;

    public StringValue(final String value) {
        this.stringValue = value;
    }

    @Override
    public String getString() {
        return stringValue;
    }

    @Override
    public Value isEqual(final Value otherValue) {
        return otherValue.isEqualString(this);
    }

    @Override
    public Value isEqualString(final Value otherValue) {
        return new BooleanValue(this.stringValue.equals(otherValue.getString()));
    }

}
