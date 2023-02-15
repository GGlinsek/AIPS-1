import java.util.Scanner;

public class Naloga3 {
    public static void main(String[] args) {
        Scanner sc_v;
        sc_v = new Scanner(System.in);
        String line = sc_v.nextLine();
        int length = Integer.parseInt(sc_v.nextLine().split("\\s+")[0]);
        info(length, sc_v);
    }


    public static void info(int length, Scanner sc_v){
        int[] list = new int[length];
        int[] list2 = new int[length];
        int x = 0;
        while (sc_v.hasNextLine()){
            String line =sc_v.nextLine();
            list[Integer.parseInt(line.split("\\s+")[0])]++;
            list2[Integer.parseInt(line.split("\\s+")[1])]++;
            x++;
        }
        System.out.println(length + " " + x);
        for (int i = 0; i < list.length; i++) {
            System.out.println(i+ " " + list[i] + " " + list2[i]);
        }
    }
}
