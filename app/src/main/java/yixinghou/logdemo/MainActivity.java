package yixinghou.logdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    TimeCounter timeCounterActivity;
    private static final Logger logger = LoggerFactory.getLogger(MainActivity.class);
    //private final org.apache.log4j.Logger log2 = org.apache.log4j.Logger.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeCounterActivity = new TimeCounter("MainActivity");
        timeCounterActivity.begin();

        TextView txt = (TextView) findViewById(R.id.txt);
        float f = doDemo();
        txt.setText("时长:" + f);


    }

    @Override
    protected void onStart() {
        //LogConfigurator logConfigurator = new LogConfigurator();
        timeCounterActivity.end();
        timeCounterActivity.print();
        super.onStart();
    }

    private float doDemo() {
        TimeCounter timeCounter = new TimeCounter("doDemo");
        timeCounter.begin();

        for (int i = 0; i < 10; i++) {
            //LogUtil.debug(TAG, "debug 输出");

            logger.debug("debug Some log message. Details: {}", "debug 输出");
            logger.info("info Some log message. Details: {}", "debug 输出");
            logger.error("error Some log message. Details: {}", "debug 输出");

//            LogUtil.debug(TAG, "debug Some log message. Details: {}");
//            LogUtil.info(TAG, "info Some log message. Details: {}");
//            LogUtil.error(TAG, "error Some log message. Details: {}");

            //log2.debug("xxxxxxxxx");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        timeCounter.end();
        timeCounter.print();
        return timeCounter.getHowLong();
    }


}
