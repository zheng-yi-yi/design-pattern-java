package cn.zhengyiyi.class3_behavioral_pattern.d11_interpreter;

import java.util.HashMap;
import java.util.Map;

// Context类
class Context {
    private final Map<String, Integer> variables;

    public Context() {
        variables = new HashMap<>();
    }

    public int get(String name) {
        return variables.get(name);
    }

    public void set(String name, int value) {
        variables.put(name, value);
    }
}

// 抽象表达式
interface Expression {
    int interpret(Context context);
}

// 终结符表达式
class Number implements Expression {
    private final String name;

    public Number(String name){
        this.name = name; 
    }

    public int interpret(Context context){
        return context.get(name);
    }
}

// 非终结符表达式 - 加法
class Add implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Add(Expression leftExpression, Expression rightExpression) { 
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public int interpret(Context context) { 
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}

// 非终结符表达式 - 减法
class Subtract implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Subtract(Expression leftExpression, Expression rightExpression) { 
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public int interpret(Context context) { 
        return leftExpression.interpret(context) - rightExpression.interpret(context);
    }
}

// 测试代码
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.set("a", 5);
        context.set("b", 3);

        Expression addExpression = new Add(new Number("a"), new Number("b"));
        System.out.println("a + b = " + addExpression.interpret(context));

        Expression subtractExpression = new Subtract(new Number("a"), new Number("b"));
        System.out.println("a - b = " + subtractExpression.interpret(context));
    }
}