package CannotSolve;

public abstract class IntGenerator {
	private volatile boolean canceled = false;  
    public abstract int next();  
    public void cancel(){  
        canceled = true;  
    }  
    //public IntGenerator£¨£©{super.}
    public boolean isCanceled(){  
        return canceled;  
    }  
}
