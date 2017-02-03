package com.frt.model;

public class ErrorDesc {
	
	private int rowNo;
	private StringBuffer Description;	
	
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public StringBuffer getDescription() {
		return Description;
	}
	public void setDescription(StringBuffer description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "ErrorDesc [rowNo=" + rowNo + ", Description=" + Description
				+ "]";
	}
	
}
