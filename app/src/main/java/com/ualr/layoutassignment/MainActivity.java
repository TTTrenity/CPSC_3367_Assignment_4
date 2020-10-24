package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label
    TextView calculated_total_tv;
    EditText product1_et;
    EditText product2_et;
    EditText product3_et;
    EditText product4_et;
    MaterialCheckBox product1_cb;
    MaterialCheckBox product2_cb;
    MaterialCheckBox product3_cb;
    MaterialCheckBox product4_cb;
    MaterialButton discount_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculated_total_tv = (TextView) findViewById(R.id.calculated_total_tv);
        product1_et = (EditText) findViewById(R.id.p1_et);
        product2_et = (EditText) findViewById(R.id.p2_et);
        product3_et = (EditText) findViewById(R.id.p3_et);
        product4_et = (EditText) findViewById(R.id.p4_et);
        product1_cb = (MaterialCheckBox) findViewById(R.id.p1_cb);
        product2_cb = (MaterialCheckBox) findViewById(R.id.p2_cb);
        product3_cb = (MaterialCheckBox) findViewById(R.id.p3_cb);
        product4_cb = (MaterialCheckBox) findViewById(R.id.p4_cb);
        discount_btn = (MaterialButton) findViewById(R.id.discount_btn);
        calculated_total_tv.setText("$00.00");
    }

    public void calculateTotal(View view) {
        double total = 0.00;
        //this could be cleaned up and put in a loop, but I did it like this to save time
        if(product1_cb.isChecked()) {
            total += Double.parseDouble(product1_et.getText().toString());
        }
        if(product2_cb.isChecked()) {
            total += Double.parseDouble(product2_et.getText().toString());
        }
        if(product3_cb.isChecked()) {
            total += Double.parseDouble(product3_et.getText().toString());
        }
        if(product4_cb.isChecked()) {
            total += Double.parseDouble(product4_et.getText().toString());
        }

        if(discount_btn.isChecked()) {
            //applies a 25% discount if the discount button is checked
            total = total - total*.25;

        }

        calculated_total_tv.setText("$" + Double.toString(total));
    }
}