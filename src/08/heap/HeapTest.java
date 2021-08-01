package heap;

import java.util.Random;

public class HeapTest {

    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<>();

        Random r = new Random();

        for(int i = 0; i < 15; i++){
            heap.add(r.nextInt(100));
        }

        System.out.println("HEAP add");
        for(Object val : heap.toArray()){
            System.out.println(val + " ,");
        }

        System.out.println();


        /*오름차순 순으로 romove 되어야 정상*/
        System.out.println("HEAP remove");
        while (!heap.isEmpty()){
            System.out.println(heap.remove() + ", ");
        }
    }


}
