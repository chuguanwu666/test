package hash;

public class ArrayOfGeneric2<T>{
    public T[] ts;
    public ArrayOfGeneric2(int size) {
        ts = (T[]) new Object[size];
    }

    public T get(int index) {
        return ts[index];
    }

    public T[] rep() {
        return ts;

    }

    public void set(int index, T t) {
        ts[index] = t;
    }

    public static void main(String[] args) {
        ArrayOfGeneric2<String> aog2 = new ArrayOfGeneric2<String>(10);
        System.out.println(aog2.ts.toString());

    }
}
