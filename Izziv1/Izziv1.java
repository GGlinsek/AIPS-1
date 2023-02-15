package Izziv1;

public class Izziv1 {

    public static void main(String[] args) throws CollectionException {
        Stack<String> s = new ArrayDeque<String>();
        Deque<String> d = new ArrayDeque<String>();
        Sequence<String> z = new ArrayDeque<String>();


        System.out.println("DEQUE:\n");
        System.out.println("Enqueue in EnqueueFront:");
        d.enqueue("a");
        d.enqueue("b");
        d.enqueue("c");
        d.enqueueFront("x");
        System.out.println("\nreturn value - " + d + "\nexpected value - [x, a, b, c]");
        System.out.println("________________________________________________________________");
        System.out.println("Front and Back:");
        System.out.println("\ncelotni deque" + d.toString());
        System.out.println("\nreturn value back - " + d.back() + "\nexpected value back - c");
        System.out.println("\nreturn value front - " + d.front() + "\nexpected value front - x");
        System.out.println("________________________________________________________________");
        System.out.println("Dequeue Back in Dequeue:");
        System.out.println("Začetna vrsta" + d);
        d.dequeueBack();
        d.dequeue();
        System.out.println("Return value - " + d + "\nexpected value - [a, b]");
        System.out.println("_________________________________________________________________");

        System.out.println("STACK:");
        System.out.println("_________________________________________________________________\n");
        System.out.println("Push:\n");
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println("return value - "+ s.toString() + "\nexpected value - [A, B, C]");
        System.out.println("__________________________________________________________________");
        System.out.println("Top:\n");
        System.out.println("Celotni Stack - " + s);
        System.out.println("\nreal value - " + s.top() + "\nexpected value - C");
        System.out.println("__________________________________________________________________");
        System.out.println("Pop:\n");
        System.out.println(s);
        s.pop();
        System.out.println("real value - "+ s + "\nexpected value - [A, B]\n");
        System.out.println("___________________________________________________________________");
        System.out.println("SEQUENCE:");
        System.out.println("___________________________________________________________________\n");
        System.out.println("Add:\n");
        z.add("a");
        z.add("b");
        z.add("c");
        System.out.print("real value - ");
        for(int i = 0; i < z.size(); i++)
            System.out.print((i) + ". " + z.get(i) + " ");
        System.out.println("\nexpected value - 0. a 1. b 2. c");
        System.out.println("_____________________________________________________________________");
        System.out.println("Get:\n");
        String getElement = z.get(0);
        System.out.println("real value - " + z.get(0) + "\nexpected value - a");


    }


}

