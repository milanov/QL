package nl.uva.softwcons.ast.expression.binary.comparison;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class NotEqual extends EqualityExpression {

    public NotEqual(final Expression left, final Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}