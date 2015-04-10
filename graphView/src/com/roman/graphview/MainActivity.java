package com.roman.graphview;

import java.util.Calendar;
import java.util.Date;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Calendar calendar = Calendar.getInstance();
		
		Date d1 = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Date d2 = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Date d3 = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Date d4 = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Date d5 = calendar.getTime();
		
		GraphView graph = (GraphView) findViewById(R.id.graph);
		graph.setTitle("your recent bet's");
		graph.setTitleTextSize((float)20.0);
		graph.setTitleColor(Color.BLUE);
		
		graph.getLegendRenderer().setVisible(true);
		graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
		graph.getGridLabelRenderer().setVerticalLabelsVisible(true);
		int curVal = 1385;
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
				new DataPoint (0, 1305), 
				new DataPoint (1, 1358), 
				new DataPoint (2, 1414),
				new DataPoint (3, 1314),
				new DataPoint (4, 1394),
				new DataPoint (5, 1310),
				new DataPoint (6, 1190),
				new DataPoint (7, 1090),
				new DataPoint (8, 970)
		});
		
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
				new DataPoint (9, curVal)
		});
		threschold.setColor(Color.RED);
		
		series.setTitle("current");
		threschold.setThickness((int)2);
		threschold.setColor(Color.RED);
		threschold.setTitle("original balance");
		graph.addSeries(series);
		graph.addSeries(threschold);
//		graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
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
