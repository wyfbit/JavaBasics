package CannotSolve;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* 
 * 这是一个任务类：当发现有奇数产生时，将数据生成器的状态设置为【取消】 
 * test()方法：启动启动大量【使用相同IntGenerator】的任务 
 */ 
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
              }
         }
    }
 
    public static  void test(IntGenerator gp, int count){  
        ExecutorService exec = Executors.newCachedThreadPool();  
        for(int i = 0; i < count; i++){  
            exec.execute(new EvenChecker(gp, i));  
        }  
        exec.shutdown();  
    }  
    public static  void test(IntGenerator gp){  
        test(gp, 10);  
    }  
}
