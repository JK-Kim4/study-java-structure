package heap;

import java.util.Comparator;

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
     * */
}
