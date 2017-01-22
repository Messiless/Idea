package demo;

import java.util.List;

/**
 * Created by Computer on 2017/1/22.
 */
public class PageBean {
    List<Employee> list;
    int FirstPage;
    int  LastPage;
    int CheckPage;
    int NextPage;
    int BeforePage;
    int CountPage;
    int EveryPage;

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public int getFirstPage() {
        return FirstPage;
    }

    public void setFirstPage(int firstPage) {
        FirstPage = firstPage;
    }

    public int getLastPage() {
        return LastPage;
    }

    public void setLastPage(int lastPage) {
        LastPage = lastPage;
    }

    public int getCheckPage() {
        return CheckPage;
    }

    public void setCheckPage(int checkPage) {
        CheckPage = checkPage;
    }

    public int getNextPage() {
        return NextPage;
    }

    public void setNextPage(int nextPage) {
        NextPage = nextPage;
    }

    public int getBeforePage() {
        return BeforePage;
    }

    public void setBeforePage(int beforePage) {
        BeforePage = beforePage;
    }

    public int getCountPage() {
        return CountPage;
    }

    public void setCountPage(int countPage) {
        CountPage = countPage;
    }

    public int getEveryPage() {
        return EveryPage;
    }

    public void setEveryPage(int everyPage) {
        EveryPage = everyPage;
    }
}
