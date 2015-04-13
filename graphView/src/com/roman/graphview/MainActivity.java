package com.roman.graphview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.text.Editable;
import android.text.TextUtils;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends Activity {
	
	Bets bets = new Bets();
	LineGraphSeries<DataPoint> series;
	LineGraphSeries<DataPoint> threschold;
	GraphView graph;
	
	Button addDataPointButton;
	EditText stakeResult;
	RadioGroup radioGroup;
	RadioButton wonRadioButton;
	RadioButton loseRadioButton;
	CheckBox showLegend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		graph = (GraphView) findViewById(R.id.graph);
		graph.setTitle("your recent bet's");
		graph.setTitleTextSize((float)20.0);
		graph.setTitleColor(Color.BLUE);
		
		graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
		graph.getGridLabelRenderer().setVerticalLabelsVisible(true);
		
		series = new LineGraphSeries<DataPoint>(bets.getDataPoints());
		
		series.setDrawDataPoints(true);
		series.setDataPointsRadius((float)5.0);
		series.setTitle("current");
		
		threschold = new LineGraphSeries<DataPoint>(bets.getThreschold());
		threschold.setColor(Color.RED);
		threschold.setThickness((int)2);
		threschold.setColor(Color.RED);
		threschold.setTitle("original balance");
		graph.addSeries(series);
		graph.addSeries(threschold);
		
		addDataPointButton = (Button) findViewById(R.id.addPointButton);
		addDataPointButton.setOnClickListener(addDataPointButtonListener);
		
		stakeResult = (EditText) findViewById(R.id.stackeResultEditText);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		loseRadioButton = (RadioButton) findViewById(R.id.loseRadioButton);
		wonRadioButton = (RadioButton) findViewById(R.id.wonRadioButton);
		
		showLegend = (CheckBox) findViewById(R.id.showLegendCheckBox);
		showLegend.setOnCheckedChangeListener(showLegendCheckListener);
	}
	
	private OnClickListener addDataPointButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (isValid(stakeResult.getText())){
				
				int stake = Integer.parseInt(stakeResult.getText().toString());
				if (loseRadioButton.isChecked()) {
					stake = stake*(-1);
				}
				bets.addPoint(stake);
				series.resetData(bets.getDataPoints());
				threschold.resetData(bets.getThreschold());
				stakeResult.setText("");
			}
			else {
				showStakeEditTextAlert();
			}
		}
		
	};
	
	private OnCheckedChangeListener showLegendCheckListener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			if (showLegend.isChecked()){
				graph.getLegendRenderer().setVisible(true);
			}
			else {
				graph.getLegendRenderer().setVisible(false);
				graph.refreshDrawableState();
			}
		}
	};
	
	private boolean isValid (Editable str) {
		return (TextUtils.isDigitsOnly(str.toString()) && !TextUtils.isEmpty(str.toString()));
	}
	
	public void showStakeEditTextAlert () {
		try {
			AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
			
			alertDialog.setTitle("Wrong stake format.");
			alertDialog.setMessage("Input for stake is incorrect. \nPlease, use only numeric symbols.");
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
