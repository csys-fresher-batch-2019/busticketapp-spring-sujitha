package com.chainsys.busticketapp.domain;

public class BusRoutes {
	private int routeNo;
	private String fromLocation;
	private String toLocation;

	public int getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	@Override
	public String toString() {
		return "BusRoutes [routeNo=" + routeNo + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + "]";
	}
}
