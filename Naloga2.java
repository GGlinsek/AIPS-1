import java.util.Scanner;

public class Naloga2 {
    public static void main(String[] args) {
        Scanner sc_v;
        sc_v = new Scanner(System.in);
        String line = sc_v.nextLine();
        String numbers = sc_v.nextLine();
        Boolean type = line.split("\\s+")[0].equals("trace");
        String order = line.split("\\s+")[1];
        Boolean path = line.split("\\s+")[2].equals("up");
        Urejanje.urejanje(type,order,path,numbers);
    }

}

class Urejanje {

    static ResizableArray<Integer> numberArray = new Array<>();

    static void urejanje(Boolean type, String order, Boolean path, String numbers){
        for (String number : numbers.split("\\s+")){
            numberArray.push(Integer.parseInt(number));
        }

        switch (order) {
            case "insert":
                insert(type, path);
                break;

            case "select":
                select(type, path);
                break;

            case "bubble":
                bubble(type, path);
                break;

            case "heap":
                heap(type, path);
                break;

            case "merge":
                merge(type, path);
                break;

            case "quick":
                quick(type, path);
                break;

        }
    }

    private static void insert(Boolean type, Boolean path){
        if (type) {trace(-1);}
        if (path){
            for (int i = 1; i < numberArray.length(); i++) {
                if (numberArray.get(i-1) > numberArray.get(i)){
                    for (int j = i; j > 0; j--) {
                        if (numberArray.get(j-1)> numberArray.get(j)){
                            swap(j, j-1);
                        }
                        else if (numberArray.get(j-1) < numberArray.get(j)){
                            break;
                        }

                    }
                }
                if (type) {trace(i);}


            }
        }
        else {
            for (int i = 1; i < numberArray.length(); i++) {
                if (numberArray.get(i-1) < numberArray.get(i)){
                    for (int j = i; j > 0; j--) {
                        if (numberArray.get(j-1) < numberArray.get(j)){
                            swap(j, j-1);
                        }
                        else if (numberArray.get(j-1) > numberArray.get(j)){
                            break;
                        }
                    }
                }
                if (type){trace(i);}

            }
        }
    }

    private static void select(Boolean type, Boolean path){
        if (type) {trace(-1);}
        if (path){
            for (int i = 0; i < numberArray.length()-1; i++) {
                int lowestNumber = numberArray.get(i);
                int lowestNumberInt = i;
                for (int j = i; j < numberArray.length(); j++) {
                    if (numberArray.get(j) < lowestNumber){
                        lowestNumber = numberArray.get(j);
                        lowestNumberInt = j;
                    }
                }
                swap(i, lowestNumberInt);
                trace(i);
            }
        }
        else {
            for (int i = 0; i < numberArray.length()-1; i++) {
                int highestNumber = numberArray.get(i);
                int highestNumberInt = i;
                for (int j = i; j < numberArray.length(); j++) {
                    if (numberArray.get(j) > highestNumber){
                        highestNumber = numberArray.get(j);
                        highestNumberInt = j;
                    }
                }
                swap(i, highestNumberInt);
                trace(i);
            }
        }
    }

    private static void bubble(Boolean type, Boolean path){
        if (type) {trace(-1);}
        if (path){
            Boolean neki = false;
            int asda = numberArray.length();
            for (int i = 0; i < numberArray.length(); i++) {
                Boolean flag = false;
                int zamenjava = i;
                for (int j = numberArray.length()-1; j > 0; j--) {
                    if (numberArray.get(j-1) > numberArray.get(j)){
                        flag = true;
                        zamenjava = j-1;
                        swap(j-1,j);

                    }
                }
                if (zamenjava == numberArray.length()-2 && flag){neki = true;}
                if (flag) {trace(zamenjava);}
                if (!flag && i == numberArray.length()-2 && !neki) {trace(i);}
            }
        }
        else {
            for (int i = 0; i < numberArray.length(); i++) {
                Boolean flag = false;
                int zamenjava = i;
                for (int j = numberArray.length()-1; j > 0; j--) {
                    if (numberArray.get(j-1) < numberArray.get(j)){
                        flag = true;
                        zamenjava = j-1;
                        swap(j-1,j);
                    }
                }
                if (flag) {trace(zamenjava);}
                if (!flag && i ==numberArray.length()-2) {trace(i);}
            }
        }
    }

    private static void heap(Boolean type, Boolean path){
        if (type) {trace(-1);}
        if (path) {
            for (int i = numberArray.length()-1; i >= 0; i--) {
                heapsortmax(i, 0);
                trace(i);
                swap(0,i);
            }
        }
        else {
            for (int i = numberArray.length()-1; i >= 0; i--) {
                heapsortmin(i, 0);
                trace(i);
                swap(0,i);
            }
        }
    }

