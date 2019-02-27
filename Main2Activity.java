package shubham.system.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle intime=getIntent().getExtras();

        String inTime=intime.getString("inTime");
        TextView displayInTime = (TextView) findViewById(R.id.valueText);
        displayInTime.setText(inTime);
    }
}
