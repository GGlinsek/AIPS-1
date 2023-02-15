import java.util.Scanner;

public class Naloga1 {
    public static void main(String[] args) {
        String vrstica;
        Scanner sc_v;
        sc_v = new Scanner(System.in);
        while (sc_v.hasNextLine()){
            vrstica = sc_v.nextLine();
            Kalkulator.kalkulator(vrstica);
        }
    }
}

class Kalkulator {

    static Sequence<Stack<String>> SeznamStackov = new ArrayDeque<>();

    private static boolean pogoj = false;
    private static boolean funPogoj = false;
    private static int placementStack = 0;
    private static int ukazi = 0;


    static void kalkulator(String vrstica){
        for (int i = 0; i < 42; i++) {
            Stack<String> s = new ArrayDeque<>();
            SeznamStackov.add(s);
        }


        for (String word : vrstica.split("\\s+")) {

            if (funPogoj){
                pushToStack(word, placementStack);
            }
            else{
                pogoji(word, placementStack);
            }
            if (ukazi != 0){
                ukazi--;
            }
            else{
                placementStack = 0;
                funPogoj = false;
            }
        }
        SeznamStackov = new ArrayDeque<>();
        pogoj = false;
        funPogoj = false;
        placementStack = 0;
        ukazi = 0;
    }
    private static void pushToStack(String word, int x){
        SeznamStackov.get(x).push(word);
    }

    private static void pogoji(String word, int x){
        String a = Character.toString(word.charAt(0));
        if (a.equals("?") && !funPogoj){
            if (!pogoj){
                return;
            }
            else{
                word = word.replace("?","");
            }
        }
        switch (word) {
            case "echo":
                echo();
                break;
            case "pop":
                pop();
                break;
            case "dup":
                dup();
                break;
            case "dup2":
                dup2();
                break;
            case "swap":
                swap();
                break;
            case "print":
                print();
                break;
            case "char":
                znak();
                break;
            case "even":
                even();
                break;
            case "odd":
                odd();
                break;
            case "!":
                factorial();
                break;
            case "len":
                len();
                break;
            case "<>":
                notequal();
                break;
            case "<":
                bigger();
                break;
            case "<=":
                biggerequal();
                break;
            case "==":
                equal();
                break;
            case ">":
                smaller();
                break;
            case ">=":
                smallerequal();
                break;
            case "+":
                plus();
                break;
            case "-":
                minus();
                break;
            case "*":
                multiply();
                break;
            case "/":
                wholedivison();
                break;
            case "%":
                divide();
                break;
            case ".":
                connect();
                break;
            case "rnd":
                random();
                break;
            case "then":
                then();
                break;
            case "else":
                otherwise();
                break;
            case "clear":
                clear();
                break;
            case "run":
                run();
                break;
            case "loop":
                loop();
                break;
            case "fun":
                fun();
                break;
            case "move":
                move();
                break;
            case "reverse":
                reverse();
                break;
            default:
                pushToStack(word, x);
        }
    }



    ///echo pop dup dup2 swap

    private static void echo(){
        if (SeznamStackov.get(0).top() != null){
            System.out.println(SeznamStackov.get(0).top());
        }
        else {
            System.out.println();
        }
    }

    private static void pop(){
        SeznamStackov.get(0).pop();
    }

    private static void dup(){
        SeznamStackov.get(0).push(SeznamStackov.get(0).top());
    }

    private static void dup2(){
        Stack<String> seznam = SeznamStackov.get(0);
        String zadnji = seznam.pop();
        String predzadnji = seznam.pop();
        SeznamStackov.get(0).push(predzadnji);
        SeznamStackov.get(0).push(zadnji);
        SeznamStackov.get(0).push(predzadnji);
        SeznamStackov.get(0).push(zadnji);
    }

    private static void swap(){
        String a = SeznamStackov.get(0).pop();
        String b = SeznamStackov.get(0).pop();
        SeznamStackov.get(0).push(a);
        SeznamStackov.get(0).push(b);
    }

    ///char even odd ! len

    private static void znak() {
        int ascii = Integer.parseInt(SeznamStackov.get(0).pop());
        char b = (char)ascii;
        SeznamStackov.get(0).push(Character.toString(b));
    }

    private static void even() {
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        if (a%2==0){
            SeznamStackov.get(0).push("1");
        }
        else{
            SeznamStackov.get(0).push("0");
        }
    }

    private static void odd() {
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        if (a%2==0){
            SeznamStackov.get(0).push("0");
        }
        else{
            SeznamStackov.get(0).push("1");
        }
    }

    private static void factorial(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = 1;
        for (int i = a; i > 0; i--) {
            b *= i;
        }
        SeznamStackov.get(0).push(Integer.toString(b));
    }

    private static void len(){
        SeznamStackov.get(0).push(String.valueOf(SeznamStackov.get(0).pop().length()));
    }

    /// <> < <= == > >= + - * / % . rnd

    private static void  notequal(){
        String a = SeznamStackov.get(0).pop();
        String b = SeznamStackov.get(0).pop();
        if (a.equals(b)){
            SeznamStackov.get(0).push("0");
        }
        else {
            SeznamStackov.get(0).push("1");
        }
    }

    private static void  bigger(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        if (b<a){
            SeznamStackov.get(0).push("1");
        }
        else {
            SeznamStackov.get(0).push("0");
        }
    }

    private static void  biggerequal(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        if (b<=a){
            SeznamStackov.get(0).push("1");
        }
        else {
            SeznamStackov.get(0).push("0");
        }
    }

