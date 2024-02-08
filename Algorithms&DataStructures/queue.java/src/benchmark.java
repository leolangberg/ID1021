public class benchmark {
    
    public static void main(String[] agrs)
    {
       QueueArray A = new QueueArray();

       A.enqueue(1);
       A.printarray();

       A.dequeue();

       A.printarray();

       A.enqueue(2);
       A.printarray();
       A.enqueue(3);
       A.printarray();
       A.enqueue(4);
       A.printarray();
       A.enqueue(5);
       A.printarray();
       
       A.dequeue();
       A.printarray();
       A.dequeue();
       A.printarray();
       A.dequeue();
       A.printarray();
       A.dequeue();
       A.printarray();

      
       
      

       

    }
}
