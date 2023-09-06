public class Student {
    String Name;
    String SurName;

    int Number;

    double Note;

    public Student(String name, String surName, int number, double note) {
        Name = name;
        SurName = surName;
        Number = number;
        Note = note;
    }

    public String getName() {
        return Name;
    }

    public String getSurName() {
        return SurName;
    }

    public int getNumber() {
        return Number;
    }

    public double getNote() {
        return Note;
    }


    @Override
    public String toString() {
        return "Öğrenci Adı : " + Name + "Öğrenci Notu: " + Note;
    }
}
