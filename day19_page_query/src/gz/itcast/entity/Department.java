package gz.itcast.entity;

public class Department {
	private int id;
	private String deptName;
	private String principal;
	private String functional;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getFunctional() {
		return functional;
	}
	public void setFunctional(String functional) {
		this.functional = functional;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", functional="
				+ functional + ", id=" + id + ", principal=" + principal + "]";
	}
	
}
