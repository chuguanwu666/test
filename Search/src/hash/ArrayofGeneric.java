package hash;

class Generic<T> {
}

public class ArrayofGeneric {

    public static void main(String[] args) {

        Generic<Integer>[] genArr;

        genArr = (Generic<Integer>[]) new Generic[2];

        System.out.println(genArr);

    }

}  