package nl.uva.softwcons.ql.ast.expression.binary.logical;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.ast.type.UndefinedType;

public abstract class LogicalExpression extends BinaryExpression {
    private final LineInfo lineInfo;

    public LogicalExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right);

        this.lineInfo = lineInfo;
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for comparison expressions - {@link And}, {@link Or}
     */
    public static Type resolveType(final Type type, final Type otherType) {
        if (type == BooleanType.instance && otherType == BooleanType.instance) {
            return BooleanType.instance;
        }

        return UndefinedType.instance;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}