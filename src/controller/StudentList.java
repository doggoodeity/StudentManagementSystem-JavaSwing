package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Student;
import view.Main;

public class StudentList {
    // KHAI BAO DANH SACH NHAN VIEN SU DUNG ARRAYLIST
    private ArrayList<Student> listStudent = new ArrayList<>();
    
     // SET CHI SO BAN DAU 
    private int currentIndex = 0;
    
    
    /* PHAN XU LY INDEX OF RECORDED */
    // HIEN THI CHI SO
    public String getCurrentStudentInfo(){
        return "Record " + (currentIndex + 1) + " of " +listStudent.size();
    }
    // SET CHI SO 
    public void setCurrentStudent(Student std){
         currentIndex = listStudent.indexOf(std);
    }
    // TRUY CAP TOI PHAN TU DAU TIEN
    public void first(){
        if(currentIndex > 0) currentIndex = 0;
    }
    // TRUY CAP TOI PHAN TU TRUOC DO
    public void previous(){
         if(currentIndex > 0) currentIndex--;
    }
    // TRUY CAP TOI PHAN TU KE TIEP
    public void next(){
         if(currentIndex < listStudent.size() - 1) currentIndex++;
    }
    // TRUY CAP TOI PHAN TU CUOI CUNG
    public void last(){
          currentIndex = listStudent.size()-1;
    }
    // TRA VE PHAN TU HIEN DANG TRUY CAP
    public int getCurrentStudentIndex(){
        return currentIndex;
    }
    // TRA VE STUDENT DANG THAO TAC O TRONG DANH SACH
    public Student getCurrentEmployee(){
        if(listStudent.size()==0) return null;
        return listStudent.get(currentIndex);
    }
    /* THEM NHAN VIEN VAO DANH SACH */
    public void add(Student std){
        listStudent.add(std);
    }
    
    
    
    /* TIM KIEM THEO ID */
    public Student findById(String stdID){
        for(Student std : listStudent ){
            if(std.getId().equals(stdID)){
                return std;
            }
        }
        return null;
    }
    
    /* XOA THEO ID */
    public boolean deleteById(String stdID){
        Student deleteStudent = findById(stdID);
        if(deleteStudent != null){
        listStudent.remove(deleteStudent);
        return true;
        }
        return false;
    }
     /* CAP NHAT THEO ID */
    public boolean update(Student emp) {
        // KIEM TRA DANH SACH CO ID DO HAY KHONG
        Student existedEmp = findById(emp.getId());
        boolean flag = false;
        // NEU CO THI SE CAP NHAT
        if(existedEmp!= null){
            existedEmp.setId(emp.getId());
            existedEmp.setFullName(emp.getFullName());
            existedEmp.setSex(emp.getSex());
            existedEmp.setProgressTest(emp.getProgressTest());
            existedEmp.setWorkShop(emp.getWorkShop());
            existedEmp.setPracticalExam(emp.getPracticalExam());
            existedEmp.setFinalExam(emp.getFinalExam());
            existedEmp.setAssignment(emp.getAssignment());
            
            flag = true;
        }
        // NEU CAP NHAT THANH CONG THI FLAG SE TRA VE TRUE
        return flag;
    }
    /* XOA TAT CA HOC SINH */
    public void deleteAll(){
        listStudent.removeAll(listStudent);
    }
    
    /* HIEN THI DATA RA BANG */ 
    public void renderToTable(DefaultTableModel tblModel) {
       // XOA TRANG HANG TRONG BANG
        tblModel.setRowCount(0);
        // MOI Student THI TAO MOT HANG TRONG BANG
        for(Student student : listStudent){
            //TAO VA DINH NGHIA CAC THUOC TINH TRONG MOT HANG
            
            Object[] row = new Object[]{
                student.getId(), student.getFullName(),student.getSex(),student.getProgressTest()
               ,student.getWorkShop(),student.getAssignment(),student.getPracticalExam(),student.getFinalExam(),student.getResult(),student.getStatus()
            };
            // ADD ROW VAO TABLE MODEL 
            tblModel.addRow(row);
            // CAP NHAT LAI FILE DATA DA THAY DOI CHO TABLE
        tblModel.fireTableDataChanged();
        }
        
    }
    // save file 
    public boolean exportData(){
        try {
            FileWriter csvWriter =new FileWriter("student.csv");
            for(Student s : listStudent){
                csvWriter.append(s.toString()+"\n");
                return true;
            }
            csvWriter.flush();
        csvWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
