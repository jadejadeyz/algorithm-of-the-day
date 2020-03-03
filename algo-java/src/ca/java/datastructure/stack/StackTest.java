package ca.java.datastructure.stack;

public class StackTest {

    public static void main(String[] args) {
        IStack stack = new ListStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.contains(4));
        System.out.println(stack.access(2));
        System.out.println("Left: " + stack.size());
    }


}
