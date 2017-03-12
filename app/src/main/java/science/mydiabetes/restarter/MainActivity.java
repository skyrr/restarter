package science.mydiabetes.restarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Result result;
    public static MainActivity mainActivity;

    public void setResult(Result result) {
        this.result = result;
    }

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        setResult(new Result() {
            @Override
            public void setResult(int i) {
                Log.d("MyResult", " set item " + i);
            }
        });
    }

    public void showI(View view) {
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(RestartService.i);
    }
    public void onClickStart(View view) {
        startService(new Intent(this, RestartService.class));
    }

    public void onClickStop(View view) {
        stopService(new Intent(this, RestartService.class));
    }
}