    private static void heapsortmax(int length, int maxdepth){
        for (int i = length; i > maxdepth; i = i-2) {
            int stevilo = numberArray.get(i);
            int indexStevila = i;
            if (i%2 == 0) {
                if (stevilo <= numberArray.get(i-1)) {
                    stevilo = numberArray.get(i-1);
                    indexStevila--;
                }
                if (stevilo > numberArray.get((i/2)-1)){swap((i/2)-1, indexStevila);}
                heapsortmax(length, i);
            }
            else {
                if (i+1< numberArray.length() && stevilo < numberArray.get(i+1) && i!=length) {
                    stevilo = numberArray.get(i+1);
                    indexStevila++;
                }
                if (stevilo > numberArray.get(((i-1)/2))){swap((i-1)/2, indexStevila);}
                heapsortmax(length, i);
            }
        }
    }

    private static void heapsortmin(int length, int maxdepth){
        for (int i = length; i > maxdepth; i = i-2) {
            int stevilo = numberArray.get(i);
            int indexStevila = i;
            if (i%2 == 0) {
                if (stevilo >= numberArray.get(i-1)) {
                    stevilo = numberArray.get(i-1);
                    indexStevila--;
                }
                if (stevilo < numberArray.get((i/2)-1)){swap((i/2)-1, indexStevila);}
                heapsortmin(length, i);
            }
            else {
                if (i+1< numberArray.length() && stevilo > numberArray.get(i+1) && i!=length) {
                    stevilo = numberArray.get(i+1);
                    indexStevila++;
                }
                if (stevilo < numberArray.get(((i-1)/2))){swap((i-1)/2, indexStevila);}
                heapsortmin(length, i);
            }
        }
    }

    private static void merge(Boolean type, Boolean path){
        trace(-1);
        if (path){ mergesortmax(numberArray);}
        else { mergesortmin(numberArray);}
    }

    @SuppressWarnings({"unchecked", "deprecated"})
    private static ResizableArray mergesortmax(ResizableArray<Integer> neki){
        ResizableArray<Integer> prvaPolovica =  new Array<>();
        ResizableArray<Integer> drugaPolovica =  new Array<>();
        for (int i = 0; i < neki.length(); i++) {
            if ((neki.length()+1)/2 -1 >= i){
                prvaPolovica.push(neki.get(i));
            }
            else {
                if ((neki.length()+1)/2 -1 == i-1){
                    System.out.print("| ");
                }
                drugaPolovica.push(neki.get(i));
            }
            System.out.print(neki.get(i) + " ");
        }
        System.out.println();


        ResizableArray<Integer> pprvaPolovica =prvaPolovica;
        ResizableArray<Integer> ddrugaPolovica =drugaPolovica;
        if (prvaPolovica.length() > 1){
            pprvaPolovica = mergesortmax(prvaPolovica);
        }
        if (drugaPolovica.length() > 1){
            ddrugaPolovica = mergesortmax(drugaPolovica);
        }
            ResizableArray<Integer> skupaj =  new Array<>();

        for (int i = 0; i < pprvaPolovica.length(); i++) {
            skupaj.push(pprvaPolovica.get(i));
        }
        for (int i = 0; i < ddrugaPolovica.length(); i++) {
            skupaj.push(ddrugaPolovica.get(i));
        }

        for (int i = 0; i < skupaj.length()-1; i++) {
            int lowestNumber = skupaj.get(i);
            int lowestNumberInt = i;
            for (int j = i; j < skupaj.length(); j++) {
                if (skupaj.get(j) < lowestNumber){
                    lowestNumber = skupaj.get(j);
                    lowestNumberInt = j;
                }
            }
            int zacasno = skupaj.get(lowestNumberInt);
            skupaj.update(lowestNumberInt, skupaj.get(i));
            skupaj.update(i, zacasno);
        }

        for (int i = 0; i < skupaj.length(); i++) {
            System.out.print(skupaj.get(i)+" ");
        }

        System.out.println();

        return skupaj;

    }

    @SuppressWarnings({"unchecked", "deprecated"})
    private static ResizableArray mergesortmin(ResizableArray<Integer> neki){
        ResizableArray<Integer> prvaPolovica =  new Array<>();
        ResizableArray<Integer> drugaPolovica =  new Array<>();
        for (int i = 0; i < neki.length(); i++) {
            if ((neki.length()+1)/2 -1 >= i){
                prvaPolovica.push(neki.get(i));
            }
            else {
                if ((neki.length()+1)/2 -1 == i-1){
                    System.out.print("| ");
                }
                drugaPolovica.push(neki.get(i));
            }
            System.out.print(neki.get(i) + " ");
        }
        System.out.println();


        ResizableArray<Integer> pprvaPolovica =prvaPolovica;
        ResizableArray<Integer> ddrugaPolovica =drugaPolovica;
        if (prvaPolovica.length() > 1){
            pprvaPolovica = mergesortmin(prvaPolovica);
        }
        if (drugaPolovica.length() > 1){
            ddrugaPolovica = mergesortmin(drugaPolovica);
        }
        ResizableArray<Integer> skupaj =  new Array<>();

        for (int i = 0; i < pprvaPolovica.length(); i++) {
            skupaj.push(pprvaPolovica.get(i));
        }
        for (int i = 0; i < ddrugaPolovica.length(); i++) {
            skupaj.push(ddrugaPolovica.get(i));
        }

        for (int i = 0; i < skupaj.length()-1; i++) {
            int lowestNumber = skupaj.get(i);
            int lowestNumberInt = i;
            for (int j = i; j < skupaj.length(); j++) {
                if (skupaj.get(j) > lowestNumber){
                    lowestNumber = skupaj.get(j);
                    lowestNumberInt = j;
                }
            }
            int zacasno = skupaj.get(lowestNumberInt);
            skupaj.update(lowestNumberInt, skupaj.get(i));
            skupaj.update(i, zacasno);
        }

        for (int i = 0; i < skupaj.length(); i++) {
            System.out.print(skupaj.get(i)+" ");
        }

        System.out.println();

        return skupaj;

    }

