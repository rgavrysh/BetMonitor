package com.roman.graphview;

//import java.util.Calendar;
//import java.util.Date;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends Activity {
	
	Button addDataPointButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GraphView graph = (GraphView) findViewById(R.id.graph);
		graph.setTitle("your recent bet's");
		graph.setTitleTextSize((float)20.0);
		graph.setTitleColor(Color.BLUE);
		
		graph.getLegendRenderer().setVisible(true);
		graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
		graph.getGridLabelRenderer().setVerticalLabelsVisible(true);
		int curVal = 1385;
		Bets bets = new Bets();
		
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(bets.getDataPoints());
		
		series.setDrawDataPoints(true);
		series.setDataPointsRadius((float)5.0);
		LineGraphSeries<DataPoint> threschold = new LineGraphSeries<DataPoint>(new DataPoint[] {
				new DataPoint (0, curVal),
				new DataPoint (1, curVal),
				new DataPoint (2, curVal),
				new DataPoint (3, curVal),
				new DataPoint (4, curVal),
				new DataPoint (5, curVal),
				new DataPoint (6, curVal),
				new DataPoint (7, curVal),
				new DataPoint (8, curVal),
				new DataPoint (9, curVal),
				new DataPoint (10, curVal),
				new DataPoint (11, curVal)
		});
		threschold.setColor(Color.RED);
		
		series.setTitle("current");
		threschold.setThickness((int)2);
		threschold.setColor(Color.RED);
		threschold.setTitle("original balance");
		graph.addSeries(series);
		graph.addSeries(threschold);
//		graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
		
//		addDataPointButton.findViewById(R.id.addPointButton);
//		addDataPointButton.setOnClickListener(addDataPointButtonListener);
	}
	
//	private OnClickListener addDataPointButtonListener = new OnClickListener() {
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	};

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
