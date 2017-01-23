package service;

import demo.PageDemo;
import entity.Employee;
import entity.PageBean;

import java.util.List;

/**
 * Created by Computer on 2017/1/23.
 */
public class PageService {
    public PageBean getPageBean(int check,int pageSize){
        PageBean pageBean =new PageBean();
        pageBean.setCheckPage(check);

        //每一页的数量
        pageBean.setEveryPage(pageSize);
        PageDemo p=new PageDemo();

        //总数量
        int cout=p.getCounts();
        pageBean.setCountPage(cout);
        List<Employee> list= p.getPageEm(pageBean.getCheckPage(),pageBean.getEveryPage());
        pageBean.setList(list);
        return pageBean;
    }
}
