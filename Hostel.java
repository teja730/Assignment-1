import java.io.*;
import java.util.*;

class Hostel implements Entity_ {
    public String n;
    public pos<Student> head;
    public int count=0;
    public pos<Student> add(Student student){
        if(head==null){
            head=new pos<Student>(student,null);
            count++;
            return head;
        }else{
            pos<Student> last= head;
            while(last.after()!=null){
                last=last.after();
            }
            last.n=new pos<Student>(student,null);
            count++;
            return last.n;
        }
    }
    public Hostel(String name) {
        n = name;
    }

    public String name() {
        return n;
    }

    public OIterator<Student> studentList() {
        return new OIterator<Student> (head);
    }
}
