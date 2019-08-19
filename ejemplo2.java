public interface Expression {
    int interpret();
}

public class NumberExpression implements Expression{
    private int number;
    public NumberExpression(int number){
        this.number=number;
    }
    public NumberExpression(String number){
        this.number=Integer.parseInt(number);
    }
    @Override
    public int interpret(){
        return this.number;
    }
}

public class AdditionExpression implements Expression {
    private Expression firstExpression,secondExpression;
    public AdditionExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
    }
    @Override
    public int interpret(){
        return this.firstExpression.interpret()+this.secondExpression.interpret();
    }
    @Override
    public String toString(){
        return "+";
    }
}

public class SubtractionExpression implements Expression{
    private Expression firstExpression,secondExpression;
    public SubtractionExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
    }
    @Override
    public int interpret(){
        return this.firstExpression.interpret()-this.secondExpression.interpret();
    }
    @Override
    public String toString(){
        return "-";
    }
}

public class MultiplicationExpression implements Expression{
    private Expression firstExpression,secondExpression;
    public MultiplicationExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
    }
    @Override
    public int interpret(){
        return this.firstExpression.interpret()*this.secondExpression.interpret();
    }
    @Override
    public String toString(){
        return "*";
    }
}

public class ParserUtil {
    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*"));
    }
    public static Expression getExpressionObject(Expression firstExpression,Expression secondExpression,String symbol){
        if(symbol.equals("+"))
            return new AdditionExpression(firstExpression,secondExpression);
        else if(symbol.equals("-"))
            return new SubtractionExpression(firstExpression,secondExpression);
        else
            return new MultiplicationExpression(firstExpression,secondExpression);
    }
}

//PARSE PARA PODER HACER LA OPERACIÓN
//UTILIZA UNA PILA PARA HACER LAS OPERACIONES EN ORDEN
public class ExpressionParser {
    Stack stack=new Stack<>();
    public int parse(String str){
        String[] tokenList = str.split(" ");
        for (String symbol : tokenList) {
            if (!ParserUtil.isOperator(symbol)) {
                Expression numberExpression = new NumberExpression(symbol);
                stack.push(numberExpression);
                System.out.println(String.format("Pushed to stack: %d", numberExpression.interpret()));
            } else  if (ParserUtil.isOperator(symbol)) {
                Expression firstExpression = stack.pop();
                Expression secondExpression = stack.pop();
                System.out.println(String.format("Popped operands %d and %d",
                        firstExpression.interpret(), secondExpression.interpret()));
                Expression operator = ParserUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                System.out.println(String.format("Applying Operator: %s", operator));
                int result = operator.interpret();
                NumberExpression resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                System.out.println(String.format("Pushed result to stack: %d", resultExpression.interpret()));
            }
        }
       int result= stack.pop().interpret();
        return result;
    }
}

//TEST
public class ExpressionParserTest {
    @Test
    public void testParse() throws Exception {
      String input="2 1 5 + *";
       ExpressionParser expressionParser=new ExpressionParser();
       int result=expressionParser.parse(input);
       System.out.println("Final result: "+result);
    }
}
