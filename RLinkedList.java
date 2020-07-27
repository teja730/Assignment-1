
public class RLinkedList<T> {
    public pos<T> head;
    public int count=0;
    public pos<T> add(T e){
        if(head==null){
            head= new pos<T>(e,null);
            count++;
            return head;
        }else{
            pos<T> last=new pos<T>(e,null);
            last.n= head;
            head=last;
            count++;
            return head;
        }
    }
    public LLIterator<T> positions(){
        return new LLIterator<T>(head);
    }

    public int count(){
        return count;
    }
}
