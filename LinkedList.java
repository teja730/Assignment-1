class LinkedList<T> implements LinkedList_<T>{
    public pos<T> head;
    public pos<T> add(T e){
        if(head==null){
            head= new pos<T>(e,null);
            return head;
        }else{
            pos<T> last= head;
            while(last.after()!=null){
                last=last.after();
            }
            last.n=new pos<T>(e,null); //replace .after() with n if it doesnt work since .after() is a method and it has an assigned value before  
            return last.n;
        }
    }
    public LLIterator<T> positions(){
        return new LLIterator<T>(head);
    }
    public int count(){
        int i=0;
        pos<T> last=head;
        while(last!=null){
            i++;
            last=last.after();
        }
        return i;
    }
}