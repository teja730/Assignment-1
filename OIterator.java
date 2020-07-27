import java.io.*;
import java.util.*;

class OIterator<Student extends Student_> implements Iterator<Student_>{
    pos<Student> elem;
    public OIterator (pos<Student> temp){
        elem=temp;
    }
    public boolean hasNext(){
        return elem.after()!=null;
    }
    public Student_ next(){
        if(hasNext()==true) {
            pos<Student> temp;
            temp=elem;
            elem = elem.after();
            return temp.value();
        }
        else throw new NoSuchElementException();
    }
}