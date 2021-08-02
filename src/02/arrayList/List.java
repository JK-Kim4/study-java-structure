package arrayList;

/*
* 자바 collection중 List 구조는 묶음 데이터를 가져올 때 많이 사용하곤 한다.
* */
public interface List<E> {


    /*리스트에 요소를 추가한다.*/
    boolean add(E value);

    /*리스트에 특정 위치에 요소를 추가한다.*/
    void add(int index, E value);



    /*리스트에 특정 요소를 삭제한다.*/
    boolean remove(Object value);
    E remove(int index);

    E get(int index);

    /*리스트에 특정 위치에 있는 요소를 새 요소로 대체한다.*/
    void set(int index, E value);

    /*특정 요소가 몇번째에 위치해 있는지 반환한다.*/
    int indexOf(Object value);

    int size();

    boolean isEmpty();

    public void clear();


}
