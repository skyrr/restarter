package science.mydiabetes.restarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by sky on 07.03.2017.
 */

public class BootBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent i = new Intent();
            i.setAction(".RestartService");
            context.startService(i);
        }
    }}
