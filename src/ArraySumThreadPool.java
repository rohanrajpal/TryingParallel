import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArraySumThreadPool implements Runnable{
    int[] array;
    int sum, low, high;

    public ArraySumThreadPool(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
        sum=0;
    }

    //note that run method is of void type
    @Override
    public void run() {
        for (int i=low;i<high;i++){
            sum += array[i];
        }
    }

    public int getResult(){return sum;}

    public static void main(String[] args) throws InterruptedException {
        int size=5;int[] arrayLocal = {1,2,3,4,5};
        ExecutorService exec = Executors.newFixedThreadPool(2);
        ArraySumThreadPool left = new ArraySumThreadPool(arrayLocal,0,size/2);
        ArraySumThreadPool right = new ArraySumThreadPool(arrayLocal,size/2,size);
        exec.execute(left);exec.execute(right);
        if (!exec.isTerminated()){
            exec.shutdown();
            exec.awaitTermination(5, TimeUnit.SECONDS);
        }
        int result = left.getResult() + right.getResult();
        System.out.println(result);
    }
}
