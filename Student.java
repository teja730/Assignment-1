class Student implements Student_ {
    public String name;               	// Returns student's name
    public String entryNo;        	// Returns student's entry number
    public String hostel;             	// Returns student's hostel name
    public String department;         	// Returns student's department name

    public String name(){
        return name;
    }
    public String entryNo(){
        return entryNo;
    }
    public String hostel(){
        return hostel;
    }
    public String department(){
        return department;
    }
    float completedcredits;
    public String completedCredits(){
        int x=0;
        NIterator<CourseGrade> it=courseList();
        while(it.elem!=null){
            if(!it.elem.value().grade().grade.equals("I")){
                x++;
            }
            if(it.hasNext())
                it.next();
            else break;
        }
        completedcredits=3*x;
        return Float.toString(completedcredits);
    }
    public String cgpa(){
        int x = 0;
        NIterator<CourseGrade> it=courseList();
        while(it.elem!=null){
            x=x+ GradeInfo_.gradepoint(it.elem.value().grade().grade());
            if(it.hasNext())
                it.next();
                else break;
        }
        completedCredits();
        float y= 3*x/completedcredits;
        y= (float) (Math.round(y*100)/100.0);
        return Float.toString(y);
    }
    public pos<CourseGrade> head;
    public int c=0;
    public int coursesCount(){return c;}
    public pos<CourseGrade> addCourse(CourseGrade course){
        if(head==null){
            c++;
            head=new pos<CourseGrade>(course,null);
            return head;
        }else{
            pos<CourseGrade> last= head;
            while(last.after()!=null){
                last=last.after();
            }
            c++;
            last.n=new pos<CourseGrade>(course,null);
            return last.n;
        }
    }

    public NIterator<CourseGrade> courseList(){
        return new NIterator<CourseGrade>(head);
    }
}