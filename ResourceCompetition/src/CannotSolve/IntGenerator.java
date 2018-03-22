package CannotSolve;
/* 
 * 这是一个整数生成器 
 * canceled 表示这个对象是否已被取消 
 * */
public abstract class IntGenerator {
	private volatile boolean canceled = false;  
    public abstract int next();  
    public void cancel(){  
        canceled = true;  
    }  
    
    public boolean isCanceled(){  
        return canceled;  
    }  
}
