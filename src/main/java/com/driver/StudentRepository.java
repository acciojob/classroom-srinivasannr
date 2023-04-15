package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    List<String> studentList=new ArrayList<>();
    HashMap<String,Student> studentMap=new HashMap<>();
    List<Teacher> teacherList=new ArrayList<>();
    HashMap<String,Teacher> teacherMap=new HashMap<>();

    HashMap<String,List<String>> Pair=new HashMap<>();
    public void addStudent(Student student){
        studentList.add(student.getName());
        studentMap.put(student.getName(),student);
        return;
    }
    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
        teacherMap.put(teacher.getName(),teacher);
        return;
    }
    public void addStudentTeacherPair(String student,String teacher){
        if(Pair.containsKey(teacher)){
            Pair.get(teacher).add(student);
        }
        else{
            List<String> st=new ArrayList<>();
            st.add(student);
            Pair.put(teacher,st);
        }

        return;
    }


    public Student getStudentByName(String name){
        return studentMap.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String name){
        return Pair.get(name);
    }

    public List<String> getAllStudents(){
        return studentList;
    }
    public void deleteAllTeachers(){
        teacherList=new ArrayList<>();
        Pair=new HashMap<>();
    }
    public void deleteTeacherByName(String name){
        Pair.remove(name);
    }
}
