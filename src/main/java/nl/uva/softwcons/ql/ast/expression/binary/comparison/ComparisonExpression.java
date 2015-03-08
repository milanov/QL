package nl.uva.softwcons.ql.ast.expression.binary.comparison;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.ast.type.UndefinedType;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public abstract class ComparisonExpression extends BinaryExpression {

    private static final Table<Type, Type, Type> COMPARISON_OPERATORS_TABLE = HashBasedTable.create();
    static {
        COMPARISON_OPERATORS_TABLE.put(NumberType.instance, NumberType.instance, BooleanType.instance);
    }
    private final LineInfo lineInfo;

    public ComparisonExpression(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right);

        this.lineInfo = lineInfo;
    }

    /**
     * {@inheritDoc}
     *
     * Resolves types for comparison expressions - {@link LowerThan},
     * {@link LowerOrEqual}, {@link GreaterThan}, {@link GreaterOrEqual}.
     */
    public static Type resolveType(final Type type, final Type otherType) {
        final Type resolvedType = COMPARISON_OPERATORS_TABLE.get(type, otherType);
        return resolvedType != null ? resolvedType : UndefinedType.instance;
    }

    @Override
    public LineInfo getLineInfo() {
        return lineInfo;
    }

}