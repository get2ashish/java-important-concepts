package ashish.examples.datastructures;

public class Stack<T> {
    private final T[] stackArray;
    private final int size;
    private int top;

    public Stack(int size) {
        this.stackArray = (T[]) new Object[size];
        this.size = size;
        this.top = -1;
    }

    public void push(T item) {
        if (top != size - 1) {
            stackArray[++top] = item;
            System.out.println("Element pushed: " + item);
        } else {
            System.out.println("Stack is full cant push a new element " + item);
        }
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return stackArray[top--];
        }
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.printStack();
        myStack.peek();
        int element = myStack.pop();
        System.out.println("Element removed is " + element);
        myStack.printStack();
        System.out.println("Is stack empty "+myStack.isEmpty());
    }

}
