package com.lcaohoanq.fundamental.classtype;

public interface IStudentService {
    void addStudent(Student student);
    void displayStudent();
    void updateStudent(String id, Student student);
    void deleteStudent(String id);
    Student searchStudent(String id);
}
