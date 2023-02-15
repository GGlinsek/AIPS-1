package Izziv2;

import java.util.ArrayList;
import java.util.List;

class CompleteBinaryTreeDrawer{

    static List<Integer> Elementi = new ArrayList<>();
    static int[] XValue;
    static int[] YValue;
    static int X;
    static int Y;

    static void tree(String arg) throws InterruptedException {
        int n = Integer.parseInt(arg);
        X = n;
        Y = (int)(Math.log(n)/Math.log(2));
        XValue = new int[n];
        YValue = new int[n];
        for (int i = 1; i <= n; i++) {
            Elementi.add(i);
            YValue[i-1] = (int)(Math.log(i)/Math.log(2));
        }
        traverse(Elementi.get(0),0);




    }

    public static int traverse(int index,int x){
        if (2*index > Elementi.size() && index <= Elementi.size()){
            XValue[index-1] = x;
            return x+1;
        }
        if (2*index <= Elementi.size()){
            int neki = traverse(2*index, x);
            XValue[index-1] = neki;
            return traverse(2*index+1, neki+1);
        }
        return x;
    }

    static void drawLevelorder() throws InterruptedException {
        for (int i = 0; i < Elementi.size(); i++) {
            drawEdgeToParent(i);
            drawNode(i);
        }
    }

    static void drawPreorder(int i) throws InterruptedException {
        drawEdgeToParent(i);
        drawNode(i);
        if (2*i+1< Elementi.size()){
            drawPreorder(2*i+1);
        }
        if (2*i+2< Elementi.size()){
            drawPreorder(2*i+2);
        }
    }

    static void drawInorder(int i) throws InterruptedException {
        if (2*i+1< Elementi.size()){
            drawInorder(2*i+1);
        }
        drawEdgeToParent(i);
        drawNode(i);

        if (2*i+2< Elementi.size()){
            drawInorder(2*i+2);
        }
    }





    static void drawPostorder(int i) throws InterruptedException {
        if (2*i+1< Elementi.size()){
            drawPostorder(2*i+1);
        }

        if (2*i+2< Elementi.size()){
            drawPostorder(2*i+2);
        }
        drawEdgeToParent(i);
        drawNode(i);
    }



    static void drawNode(int i) throws InterruptedException {
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledCircle(1.0/X*(XValue[i]),1-1.0/Y*(YValue[i]), 1.0/X*0.9);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(1.0/X*XValue[i],1-1.0/Y*YValue[i], String.valueOf(Elementi.get(i)));
        Thread.sleep(100);
    }

    static void drawEdgeToParent(int i){
        if (X>1){
            StdDraw.line(1.0/X*XValue[i],1-1.0/Y*YValue[i]+1.0/X*0.9,1.0/X*XValue[(i-1)/2],1-1.0/Y*YValue[(i-1)/2]-1.0/X*0.9);
        }

    }
}

public class Izziv2 {

    public static void main(String[] args) throws InterruptedException {
        CompleteBinaryTreeDrawer.tree(args[0]);
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setScale(-.1,1.1);
        CompleteBinaryTreeDrawer.drawPostorder(0);


    }
}
