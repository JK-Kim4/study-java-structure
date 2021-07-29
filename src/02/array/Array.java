package array;

//배열의 선언과 사용
public class Array {
    public static void main(String[] args) {

        /*배열은 동일한 자료형의 데이터를 저장하기 때문에 선언 시 저장 될 데이터 타입을 지정한다.*/
        int[] arrInt01; //배열을 선언하는 방법 01
        int arrInt02[]; //배열을 선언하는 방법 02
        /*위 방식은 배열을 '선언'만 했을 뿐 크기를 정하거나 값을 초기화 하지 않은 상태 (저장될 데이터 타입은 int형)*/

        int[] arrInt03 = new int[3]; // 선언과 동시에 크기를 할당하는 방법 ( 4개의 데이터를 저장할 수 있는 공간의 배열 선언 )
        arrInt01 = new int[3]; //미리 선언된 배열에 크기를 할당하는 방법

        int[] arrInt05 = new int[] {1,2,3,4,5};
        int[] arrInt06 = {1,2,3,4,5};
        /*위와 같은 방법으로 배열을 선언과 동시에 데이터를 초기화 할 수 있다*/





    }
}
