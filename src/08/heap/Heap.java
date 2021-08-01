package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * 배열을 기반으로 구현한 Heap
 * 참고 - Stranger's LAB
 * */
public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPATIRY = 10; // 최소(기본) 크기

    private int size; // 요소 개수
    private Object[] array; //요소를 담을 배열

    public Heap(){
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPATIRY];
        this.size = 0;
        this.comparator = comparator;
    }

    //생성자 Type 2 (초기 공간 할당 0)
    public Heap(int capacity){
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator){
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    //받은 인덱스의 부모 노드 인덱스를 반환
    private int getParent(int index){
        return index / 2;
    }

    //받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
    private int getLeftChild(int index){
        return index * 2;
    }

    //받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
    private int getRightChild(int index){
        return index * 2 + 1;
    }


    /**
     * 자료 용적 변경을 위한 함수
     * */
    private void resize(int newCapacity){

        //입력받은 변수 크기만큼의 배열을 새로 생성
        Object[] newArray = new Object[newCapacity];

        //기존에 생성되어있던 배열을 새로생성된 배열로 복사
        for(int i = 1; i <= size; i++){
            newArray[i] = array[i];
        }

        //기존 생성되어있던 배열에 새 배열을 연결
        this.array = null;
        this.array = newArray;
    }

    /**
     * add 메소드
     * Heap에 데이터를 추가하는 메소드
     * Comparator를 사용하여 데이터를 정렬
     * 상향 선별 : 최소 힙을 구현하기 때문에 새로 추가된 데이터는 부모 노드를 찾아 새로 삽입된 노드와 요소 비교 수행
     *
     * */
    public void add(E value){

        //배열의 용적이 곽 차있을 경우
        if(size + 1 == array.length){ //힙은 인덱스 1번부터 값을 할당
            resize(array.length * 2); //배열의 용적을 2배로 늘려 resize해줌.
        }

        siftUp(size + 1, value); // 가장 마지막에 추가되는 위치와 넣을 값(타깃)을 넘겨줌
        size++; //배치가 정상적으로 완료되었을 때 사이즈를 늘려줌
    }

    /*상향 선별*/
    public void siftUp(int idx, E target){
        //comparator가 존재할 경우 comparator를 인자로 넘겨줌 --> TODO comparator
        if(comparator != null){
            siftUpComparator(idx, target, comparator);
        }else{
            siftUpComparable(idx, target);
        }
    }

    //Comparator를 이용한 sift-up
    private void siftUpComparator(int idx, E target, Comparator<? super E> comparator) {

        //root노드보다 클 때까지만 탐색
        while (idx > 1){
            int parent = getParent(idx);
            Object parentValue = array[parent]; //삽입 노드의 부모 노드

            //타깃 노드가 부모노드보다 크면 반복문 종료
            if(comparator.compare(target, (E)parentValue) >= 0){ //'최대 힙' 구현 시 비교 연산자를 <=로 변경
                break;
            }

            /*보모노드가 타깃노드보다 큰 경우
            * 현재 삽입될 위치에 부모노드값을 교체해 주고
            * 타깃노드의 위치를 부모노드로 변경
            * */
            array[idx] = parentValue;
            idx = parent;
        }
        //최종적으로 삽입 될 위치에 타깃노드 값을 저장
        array[idx] = target;
    }

    //Comparable을 이용한 sift-up
    private void siftUpComparable(int idx, E target) {

        //타깃 노드가 비교될 수 있도록 변수 생성
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0){ //'최대 힙' 구현 시 비교 연산자를 <=로 변경
                break;
            }
            array[idx] = parentVal;
            idx = parent;

        }

        array[idx] = comp;

    }

    /**
     * remove
     * root노드를 삭제하고, 마지막 노드에 있는 값을 root노드로 가져와 배열비교, 재배치 진행
     * */
    public E remove(){

        if(array[1] == null){ //root 노드가 비어있는 경우
            throw new NoSuchElementException();
        }

        E result = (E) array[1]; // 삭제될 루트 노드
        E target = (E) array[size]; // 루트 노드로 재배치될 타겟
        array[size] = null;

        siftDown(1, target);

        return result;
    }

    private void siftDown(int idx, E target) {
        //comparator가 존재할 경우
        if(comparator != null){
            siftDownComparator(idx, target, comparator);
        }else{
            siftDownComparable(idx, target);
        }

    }


    private void siftDownComparator(int idx, E target, Comparator<? super E> comparator) {

        array[idx] = null; //삭제할 인덱스 노드를 삭제
        size--;

        int parent = idx;
        int child;

        //왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while ((child = getLeftChild(parent)) <= size){


            int right = getRightChild(parent); //오른쪽 자식 인덱스

            Object childVal = array[child]; //왼쪽 자식이 값 (교환될 값)


            /*
            * 오른쪽 자식 인덱스가 size를 넘지 않으면서
            * 왼쪽 자식이 오른쪽 자식보다 큰 경우
            * 재배치 할 노드는 작은 자식과 비교해야 하므로 child와 childVal을
            * 오른쪽 자식으로 바궈준다
            * */
            if(right <= size && comparator.compare((E) childVal, (E)array[right]) > 0 ){
                child = right;
                childVal = array[child];
            }

            //재배치할 노드가 자식 노드보다 작을 경우 반복문 종료
            if(comparator.compare(target, (E) childVal) <= 0){
                break;
            }

            array[parent] = childVal;
            parent = child;
        }

        array[parent] = target;

        if(array.length > DEFAULT_CAPATIRY && size < array.length / 4){
            resize(Math.max(DEFAULT_CAPATIRY, array.length / 2));
        }

    }


    private void siftDownComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while ((child = getLeftChild(parent)) <= size){

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0){
                child = right;
                childVal = array[child];
            }

            if(comp.compareTo((E)childVal) <= 0){
                break;
            }

            array[parent] = childVal;
            parent = child;
        }

        array[parent] = comp;

        if(array.length > DEFAULT_CAPATIRY && size < array.length / 4){
            resize(Math.max(DEFAULT_CAPATIRY, array.length / 2));
        }
    }

    public int size(){
        return this.size;
    }

    public E peek(){
        if(array[1] == null){
            throw new NoSuchElementException();
        }

        return (E)array[1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size +1);
    }

}
