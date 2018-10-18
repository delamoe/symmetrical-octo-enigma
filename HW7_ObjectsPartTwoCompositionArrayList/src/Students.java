/* import java.util.ArrayList;
import java.util.List;

public class Students {

  private List<Student> studentList = new ArrayList<Student>();
 
  public void addStudent( Student studentObj ) {
    studentList.add(studentObj);
  }

  public void addPerson(List<Student> studentsToAdd) {
    for (Student studentObj : studentsToAdd){
      studentList.add(studentObj);
    }
  }

  public Student locateStudent(int studentID){
    for (Student studentObj : studentList){
      if (studentObj.getStudentID() == studentID){
        return studentObj;
      }
    }
    return null;
  }

  public void withdrawStudent(int studentID){
    for (Student studentObj : studentList) 
    {
      if (studentObj.getStudentID() == studentID)
      {
        studentList.remove(studentObj); 

        break; 
      }
    }
  }

  public void assignGrade( int studentID, int grade){
    for (Student studentObj : studentList){
      if (studentObj.getStudentID() == studentID){
        studentObj.setGrade(grade);

        break;
      }
    }
  }

  public void displayStudents(){
    for (Student studentObj : studentList){
      studentObj.toString();
    }
  }


} */