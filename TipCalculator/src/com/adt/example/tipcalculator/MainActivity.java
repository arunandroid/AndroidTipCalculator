package com.adt.example.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText etAmount;
	private TextView tvTipLabel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etAmount =(EditText) findViewById(R.id.etAmount);
		tvTipLabel = (TextView) findViewById(R.id.tvTipLabel);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void tip10Percent(View v){
		this.generateTip(0.1);
	}
	
	public void tip15Percent(View v){
		this.generateTip(0.15);
	}

	public void tip20Percent(View v){
		this.generateTip(0.2);
	}

	private void generateTip(Double percent){
		String amountStr = etAmount.getText().toString();
		Double amount = Double.valueOf(amountStr);
		Double tipAmount =  amount * percent;
		Double formattedTipAmount = this.roundTwoDecimals(tipAmount);
		String displayStr = "Tip is : " + formattedTipAmount.toString();
		tvTipLabel.setText(displayStr);
	}
	
	private Double roundTwoDecimals(Double d) {
	    DecimalFormat twoDForm = new DecimalFormat("#.00");
	    return Double.valueOf(twoDForm.format(d));
	}
}
