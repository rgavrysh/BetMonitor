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
		
		LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
				new DataPoint (d1, 1), 
				new DataPoint (d2, 5), 
				new DataPoint (d3, -3),
				new DataPoint (d4, 6),
				new DataPoint (d5, 2)
		});
		
		series.setDrawDataPoints(true);
		series.setDataPointsRadius((float)5.0);
		LineGraphSeries<DataPoint> threschold = new LineGraphSeries<DataPoint>(new DataPoint[] {
				new DataPoint (d1, 3),
				new DataPoint (d2, 3),
				new DataPoint (d3, 3),
				new DataPoint (d4, 3),
				new DataPoint (d5, 3)
		});
		threschold.setColor(Color.RED);
		
		series.setTitle("current");
		threschold.setThickness((int)2);
		threschold.setColor(Color.RED);
		threschold.setTitle("threschold");
		graph.addSeries(series);
		graph.addSeries(threschold);
		graph.getLegendRenderer().setVisible(true);
		
		graph.getGridLabelRenderer().setHorizontalLabelsVisible(true);
		graph.getGridLabelRenderer().setNumHorizontalLabels(5);
		graph.getGridLabelRenderer().setVerticalLabelsVisible(true);
		graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
		graph.setTitle("your recent bet's");
		graph.setTitleTextSize((float)20.0);
		graph.setTitleColor(Color.BLUE);
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
