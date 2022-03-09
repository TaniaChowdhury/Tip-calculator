package edu.qc.seclass.tipcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText checkAmountValue;
    EditText partySizeValue;
    Button buttonCompute;
    EditText fifteenPercentTipValue;
    EditText twentyPercentTipValue;
    EditText twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue;
    EditText twentyPercentTotalValue;
    EditText twentyfivePercentTotalValue;
    Double check;
    int people;
    Double perPerson;
    Integer fifteenPercentTip;
    Integer twentyPercentTip;
    Integer twentyfivePercentTip;
    Integer fifteenPercentTotal;
    Integer twentyPercentTotal;
    Integer twentyfivePercentTotal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAmountValue = (EditText)findViewById(R.id.checkAmountValue);
        partySizeValue= (EditText)findViewById(R.id.partySizeValue);
        buttonCompute=(Button)findViewById(R.id.buttonCompute);
        fifteenPercentTipValue=(EditText)findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue=(EditText)findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue=(EditText)findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue=(EditText)findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue=(EditText)findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue=(EditText)findViewById(R.id.twentyfivePercentTotalValue);
        checkAmountValue.setOnClickListener(this);
        partySizeValue.setOnClickListener(this);
        buttonCompute.setOnClickListener(this);
        fifteenPercentTipValue.setOnClickListener(this);
        twentyPercentTipValue.setOnClickListener(this);
        twentyfivePercentTipValue.setOnClickListener(this);
        fifteenPercentTotalValue.setOnClickListener(this);
        twentyPercentTotalValue.setOnClickListener(this);
        twentyfivePercentTotalValue.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        check=Double.parseDouble(checkAmountValue.getText().toString());
        if (check <= 0) {
            Toast.makeText (getApplicationContext(), "Check can't be negative", Toast.LENGTH_SHORT).show();
            return;
        }
        people= Integer.parseInt(partySizeValue.getText().toString());
        perPerson= check/people;
        /*if (people <= 0  ) {
            Toast.makeText(getApplicationContext(), "Party size cant be negative", Toast.LENGTH_SHORT).show();
            return;
        }*/ 
        fifteenPercentTip = (int) Math.round( ((perPerson * (15))/100));
        twentyPercentTip = (int) Math.round( ((perPerson * (20))/100));
        twentyfivePercentTip = (int) Math.round( ((perPerson * (25))/100));
        fifteenPercentTotal = (int)Math.round( perPerson+fifteenPercentTip);
        twentyPercentTotal = (int) Math.round( perPerson+twentyPercentTip);
        twentyfivePercentTotal = (int)Math.round( perPerson+twentyfivePercentTip);

        if(v.getId()==buttonCompute.getId()){
            fifteenPercentTipValue.setText(fifteenPercentTip.toString());
            twentyPercentTipValue.setText(twentyPercentTip.toString());
            twentyfivePercentTipValue.setText(twentyfivePercentTip.toString());
            fifteenPercentTotalValue.setText(fifteenPercentTotal.toString());
            twentyPercentTotalValue.setText(twentyPercentTotal.toString());
            twentyfivePercentTotalValue.setText(twentyfivePercentTotal.toString());

        }
    }
}