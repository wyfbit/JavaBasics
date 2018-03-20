package CannotSolve;

public class EvenChecker implements Runnable{
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g , int ident) {
         generator = g;
         id = ident;
    }
    public void run() {
         while( !generator.isCanceled() ) {
              int val = generator.next();
              if(val % 2 != 0) {
                   System.out.println(val + "not even!");
                   generator.cancle();
              }
         }
    }
}
