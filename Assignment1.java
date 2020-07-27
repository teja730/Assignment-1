import java.io.*;
import java.util.Scanner;

public class Assignment1 {
    public static class string{
        String value;
        public string(String value){
            this.value=value;
        }

    }
    public static class Data{
        public static LinkedList<Hostel> allHostels=new LinkedList<Hostel>();
        public static LinkedList<Department> allDepartments = new LinkedList<Department>();
        public static LinkedList<Course> allCourses = new LinkedList<Course>();
    }
    public static void main(String[] args) throws IOException {

        Assignment1.getData(args[0],args[1]);
        Assignment1.answerQueries(args[2]);

    }
    private static void getData (String student_record_file,String course_file) throws IOException  {
        FileReader studentRecord = new FileReader(student_record_file);
        BufferedReader a = new BufferedReader(studentRecord);
        FileReader courses = new FileReader(course_file);
        BufferedReader c = new BufferedReader(courses);
        String line;
        LinkedList<Hostel> allHostels=Data.allHostels;
        LinkedList<Department> allDepartments = Data.allDepartments;
        LinkedList<Course> allCourses = Data.allCourses;
        while ((line = a.readLine()) != null) {
            String[] inp = line.split(" ");
            Student student = new Student();
            student.entryNo = inp[0];
            student.name = inp[1];
            student.department = inp[2];
            student.hostel = inp[3];
            // adding each element to Hostels and adding each hostel to allHostels
            LLIterator<Hostel> it = allHostels.positions();
            boolean b = true;
            if (allHostels.head != null) {
                while (true) {
                    if (it.elem.value().name().equals(inp[3])) {
                        b = false;
                        it.elem.value().add(student);
                        break;
                    } else if (it.hasNext()) {
                        it.next();
                    } else {
                        break;
                    }
                }
            }
            if (b) {
                Hostel n = new Hostel(inp[3]);
                n.add(student);
                allHostels.add(n);
            }
            //adding elements to each department and adding each department to allDepartments
            LLIterator<Department> it2 = allDepartments.positions();
            b = true;
            if (allDepartments.head != null) {
                while (true) {
                    if (it2.elem.value().name().equals(student.department())) {
                        b = false;
                        it2.elem.value().add(student);
                        break;
                    } else if (it2.hasNext()) {
                        it2.next();
                    } else {
                        break;
                    }
                }
            }
            if (b) {
                Department n = new Department(inp[2]);
                n.add(student);
                allDepartments.add(n);
            }
        }
        // adding elements to allCourses from the file Course
        while((line=c.readLine())!=null){
            String[] inp=line.split(" ",4);



            LLIterator<Department> d_it=allDepartments.positions();

            while(d_it.elem!=null){
                OIterator<Student> s_it=d_it.elem.value().studentList();
                while(s_it.elem!=null){
                    if(s_it.elem.value().entryNo().equals(inp[0])){
                        CourseGrade course=new CourseGrade();
                        course.course_num=inp[1];
                        course.course_title=inp[3];
                        course.grade().grade=inp[2];
                        s_it.elem.value().addCourse(course);
                        LLIterator<Course> it3=allCourses.positions();
                        boolean b=true;
                        if (allCourses.head != null) {
                            while (true) {
                                if (it3.elem.value().name().equals(inp[3])) {
                                    b = false;
                                    it3.elem.value().add(s_it.elem.value());
                                    break;
                                } else if (it3.hasNext()) {
                                    it3.next();
                                } else {
                                    break;
                                }
                            }
                        }
                        if (b) {
                            Course n = new Course(inp[3]);
                            n.CourseCode=inp[1];
                            n.add(s_it.elem.value());
                            allCourses.add(n);
                        }
                    }
                    if(s_it.hasNext())
                    s_it.next();
                    else break;
                }
                if(d_it.hasNext())
                d_it.next();
                else break;;
            }


        }
        a.close();
        c.close();
        studentRecord.close();
        courses.close();
    }
    private static void answerQueries(String student_query_file/*,String output_file*/) throws IOException {
        LinkedList<Hostel> allHostels=Data.allHostels;
        LinkedList<Department> allDepartments = Data.allDepartments;
        LinkedList<Course> allCourses = Data.allCourses;
        FileReader queries= new FileReader(student_query_file);
        BufferedReader q= new BufferedReader(queries);
        String line;
        RLinkedList<string> input= new RLinkedList<string>();
        while ((line=q.readLine())!=null){
            String temp=line;
            input.add(new string(temp));
        }
        q.close();
        queries.close();
        LLIterator<string> nit=input.positions();
        while(nit.elem!=null){
            line=nit.elem.value().value;
            String[] inp=line.split(" ");
            if(inp[0].equals("INFO")){


                LLIterator<Department> d_it=allDepartments.positions();

                while(d_it.elem!=null){
                    OIterator<Student> s_it=d_it.elem.value().studentList();

                    while(s_it.elem!=null){
                        if(s_it.elem.value().entryNo().equals(inp[1])||s_it.elem.value().name().equals(inp[1])){
                            System.out.print(s_it.elem.value().entryNo()+" "+s_it.elem.value().name()+" "+s_it.elem.value().department()+" "+s_it.elem.value().hostel()+" "+s_it.elem.value().cgpa()+" ");
                            NIterator<CourseGrade> c_it= s_it.elem.value().courseList();
                            CourseGrade[] courses=new CourseGrade[s_it.elem.value().coursesCount()];
                            int i=0;
                            while(c_it.elem!=null){
                                courses[i]=c_it.elem.value();
                                i++;
                                if(c_it.hasNext())
                                    c_it.next();
                                else break;
                            }
                            for(int k=0;k<s_it.elem.value().coursesCount()-1;k++){
                                for(int j=0;j<s_it.elem.value().coursesCount()-k-1;j++){
                                    if(courses[j].coursenum().compareTo(courses[j+1].coursenum())>0){
                                        CourseGrade temp=courses[j];
                                        courses[j]=courses[j+1];
                                        courses[j+1]=temp;
                                    }
                                }
                            }
                            for(int j=0;j<s_it.elem.value().coursesCount();j++){
                                System.out.print(courses[j].coursenum()+" "+courses[j].grade().grade+" ");

                            }
                            System.out.println("");


                        }
                        if(s_it.hasNext())
                            s_it.next();
                        else break;
                    }
                    if(d_it.hasNext())
                        d_it.next();
                    else break;;
                }



            }
            if(inp[0].equals("SHARE")){
                LLIterator<Hostel> h_it=allHostels.positions();
                String[] outp;
                int j=0;
                //checking hostels
                while(h_it.elem!=null){
                    OIterator<Student> s_it=h_it.elem.value().studentList();
                    if(h_it.elem.value().name().equals(inp[2])) {
                        while (s_it.elem != null) {
                            if (s_it.elem.value().entryNo().equals(inp[1])) {
                                outp=new String[h_it.elem.value().count-1];

                                OIterator<Student> sn_it=h_it.elem.value().studentList();
                                while(sn_it.elem!=null) {
                                    if (sn_it.elem.value() != s_it.elem.value()) {
                                        outp[j]=sn_it.elem.value().entryNo() ;
                                        j++;
                                    }
                                    if(sn_it.hasNext())
                                        sn_it.next();
                                    else break;
                                }
                                //arrange lexagrpically
                                for(int k=0;k<outp.length-1;k++){
                                    for(int f=0;f<outp.length-k-1;f++){
                                        if(outp[f].compareTo(outp[f+1])>0){
                                            String temp=outp[f];
                                            outp[f]=outp[f+1];
                                            outp[f+1]=temp;
                                        }
                                    }
                                }
                                for(int i=0;i<j;i++){
                                    System.out.print(outp[i]+" ");
                                }
                                System.out.println("");
                            }
                            if (s_it.hasNext())
                                s_it.next();
                            else break;
                        }
                    }
                    if(h_it.hasNext())
                        h_it.next();
                    else break;;
                }
                LLIterator<Department> d_it=allDepartments.positions();
                //checking departments
                while(d_it.elem!=null){
                    OIterator<Student> s_it=d_it.elem.value().studentList();
                    if(d_it.elem.value().name().equals(inp[2])) {
                        while (s_it.elem != null) {
                            if (s_it.elem.value().entryNo().equals(inp[1])) {
                                outp=new String[d_it.elem.value().count-1];

                                OIterator<Student> sn_it=d_it.elem.value().studentList();
                                while(sn_it.elem!=null) {
                                    if (sn_it.elem.value() != s_it.elem.value()) {
                                        outp[j]=sn_it.elem.value().entryNo() ;
                                        j++;
                                    }
                                    if(sn_it.hasNext())
                                        sn_it.next();
                                    else break;
                                }
                                //arrange lexagrpically
                                for(int k=0;k<outp.length-1;k++){
                                    for(int f=0;f<outp.length-k-1;f++){
                                        if(outp[f].compareTo(outp[f+1])>0){
                                            String temp=outp[f];
                                            outp[f]=outp[f+1];
                                            outp[f+1]=temp;
                                        }
                                    }
                                }
                                for(int i=0;i<j;i++){
                                    System.out.print(outp[i]+" ");
                                }
                                System.out.println("");
                            }
                            if (s_it.hasNext())
                                s_it.next();
                            else break;
                        }
                    }
                    if(d_it.hasNext())
                        d_it.next();
                    else break;;
                }
                LLIterator<Course> c_it=allCourses.positions();
                //checking courses
                while(c_it.elem!=null){
                    OIterator<Student> s_it=c_it.elem.value().studentList();
                    if(c_it.elem.value().CourseCode.equals(inp[2])) {
                        while (s_it.elem != null) {
                            if (s_it.elem.value().entryNo().equals(inp[1])) {
                                outp=new String[c_it.elem.value().count-1];

                                OIterator<Student> sn_it=c_it.elem.value().studentList();
                                while(sn_it.elem!=null) {
                                    if (sn_it.elem.value() != s_it.elem.value()) {
                                        outp[j]=sn_it.elem.value().entryNo() ;
                                        j++;
                                    }
                                    if(sn_it.hasNext())
                                        sn_it.next();
                                    else break;
                                }
                                //arrange lexagrpically
                                for(int k=0;k<outp.length-1;k++){
                                    for(int f=0;f<outp.length-k-1;f++){
                                        if(outp[f].compareTo(outp[f+1])>0){
                                            String temp=outp[f];
                                            outp[f]=outp[f+1];
                                            outp[f+1]=temp;
                                        }
                                    }
                                }
                                for(int i=0;i<j;i++){
                                    System.out.print(outp[i]+" ");
                                }
                                System.out.println("");
                            }
                            if (s_it.hasNext())
                                s_it.next();
                            else break;
                        }
                    }
                    if(c_it.hasNext())
                        c_it.next();
                    else break;;
                }

            }
            if(inp[0].equals("COURSETITLE")){
                LLIterator<Course> it= allCourses.positions();
                while(it.elem!=null){
                    if(it.elem.value().CourseCode.equals(inp[1])) {
                        System.out.println(it.elem.value().name());
                        break;
                    }
                    if(it.hasNext())
                        it.next();
                    else break;
                }
            }
            if(nit.hasNext())
            nit.next();
            else break;
        }

    }
}

