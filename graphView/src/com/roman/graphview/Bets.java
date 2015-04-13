package com.roman.graphview;

import java.util.ArrayList;
import java.util.List;

import com.jjoe64.graphview.series.DataPoint;

public class Bets {
	
	private DataPoint[] datapoints;
	private DataPoint[] threschold;
	private List <DataPoint> dataPointList = new ArrayList<DataPoint>();
	
	public Bets() {
		initializeDataPoints();
		
	}
	
	private void initializeDataPoints() {
		dataPointList.add(new DataPoint(0, 1305));
		dataPointList.add(new DataPoint(1, 1358));
		dataPointList.add(new DataPoint(2, 1414));
		dataPointList.add(new DataPoint(3, 1314));
		dataPointList.add(new DataPoint(4, 1394));
		dataPointList.add(new DataPoint(5, 1310));
		dataPointList.add(new DataPoint(6, 1190));
		dataPointList.add(new DataPoint(7, 1090));
		dataPointList.add(new DataPoint(8, 970));
		dataPointList.add(new DataPoint(9, 842));
		dataPointList.add(new DataPoint(10, 792));
	}
	
	public DataPoint[] getDataPoints() {
		datapoints = new DataPoint[dataPointList.size()];
		for (int i = 0; i < dataPointList.size(); i++){
			datapoints[i] = dataPointList.get(i);
		}
		return datapoints;
	}
	
	public void addPoint(int stake) {
		DataPoint lastDataPoint;
		lastDataPoint = dataPointList.get(dataPointList.size()-1);
		dataPointList.add(new DataPoint((lastDataPoint.getX() + 1), lastDataPoint.getY() + stake));
	}
	
	public DataPoint[] getThreschold() {
		double balance = dataPointList.get(0).getY();
		threschold = new DataPoint[dataPointList.size()];
		for (int i = 0; i < dataPointList.size(); i++){
			threschold[i] = new DataPoint(i, balance);
		}
		return threschold;
	}

}
