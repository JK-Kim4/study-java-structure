## Queue ( 큐 )

1. 원소의 삽입과 삭제
  - Add_q : 큐에 원소를 삽입
  ```
  Queue Add_q(queue, item)
  {
  if(isFull_q(queue))
    then {'queue is Full'을 출력한다.}
    else {큐의 rear에 item을 삽입하고, 큐를 반환한다.}
  }
  //Add_q 메소드가 return하는 객체는 Queue객체이다. 해당 메소드에서는 인자로 전달된 Queue에 item을 삽입 하는 역할을 한다.
  
  Element Delete_q(queue)
  {
  if(IsEmply_q(queue))
    then {'queue is Empty'를 출력한다.}
    else {큐의 front에 있는 원소를 삭제 하고 해당 원소를 반환한다.}
  }
  //Delete_q 메소드가 return하는 객체는 해당 큐에 저장되어있는 원소 객체이다. 해당 메소드는 인자로 전달된 Queue의 front 원소를 반환하는 역할을 한다.
  ```
