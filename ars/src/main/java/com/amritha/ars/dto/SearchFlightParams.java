package com.amritha.ars.dto;

public class SearchFlightParams {
	
	private String from;
    
	private String to;
	
    private String fromDate;

    private String toDate;
    
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	public void setDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
