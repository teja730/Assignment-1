class pos<T> implements Position_<T>{
    public T v;
    public pos<T> n;
    public pos (T val,pos<T> next){
        v=val;
        n=next;
    }
    public T value(){
        return v;
    }
    public pos<T> after(){
        return n;
    }
}