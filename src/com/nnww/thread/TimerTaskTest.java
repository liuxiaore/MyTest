import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {



        public static void main(String[] args){
            TimerTaskTest2 timerTaskTest2 = new TimerTaskTest2();
//            timerTaskTest2.schedule(new TimerTaskTest(), 1000, 2000);
        }



}

class TimerTaskTest2 extends TimerTask {

    @Override
    public void run() {
        System.out.println("取数据中...");
    }
}

