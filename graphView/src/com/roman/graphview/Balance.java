package com.roman.graphview;

public class Balance {
	
	private static double currentBalance = 0;
	private static int targetIncrease = 0;

	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getTargetIncrease() {
		return targetIncrease;
	}

	public void setTargetIncrease(int targetIncrease) {
		this.targetIncrease = targetIncrease;
	}
	
	public int getTargetBalance() {
		return getTargetBalance() + getTargetIncrease();
	}

}
