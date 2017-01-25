package service;

import demo.SelectDemo;
import entity.SelectWorker;
import entity.Work;

import java.util.List;

/**
 * Created by Computer on 2017/1/25.
 */
public class SelectService {
    SelectDemo s1=new SelectDemo();
    public List<Work> getSel(SelectWorker selectWorker){
        return  s1.getSelect(selectWorker);
    }
}
