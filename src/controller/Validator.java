package controller;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

public class Validator {
    // field: la truong kiem tra loi
   // string builder : hien thi thong bao loi cho nguoi dung
   // msg: thong bao loi
    // kiem tra mot truong co duoc nhap hay khong
    public static boolean checkEmpty(JTextField field, StringBuilder sb, String msg){
        
        boolean check = true;
        // kiem tra truong co rong hay khong neu rong thi thong bao loi
        if(field.getText().equals("")){
            sb.append(msg).append("\n");
            // hieu chinh back ground 
            field.setBackground(Color.red);
            // gan co kiem tra co van de
            check = false;
        }else{
            field.setBackground(Color.white);
        }
        return check;
    }
   
    // kiem tra id 
    public static boolean checkStudentId(JTextField field, StringBuilder sb){
        boolean check = true;
        if(!checkEmpty(field,sb,"Student id has not been imported ")){
            return false;
        }
        try{
            String pattern = "[sS][\\d]{4}";
            String stdID = field.getText();
            if(!stdID.matches(pattern)){
                sb.append("The student id is not in the correct format (must start S and have 5 characters!!!)\n");
                field.setBackground(Color.red);
                check = false;
            }
        }catch(Exception e){
            sb.append("Value role invalid must be number\n");
            field.setBackground(Color.red);       
            check = false;    
        }
        if(check){
            field.setBackground(Color.white);
        }
        return check;
    }
    
   
}
