import java.io.*;
import java.util.*;

public interface Entity_ { // Entities Classes Hostel, Dept, and Course all have this functionality.
    public String name();                 // Returns this  entity's name
    public Iterator<Student_> studentList();        // Returns all students of this entity
}