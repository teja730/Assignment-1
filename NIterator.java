import java.io.*;
import java.util.*;

class NIterator<CourseGrade extends CourseGrade_> implements Iterator<CourseGrade_>{
    pos<CourseGrade> elem;
    public NIterator (pos<CourseGrade> temp){
        elem=temp;
    }
    public boolean hasNext(){
        return elem.after()!=null;
    }
    public CourseGrade_ next(){
        if(hasNext()==true) {
            pos<CourseGrade> temp;
            temp=elem;
            elem = elem.after();
            return temp.value();
        }
        else throw new NoSuchElementException();
    }
}