    private static void  equal(){
        String a = SeznamStackov.get(0).pop();
        String b = SeznamStackov.get(0).pop();
        if (a.equals(b)){
            SeznamStackov.get(0).push("1");
        }
        else {
            SeznamStackov.get(0).push("0");
        }
    }

    private static void  smaller(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        if (b>a){
            SeznamStackov.get(0).push("1");
        }
        else {
            SeznamStackov.get(0).push("0");
        }
    }

    private static void  smallerequal(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        if (b>=a){
            SeznamStackov.get(0).push("1");
        }
        else {
            SeznamStackov.get(0).push("0");
        }
    }

    private static void plus(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        SeznamStackov.get(0).push(String.valueOf(a+b));
    }

    private static void minus(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        SeznamStackov.get(0).push(String.valueOf(b-a));
    }

    private static void multiply(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        SeznamStackov.get(0).push(String.valueOf(a*b));
    }

    private static void wholedivison(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        SeznamStackov.get(0).push(String.valueOf(b/a));
    }

    private static void divide(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        SeznamStackov.get(0).push(String.valueOf(b%a));
    }

    private static void connect(){
        String a = SeznamStackov.get(0).pop();
        String b = SeznamStackov.get(0).pop();
        SeznamStackov.get(0).push(b+a);
    }

    private static void random(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        int b = Integer.parseInt(SeznamStackov.get(0).pop());
        SeznamStackov.get(0).push(String.valueOf((int)(Math.random()* (a-b) + b)));
    }

    ///then else

    private static void then(){
        int a = Integer.parseInt(SeznamStackov.get(0).pop());
        pogoj = a != 0;
    }

    private static void otherwise(){
        pogoj = !pogoj;
    }

    ///print clear run loop fun move reverse

    private static void print(){
        Stack<String> sklad = SeznamStackov.get(Integer.parseInt(SeznamStackov.get(0).pop()));
        Stack<String> zacasno = new ArrayDeque<>();
        while (sklad.top()!=null){
            zacasno.push(sklad.top());
            System.out.print(sklad.pop() + " ");
        }
        System.out.println();
        while (zacasno.top()!=null){
            sklad.push(zacasno.pop());
        }
    }

    private static void clear(){
        Stack<String> sklad = SeznamStackov.get(Integer.parseInt(SeznamStackov.get(0).pop()));
        while (sklad.top()!=null){
            sklad.pop();
        }
    }

    private static void run(){
        Stack<String> sklad = SeznamStackov.get(Integer.parseInt(SeznamStackov.get(0).pop()));
        Stack<String> zacasno = new ArrayDeque<>();
        while (sklad.top() != null){
            zacasno.push(sklad.pop());
        }
        while (zacasno.top() != null){
            sklad.push(zacasno.top());
            pogoji(zacasno.pop(), 0);
        }
    }

    private static void loop(){
        Stack<String> sklad = SeznamStackov.get(Integer.parseInt(SeznamStackov.get(0).pop()));
        int stPonovitev = Integer.parseInt(SeznamStackov.get(0).pop());
        Stack<String> zacasno = new ArrayDeque<>();
        for (int i = stPonovitev; i > 0; i--) {
            while (sklad.top() != null) {
                zacasno.push(sklad.pop());
            }
            while (zacasno.top() != null) {
                sklad.push(zacasno.top());
                pogoji(zacasno.pop(), 0);
            }
        }
    }

    private static void fun(){
        placementStack = Integer.parseInt(SeznamStackov.get(0).pop());
        ukazi = Integer.parseInt(SeznamStackov.get(0).pop());
        funPogoj = true;
    }

    private static void move(){
        int vStack = Integer.parseInt(SeznamStackov.get(0).pop());
        int stukazov = Integer.parseInt(SeznamStackov.get(0).pop());
        for (int i = stukazov; i > 0; i--) {
            SeznamStackov.get(vStack).push(SeznamStackov.get(0).pop());
        }
    }

    private static void reverse(){
        Stack<String> sklad = SeznamStackov.get(Integer.parseInt(SeznamStackov.get(0).pop()));
        Stack<String> prviPomozni = new ArrayDeque<>();
        Stack<String> drugiPomozni = new ArrayDeque<>();
        while (sklad.top() != null){
            prviPomozni.push(sklad.pop());
        }
        while (prviPomozni.top() != null){
            drugiPomozni.push(prviPomozni.pop());
        }
        while (drugiPomozni.top() != null){
            sklad.push(drugiPomozni.pop());
        }
    }

}

class ArrayDeque<T> implements Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;

    private T[] a;
    private int front, back;
    @SuppressWarnings({"unchecked", "deprecated"})
    public ArrayDeque(){
        a = (T[])(new Object[DEFAULT_CAPACITY]);
        front = 0;
        back = 0;
    }
    private int next(int i){
        return (i+1)%DEFAULT_CAPACITY;
    }
    private int prev (int i) {
        return (DEFAULT_CAPACITY + i - 1) % DEFAULT_CAPACITY;
    }


    @Override
    public T top() {
        return a[prev(back)];
    }

    @Override
    public void push(T x) {
        a[back] = x;
        back = next(back);
    }

    @Override
    public T pop() {
        back = prev(back);
        T o = a[back];
        a[back] = null;
        return  o;
    }

    @Override
    public T get(int i) {
        return a[i];
    }

    @Override
    public void add(T x) {
        a[back] = x;
        back = next(back);
    }
}

interface Stack<T>{
    T top();
    void push(T x);
    T pop();
}

interface Sequence<T> {
    T get(int i);
    void add(T x);
}
