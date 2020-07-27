import java.io.*;
import java.util.*;

class LLIterator<T> implements Iterator<Position_<T>>{
    pos<T> elem;
    public LLIterator (pos<T> temp){
        elem=temp;
    }
    public boolean hasNext(){
        return elem.after()!=null;
    }
    public boolean b=false;
    public pos<T> next(){
        b=true;
        if(hasNext()==true) {
            pos<T> temp;
            temp=elem;
            elem = elem.after();
            return temp;
        }
        else throw new NoSuchElementException();
    }

}