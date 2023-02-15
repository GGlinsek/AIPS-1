package Izziv1;

class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;

    private T[] a;
    private int front, back, size;
    public ArrayDeque(){
        a = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = 0;
        back = 0;
        size = 0;
    }
    private int next(int i){
        return (i+1)%DEFAULT_CAPACITY;
    }
    private int prev (int i) {
        return (DEFAULT_CAPACITY + i - 1) % DEFAULT_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return (size()== 0);
    }

    @Override
    public boolean isFull() {
        return (size() == DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T top() throws CollectionException {
        return back();
    }

    @Override
    public void push(T x) throws CollectionException {
        enqueue(x);
    }

    @Override
    public T pop() throws CollectionException {
        return dequeueBack();
    }

    @Override
    public T front() throws CollectionException {
        if (isEmpty()) throw new CollectionException((ERR_MSG_EMPTY));
        if (a[front] == null) return a[next(front)];
        return a[front];
    }

    @Override
    public T back() throws CollectionException {
        if (isEmpty()) throw new CollectionException((ERR_MSG_EMPTY));
        return a[prev(back)];
    }

    @Override
    public void enqueue(T x) throws CollectionException {
        if (isFull()) throw new CollectionException(ERR_MSG_FULL);
        a[back] = x;
        back = next(back);
        size++;
    }

    @Override
    public void enqueueFront(T x) throws CollectionException {
        if (isFull()) throw new CollectionException(ERR_MSG_FULL);
        front = prev(front);
        a[front] = x;
        size++;
    }

    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty()) throw new CollectionException(ERR_MSG_EMPTY);
        T o = a[front];
        a[front] = null;
        front = next(front);
        size--;
        return o;
    }

    @Override
    public T dequeueBack() throws CollectionException {
        if (isEmpty()) throw new CollectionException(ERR_MSG_EMPTY);
        back = prev(back);
        T o = a[back];
        a[back] = null;
        size--;
        return  o;
    }

    @Override
    public T get(int i) throws CollectionException {
        if (isEmpty()) throw new CollectionException(ERR_MSG_EMPTY);
        if (i>back) throw new CollectionException(ERR_MSG_INDEX);
        return a[i];
    }

    @Override
    public void add(T x) throws CollectionException {
        enqueue(x);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        if (size>0){
            str.append(a[front].toString());
            if (next(front) > back) {
                for (int i = next(front); i < back + DEFAULT_CAPACITY; i++) {
                    str.append(", ").append(a[i % DEFAULT_CAPACITY].toString());
                }
            }
            else{
                for (int i = next(front); i < back; i++) {
                    str.append(", ").append(a[i].toString());
                }
            }
        }
        str.append("]");
        return str.toString();
    }


}
