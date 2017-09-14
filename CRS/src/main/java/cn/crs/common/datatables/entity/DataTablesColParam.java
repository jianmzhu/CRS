package cn.crs.common.datatables.entity;

public class DataTablesColParam {
	private String mDataProp;
	private String sSearch;
	private boolean bRegex;
	private boolean bSearchable;
	private boolean bSortable;
	public String getmDataProp() {
		return mDataProp;
	}
	public void setmDataProp(String mDataProp) {
		this.mDataProp = mDataProp;
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
	public boolean getbSearchable() {
		return bSearchable;
	}
	public void setbSearchable(boolean bSearchable) {
		this.bSearchable = bSearchable;
	}
	public boolean getbSortable() {
		return bSortable;
	}
	public void setbSortable(boolean bSortable) {
		this.bSortable = bSortable;
	}
	@Override
	public String toString() {
		return "DataTablesColParam [mDataProp=" + mDataProp + ", sSearch="
				+ sSearch + ", bRegex=" + bRegex + ", bSearchable="
				+ bSearchable + ", bSortable=" + bSortable + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bRegex ? 1231 : 1237);
		result = prime * result + (bSearchable ? 1231 : 1237);
		result = prime * result + (bSortable ? 1231 : 1237);
		result = prime * result
				+ ((mDataProp == null) ? 0 : mDataProp.hashCode());
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
		DataTablesColParam other = (DataTablesColParam) obj;
		if (bRegex != other.bRegex)
			return false;
		if (bSearchable != other.bSearchable)
			return false;
		if (bSortable != other.bSortable)
			return false;
		if (mDataProp == null) {
			if (other.mDataProp != null)
				return false;
		} else if (!mDataProp.equals(other.mDataProp))
			return false;
		if (sSearch == null) {
			if (other.sSearch != null)
				return false;
		} else if (!sSearch.equals(other.sSearch))
			return false;
		return true;
	}

}
