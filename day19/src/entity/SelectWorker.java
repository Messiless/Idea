package entity;

/**
 * Created by Computer on 2017/1/25.
 */
public class SelectWorker {
private String deptname;
    private String prin;
    private String function;

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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "SelectWorker{" +
                "deptname='" + deptname + '\'' +
                ", prin='" + prin + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
