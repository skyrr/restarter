package science.mydiabetes.restarter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class RestartService extends Service {
    public static int i;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate() {
        super.onCreate();
//        MainActivity.this.result.setResult(10);
        Log.d("RestartTask", "RestartTask");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("RestartTask", "RestartTask");
        restartTask();
        return super.onStartCommand(intent, flags, startId);
    }

    void restartTask() {
        Log.d("Started restrt tast", "Started restrt tast");
//        try {
//            Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "reboot" });
//            proc.waitFor();
//        } catch (Exception ex) {
//            Log.i("Started restrt tast", "Could not reboot", ex);
//        }
//        for (int i = 1; i<=50; i++) {
//            Log.d("Count started", "i = " + i);
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        new Thread(new Runnable() {
            public void run() {
                for (i = 1; i<=600; i++) {
                    MainActivity.mainActivity.result.setResult(i);
                    Log.d("Count started", "i = " + i);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();
            }
        }).start();
    }
}