    private static void quick(Boolean type, Boolean path){
        quicksortmax(numberArray);
    }

    private static ResizableArray quicksortmax(ResizableArray<Integer> neki) {
        ResizableArray<Integer> manjsaPolovica = new Array<>();
        ResizableArray<Integer> vecjaPolovica = new Array<>();
        int pivot = neki.get(0);
        int manjsi;
        int vecji;
        do {
            manjsi = 1;
            vecji = 1;
            for (int i = 1; i < neki.length(); i++) {
                if (neki.get(i) > pivot) {
                    vecji = i;
                    break;
                }
            }
            for (int i = neki.length() - 1; i > 0; i--) {
                if (neki.get(i) <= pivot) {
                    manjsi = i;
                    break;
                }
            }

            int zacasno = neki.get(manjsi);
            neki.update(manjsi, neki.get(vecji));
            neki.update(vecji, zacasno);
        } while (manjsi > vecji);

        for (int i = neki.length() - 1; i > 0; i--) {
            if (neki.get(i) <= pivot) {
                manjsi = i;
                break;
            }
            else {
                manjsi = 0;
            }
        }

        int zacasno = neki.get(manjsi);
        neki.update(manjsi, neki.get(0));
        neki.update(0, zacasno);

        for (int i = 0; i < neki.length(); i++) {
            if (neki.get(i)<=pivot){
            }
            else {
                vecjaPolovica.push(neki.get(i));
            }
        }

        for (int i = 0; i < neki.length()-vecjaPolovica.length()-1; i++) {
            manjsaPolovica.push(neki.get(i));
        }
        ResizableArray<Integer> skupaj = new Array<>();


        for (int i = 0; i < manjsaPolovica.length(); i++) {
            System.out.print(manjsaPolovica.get(i) + " ");
            skupaj.push(manjsaPolovica.get(i));
        }
        System.out.print("| " + pivot + " | ");

        skupaj.push(pivot);

        for (int i = 0; i < vecjaPolovica.length(); i++) {
            System.out.print(vecjaPolovica.get(i) + " ");
            skupaj.push(vecjaPolovica.get(i));
        }
        System.out.println();
        if (neki.length()>2) {
            if (manjsaPolovica.length() > vecjaPolovica.length()) {
                quicksortmax(manjsaPolovica);
                quicksortmax(vecjaPolovica);
            } else {
                quicksortmax(vecjaPolovica);
                quicksortmax(manjsaPolovica);
            }
        }

        return skupaj;
    }



    private static void swap(int x, int y){
        int zacasno = numberArray.get(y);
        numberArray.update(y, numberArray.get(x));
        numberArray.update(x, zacasno);
    }

    private static void trace(int x){
        for (int i = 0; i < numberArray.length(); i++) {
            System.out.print(numberArray.get(i)+ " ");
            if (i == x){
                System.out.print("| ");
            }
        }
        System.out.println();
    }

}

class Array<T> implements ResizableArray<T>{

    private T[] array1;

    @SuppressWarnings({"unchecked", "deprecated"})
    public Array(){
        array1 = (T[])(new Object[0]);
    }

    @Override
    public T get(int i) {
        return array1[i];
    }

    @SuppressWarnings({"unchecked", "deprecated"})
    @Override
    public void resize() {
        int new_size = array1.length+1;
        T[] copy = array1;
        array1 = (T[])(new Object[new_size]);
        for (int i = 0; i < copy.length; i++) {
            array1[i] = copy[i];
        }
    }

    @Override
    public int length() {
        return array1.length;
    }

    @Override
    public void update(int i, T new_value) {
        array1[i] = new_value;
    }

    @Override
    public void push(T value) {
        resize();
        array1[array1.length-1] = value;
    }

}
interface ResizableArray<T> {
    T get(int i);
    void resize();
    int length();
    void update(int i, T new_value);
    void push(T value);
}