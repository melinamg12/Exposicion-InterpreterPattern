interface Expression{
    boolean interpreter(String con);
}
  
class TerminalExpression implements Expression {
    String data;
  
    public TerminalExpression(String data){
        this.data = data; 
    }
  
    public boolean interpreter(String con) {
        if(con.contains(data)){
            return true;
        }
        else{
            return false;  
        }
    }
}

class OrExpression implements Expression 
{
    Expression expr1;
    Expression expr2;
  
    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    public boolean interpreter(String con) {     	
        return expr1.interpreter(con) || expr2.interpreter(con);
    }
}

class AndExpression implements Expression {
    Expression expr1;
    Expression expr2;
  
    public AndExpression(Expression expr1, Expression expr2) { 
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    public boolean interpreter(String con) {     	
        return expr1.interpreter(con) && expr2.interpreter(con);
    }
}
  
// Driver class
class InterpreterPattern{
  
    public static void main(String[] args) {
        Expression person1 = new TerminalExpression("Maria");
        Expression person2 = new TerminalExpression("Lucas");
        Expression isSingle = new OrExpression(person1, person2);
          
        Expression victor = new TerminalExpression("Victor");
        Expression comprometido = new TerminalExpression("Comprometido");
        Expression isCommitted = new AndExpression(victor, comprometido); 	
  
        System.out.println(isSingle.interpreter("Maria"));
        System.out.println(isSingle.interpreter("Lucas"));
        System.out.println(isSingle.interpreter("Alejandro"));
          
        System.out.println(isCommitted.interpreter("Comprometido, Victor"));
        System.out.println(isCommitted.interpreter("Soltero, Victor"));
  
    }
}
