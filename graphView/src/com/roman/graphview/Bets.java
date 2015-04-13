package com.roman.graphview;

import java.util.ArrayList;
import java.util.List;

import com.jjoe64.graphview.series.DataPoint;

public class Bets {
	
	private DataPoint[] datapoints;
//	private static DataPoint[] datapoints = new DataPoint[] {
//		new DataPoint (0, 1305), 
//		new DataPoint (1, 1358), 
//		new DataPoint (2, 1414),
//		new DataPoint (3, 1314),
//		new DataPoint (4, 1394),
//		new DataPoint (5, 1310),
//		new DataPoint (6, 1190),
//		new DataPoint (7, 1090),
//		new DataPoint (8, 970),
//		new DataPoint (9, 842),
//		new DataPoint (10, 792)
//};
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
//		datapoints = (DataPoint[]) dataPointList.toArray();
		return datapoints;
	}
	
	public void addDataPoint(DataPoint dataPoint) {
		dataPointList.add(dataPoint);
	}

}
