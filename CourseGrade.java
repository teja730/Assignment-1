class CourseGrade implements CourseGrade_ {
    public String course_title;
    public String coursetitle(){
        return course_title;
    }
    public String course_num;
    public String coursenum(){
        return course_num;
    }

    public GradeInfo gradeinfo=new GradeInfo();
    public GradeInfo grade(){
        return gradeinfo;
    }
}