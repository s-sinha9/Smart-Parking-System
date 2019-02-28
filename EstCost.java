package shubham.system.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.time.OffsetTime;

public class EstCost extends AppCompatActivity implements OnClickListener {
    Button b;
    TextView input1;
    TextView input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = (Button) findViewById(R.id.button_id);
        OffsetTime offset = OffsetTime.now();
        int cur_hr = offset.getHour();
        int cur_m = offset.getMinute();
        b.setOnClickListener(this);
        input1 = (TextView) findViewById(R.id.mytextview1);
        input2 = (TextView) findViewById(R.id.mytextview2);
        int cost;
        int fin_time;
        int fin_hr,fin_min,in_hr,in_min;

        Bundle intime=getIntent().getExtras();

        String inTime=intime.getString("inTime");

        String[] words =inTime.split("\\s+");

        in_hr=Integer.parseInt(words[0]);
        in_min=Integer.parseInt(words[1]);

         fin_hr=cur_hr-in_hr;
        if(fin_hr<0)
         fin_hr+=24;
        fin_min=cur_m-in_min;
        if(fin_min<0)
         fin_min+=60;
        input1.setText(fin_hr+" Hrs "+fin_min+" Mins");
         if(fin_min>0)
           fin_hr++;
        fin_time=fin_hr;
         cost=fin_time*50;
        input2.setText("Rs. "+cost);
    }


    public void onClick (View b)
    {
        Intent i = new Intent(getApplicationContext(), ScanOutActivity.class);
        startActivity(i);
        setContentView(R.layout.activity_scan_out);
    }

}
