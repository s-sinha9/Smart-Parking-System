package shubham.system.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

//variable to use
//inTime


//implementing onclicklistener
public class MainActivity extends AppCompatActivity {

    //View Objects
    private Button buttonScan;
    private TextView textViewHeader;

    //qr code scanner object
    private IntentIntegrator qrScan;

    public String inTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View objects
        buttonScan = (Button) findViewById(R.id.buttonScan);
        textViewHeader = (TextView) findViewById(R.id.textViewHeader);


        //intializing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });
    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                //textViewHeader.setText("Scan to Exit");
                inTime=result.getContents();
                String str= "In time is "+ inTime;
                Intent intent= new Intent(this, Main2Activity.class);
                intent.putExtra("inTime",inTime);
                startActivity(intent);
                //textViewAddress.setText(str);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



}
