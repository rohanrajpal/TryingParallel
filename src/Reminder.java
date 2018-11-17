import java.util.*;
public class Reminder {
    Timer timer;
    int countdown;
    public Reminder(int seconds) {
        timer = new Timer();
        countdown = seconds;
        timer.schedule(new RemindTask(), seconds*1000);
    }
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            System.out.println(countdown);
            countdown--;
// Terminate the timer thread
// or set the timer as daemon
            timer.cancel();
        }
    }
    public static void main(String args[]) {
        new Reminder(5);
        System.out.println("Task scheduled.");
    }
}