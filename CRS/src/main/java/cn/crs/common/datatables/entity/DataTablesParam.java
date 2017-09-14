package cn.crs.common.datatables.entity;

import java.util.List;

public class DataTablesParam {
	private int sEcho;
	private int iColumns;
	private String sColumns;
	private int iDisplayStart;
	private int iDisplayLength;
	private String sSearch;
	private boolean bRegex;
	private int iSortingCols;
	private List<DataTablesColParam> dataTablesColParam;
	private List<DataTablesSortParam> dataTablesSortParam;
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public int getiColumns() {
		return iColumns;
	}
	public void setiColumns(int iColumns) {
		this.iColumns = iColumns;
	}
	public String getsColumns() {
		return sColumns;
	}
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public String getsSearch() {
		return sSearch;
	}
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}
	public boolean getbRegex() {
		return bRegex;
	}
	public void setbRegex(boolean bRegex) {
		this.bRegex = bRegex;
	}
	public int getiSortingCols() {
		return iSortingCols;
	}
	public void setiSortingCols(int iSortingCols) {
		this.iSortingCols = iSortingCols;
	}
	public List<DataTablesColParam> getDataTablesColParam() {
		return dataTablesColParam;
	}
	public void setDataTablesColParam(List<DataTablesColParam> dataTablesColParam) {
		this.dataTablesColParam = dataTablesColParam;
	}
	public List<DataTablesSortParam> getDataTablesSortParam() {
		return dataTablesSortParam;
	}
	public void setDataTablesSortParam(List<DataTablesSortParam> dataTablesSortParam) {
		this.dataTablesSortParam = dataTablesSortParam;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bRegex ? 1231 : 1237);
		result = prime
				* result
				+ ((dataTablesColParam == null) ? 0 : dataTablesColParam
						.hashCode());
		result = prime
				* result
				+ ((dataTablesSortParam == null) ? 0 : dataTablesSortParam
						.hashCode());
		result = prime * result + iColumns;
		result = prime * result + iDisplayLength;
		result = prime * result + iDisplayStart;
		result = prime * result + iSortingCols;
		result = prime * result
				+ ((sColumns == null) ? 0 : sColumns.hashCode());
		result = prime * result + sEcho;
		result = prime * result + ((sSearch == null) ? 0 : sSearch.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataTablesParam other = (DataTablesParam) obj;
		if (bRegex != other.bRegex)
			return false;
		if (dataTablesColParam == null) {
			if (other.dataTablesColParam != null)
				return false;
		} else if (!dataTablesColParam.equals(other.dataTablesColParam))
			return false;
		if (dataTablesSortParam == null) {
			if (other.dataTablesSortParam != null)
				return false;
		} else if (!dataTablesSortParam.equals(other.dataTablesSortParam))
			return false;
		if (iColumns != other.iColumns)
			return false;
		if (iDisplayLength != other.iDisplayLength)
			return false;
		if (iDisplayStart != other.iDisplayStart)
			return false;
		if (iSortingCols != other.iSortingCols)
			return false;
		if (sColumns == null) {
			if (other.sColumns != null)
				return false;
		} else if (!sColumns.equals(other.sColumns))
			return false;
		if (sEcho != other.sEcho)
			return false;
		if (sSearch == null) {
			if (other.sSearch != null)
				return false;
		} else if (!sSearch.equals(other.sSearch))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DataTablesParam [sEcho=" + sEcho + ", iColumns=" + iColumns
				+ ", sColumns=" + sColumns + ", iDisplayStart=" + iDisplayStart
				+ ", iDisplayLength=" + iDisplayLength + ", sSearch=" + sSearch
				+ ", bRegex=" + bRegex + ", iSortingCols=" + iSortingCols
				+ ", dataTablesColParam=" + dataTablesColParam
				+ ", dataTablesSortParam=" + dataTablesSortParam + "]";
	}
	
	
}
