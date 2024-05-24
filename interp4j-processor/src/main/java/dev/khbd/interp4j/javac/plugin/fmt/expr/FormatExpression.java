package dev.khbd.interp4j.javac.plugin.fmt.expr;

import java.util.ArrayList;
import java.util.List;

/**
 * Format expression model.
 *
 * @author Sergei Khadanovich
 */
public class FormatExpression {

    private final List<FormatExpressionPart> parts;

    public FormatExpression(List<FormatExpressionPart> parts) {
        this.parts = new ArrayList<>(parts);
    }

    /**
     * Visit fmt expression.
     *
     * @param visitor visitor
     */
    public void visit(FormatExpressionVisitor visitor) {
        visitor.start();
        for (FormatExpressionPart part : parts) {
            part.visit(visitor);
        }
        visitor.finish();
    }
}