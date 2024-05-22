package model;

public class Student {
    private String id;
    private String fullName;
    private String sex;
    //Assignment, Workshop, Practical Exam, Final exam. 
    private double progressTest ;
    private double assignment;
    private double workShop;
    private double practicalExam;
    private double finalExam;

    public Student(){
        
    }
    public Student(String id, String fullName, String sex, double progressTest, double assignment, double workShop, double practicalExam, double finalExam) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
        this.progressTest = progressTest;
        this.assignment = assignment;
        this.workShop = workShop;
        this.practicalExam = practicalExam;
        this.finalExam = finalExam;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getProgressTest() {
        return progressTest;
    }

    public void setProgressTest(double progressTest) {
        this.progressTest = progressTest;
    }

    public double getWorkShop() {
        return workShop;
    }

    public void setWorkShop(double workShop) {
        this.workShop = workShop;
    }

    public double getPracticalExam() {
        return practicalExam;
    }

    public void setPracticalExam(double practicalExam) {
        this.practicalExam = practicalExam;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
    
    public double getResult(){
        return 0.1*progressTest + 0.1*assignment + 0.1*workShop + 0.4*practicalExam + 0.3*finalExam;
    }
    
    public String getStatus(){
        if(assignment > 0 && workShop > 0 && progressTest > 0 && finalExam >= 4 && this.getResult() >= 5 && this.practicalExam > 0 ) return "completed";
        return "incompleted";
    }

    @Override
    public String toString() {
        return ""+id + ", " + fullName + ", " + sex + ", " + progressTest + ", " + assignment + ", " + workShop + ", " + practicalExam + ", " + finalExam ;
    }
    
            
}
