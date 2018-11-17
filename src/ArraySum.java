public class ArraySum implements Runnable {
    int[] array;
    int sum, low, high;

    public ArraySum(int[] array, int low, int high) {
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
        ArraySum left = new ArraySum(arrayLocal,0,size/2);
        ArraySum right = new ArraySum(arrayLocal,size/2,size);
        Thread t1 = new Thread(left);
        Thread t2 = new Thread(right);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        int result = left.getResult() + right.getResult();
        System.out.println(result);
    }
}
