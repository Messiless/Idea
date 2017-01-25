package entity;

/**
 * Created by Computer on 2017/1/25.
 */
public class Work {
    private int id;
    private String deptname;
    private String prin;
    private String functional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getPrin() {
        return prin;
    }

    public void setPrin(String prin) {
        this.prin = prin;
    }

    public String getFunctional() {
        return functional;
    }

    public void setFunctional(String functional) {
        this.functional = functional;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", prin='" + prin + '\'' +
                ", functional='" + functional + '\'' +
                '}';
    }
}
