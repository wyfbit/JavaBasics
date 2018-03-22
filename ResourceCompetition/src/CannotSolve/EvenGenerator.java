package CannotSolve;
//多个线程访问<span style="font-family:Arial, Helvetica, sans-serif;">Generator的 域 可能会使其处于不恰当的状态</span>  
//在java中递增不是原子性操作，如果不保护任务，即使单一的递增也是不安全的  
public class EvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;         
    @Override  
    public int next() {           
        ++currentEvenValue;         
        Thread.yield();  
        ++currentEvenValue;  
        //currentEvenValue += 2;  
        return currentEvenValue;  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenGenerator eg = new EvenGenerator();  
        EvenChecker.test(eg);  
	}

}
