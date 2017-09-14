package cn.crs.common.datatables.entity;

public class DataTablesSortParam {
	private int iSortCol;
	private String sSortDir;
	public int getiSortCol() {
		return iSortCol;
	}
	public void setiSortCol(int iSortCol) {
		this.iSortCol = iSortCol;
	}
	public String getsSortDir() {
		return sSortDir;
	}
	public void setsSortDir(String sSortDir) {
		this.sSortDir = sSortDir;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iSortCol;
		result = prime * result
				+ ((sSortDir == null) ? 0 : sSortDir.hashCode());
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
		DataTablesSortParam other = (DataTablesSortParam) obj;
		if (iSortCol != other.iSortCol)
			return false;
		if (sSortDir == null) {
			if (other.sSortDir != null)
				return false;
		} else if (!sSortDir.equals(other.sSortDir))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DataTablesSortParam [iSortCol=" + iSortCol + ", sSortDir="
				+ sSortDir + "]";
	}


}
