package tipcalculator.seclass.qc.edu.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    public void makeToast(String x){
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        Button buttonCompute = (Button) findViewById(R.id.buttonCompute);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
                EditText partySizeValue = (EditText) findViewById(R.id.partySizeValue);

                EditText fifteenPercentTipValue = (EditText) findViewById(R.id.fifteenPercentTipValue);
                EditText twentyPercentTipValue = (EditText) findViewById(R.id.twentyPercentTipValue);
                EditText twentyfivePercentTipValue = (EditText)findViewById(R.id.twentyfivePercentTipValue);

                EditText fifteenPercentTotalValue = (EditText) findViewById(R.id.fifteenPercentTotalValue);
                EditText twentyPercentTotalValue = (EditText) findViewById(R.id.twentyPercentTotalValue);
                EditText twentyfivePercentTotalValue = (EditText) findViewById(R.id.twentyfivePercentTotalValue);

                if((checkAmountValue.getText().toString().length()> 0)||(partySizeValue.getText().toString().length()> 0)) {
                    double tot = Double.parseDouble(checkAmountValue.getText().toString());
                    int size = Integer.parseInt(partySizeValue.getText().toString());

                    int ave = (int) Math.round(tot / size);

                    int tip15 = (int) Math.round(ave * 0.15);
                    int tip20 = (int) Math.round(ave * 0.2);
                    int tip25 = (int) Math.round(ave * 0.25);

                    int tot15 = (int) Math.round(ave + tip15);
                    int tot20 = (int) Math.round(ave + tip20);
                    int tot25 = (int) Math.round(ave + tip25);


                    fifteenPercentTipValue.setText(tip15 + "");
                    twentyPercentTipValue.setText(tip20 + "");
                    twentyfivePercentTipValue.setText(tip25 + "");

                    fifteenPercentTotalValue.setText(tot15 + "");
                    twentyPercentTotalValue.setText(tot20 + "");
                    twentyfivePercentTotalValue.setText(tot25 + "");
                }else{
                    makeToast("Empty or incorrect values");
                }

            }
        });

    }


}
