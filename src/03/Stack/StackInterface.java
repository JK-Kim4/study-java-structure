package Stack;

public interface StackInterface<E> {


    /*push -> Stack에 top부분에 요소를 추가*/
    E push(E item);

    /*Stack에 top부분에 요소를 제거, 제거된 요소 반환
    * @return E (제거된 요소)*/
    E pop();

    /*Stack에 top 요소를 제거하지 않고 반환*/
    E peek();


    /*특정 요소가 Stack에 몇 번째 위치해 있는지를 반환*/
    int search(Object value);

    /*Stack의 크기를 반환*/
    int size();

    /*스택의 모든 요소를 삭제*/
    void clear();

    /*스택에 요소가 비어있는지 여부 확인*/
    boolean empty();

}
