import java.util.Arrays;

public class Tstack<T> {

    int pos;
    int size;
    T[] stack;

    public Tstack() {

        size = 4;
        stack = (T[]) new Object[size];
    }

    public void push(T object) {

        stack[pos++] = object;
        if(pos % size == 0)
            arrayextend();
        
    }

    private void arrayextend() {

        T[] copy = (T[]) new Object[size*2];
        for(int i = 0; i < stack.length; i++)
        {
            copy[i] = stack[i];
        }
        stack = copy;
        size = size * 2;
        System.out.println(Arrays.toString(stack));
    }

    public T pop() {

        pos--;
        if((pos < size/4))
            arraydecrease();
        return stack[pos];
        
    }

    private void arraydecrease() {

        T[] copy = (T[]) new Object[size / 2];
        for(int i = 0; i < copy.length; i++)
        {
            copy[i] = stack[i];
            
        }
        stack = copy;
        size = size / 2;
        System.out.println(Arrays.toString(stack));
    }
}
