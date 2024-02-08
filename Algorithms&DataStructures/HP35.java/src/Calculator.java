
public class Calculator {

    // 10 + 2 * 5
    // 10 2 5 * +    in reversed Polish notation
    public static void main(String[] args) throws Exception {

        Item[] expr = {
            Item.Value(10),
            Item.Value(2),
            Item.Value(5),
            Item.Mul(),
            Item.Add()
      
        };

        Calculator calc = new Calculator(expr);

        int res = calc.run();

        System.out.println(" Calculator: res = " + res );
        System.out.println((System.nanoTime() / 1000000000));

    }

    Item[] expr;
    int pos;
    Stack stack;
    
    public Calculator(Item[] expr) {
        this.expr = expr;
        this.pos = 0;
        //this.stack = new Stack.staticstack();  //staticstack
        this.stack = new Stack.DynamicStack(); //DynamicStack
        

    }

    public int run() {
        while( pos < expr.length ) {
            step();
        }
        return stack.pop();
    }


    public void step() {
        Item nxt = expr[pos++];

        switch(nxt.type()) {
    
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push( x + y );
                break;
            }

            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push( x * y );
                break;
            }

            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push( x / y);
                break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }

            case VALUE : {
                int x = Item.getvalue(nxt);
                stack.push(x);
                break;
            }
        }
    }
}

   

    




