package org.example;

public class Student {
    String name;
    int semester;
    boolean isActive;

    public Student(String name, int semester, boolean isActive) {
        this.name = name;
        this.semester = semester;
        this.isActive = isActive;
    }

    public boolean isDoingMBKM(){
        if (semester >= 6 && isActive){
            return true;
        }
        return false;
    }

}
