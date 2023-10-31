/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project101;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate; 
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Calendar; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timomichaelis
 */
public class TimeHandler {
    
    private Date beginning; 
    private Date end; 
    public String study1, study2, study3, study4, study5; 
    public String [] studyp = new String[5]; 
    
    
    String format = "dd/MM/yyyy";
    
    public TimeHandler(String start, String finish){
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        
        try{
            beginning = sdf.parse(start); 
            end = sdf.parse(finish); 
        }catch (ParseException e){
            System.out.println(e.getStackTrace());  
        }
    }
    public Date getStart(){
    Date g = beginning;
    return g; 
    }
    
    public Date getDue(){
    
    Date g = end; 
    return g;
    }

    public int difference(){
    long diffTime = end.getTime() - beginning.getTime();
    long diffDay = (diffTime / (1000*60*60*24));
    int x = change(diffDay); 
    return x; 
    }
    
    public int change(long shit){
        int i = (int)shit;
        return i; 
    }
    
    public String converter(Date dt){
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
       String strDate = dateFormat.format(dt); 
    return strDate; 
    
    }
    public Date convertToDate(LocalDateTime dateToConvert) {
    return java.sql.Timestamp.valueOf(dateToConvert);
    }
    
    public String add(String in, int i) throws ParseException{
        SimpleDateFormat tttt= new SimpleDateFormat("dd/MM/yyyy"); 
       Calendar c = Calendar.getInstance(); 
       c.setTime(tttt.parse(in)); 
       c.add(Calendar.DATE, i); 
       in = tttt.format(c.getTime()); 
    return in; 
    }
    
    public void assortment() throws ParseException{
        
    int x = difference(); 
    String y, y1, y2, y3, y4; 
    if(x <= 2){
        y = add(converter(getDue()), -1 );
    }
    
    else if(x <= 3){ 
        y = add(converter(getStart()), 1); 
        y1 = add(converter(getDue()), -1 );
        this.study1 = y; 
        this.study2 = y1; 
        
    }
    else if(x <= 7){
    
        y = add(converter(getStart()), 3);
        y1 = add(converter(getDue()), -1 );
        this.study1 = y; 
        this.study2 = y1;

    }
    else if(x <= 14){
        y = add(converter(getStart()), 3);
        y1 = add(converter(getStart()), 7);
        y2 = add(converter(getDue()), -1 );

        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
    }
    else if(x <= 21){
        y = add(converter(getStart()), 4);
        y1 = add(converter(getStart()), 9);
        y2 = add(converter(getStart()), 15);
        y3 = add(converter(getDue()), -1 );

        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
    
    }
    else if(x <= 28){
        y = add(converter(getStart()), 7);
        y1 = add(converter(getStart()), 9);
        y2 = add(converter(getStart()), 15);
        y3 = add(converter(getDue()), -1 );

        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
        this.study4 = y3; 
    
    }
    else if(x <= 35){
        y = add(converter(getStart()), 9);
        y1 = add(converter(getStart()), 16);
        y2 = add(converter(getStart()), 23);
        y3 = add(converter(getStart()), 30);
        y4 = add(converter(getDue()), -1 );
        
        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
        this.study4 = y3;
        this.study5 = y4; 
    
    }
    else if(x <= 42){
        y = add(converter(getStart()), 16);
        y1 = add(converter(getStart()), 23);
        y2 = add(converter(getStart()), 30);
        y3 = add(converter(getStart()), 37);
        y4 = add(converter(getDue()), -1 );
        
        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
        this.study4 = y3;
        this.study5 = y4; 
    
    }
    else if(x <= 49){
        y = add(converter(getStart()), 23);
        y1 = add(converter(getStart()), 30);
        y2 = add(converter(getStart()), 37);
        y3 = add(converter(getStart()), 42);
        y4 = add(converter(getDue()), -1 );

        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
        this.study4 = y3;
        this.study5 = y4; 
    
    }
    
        
    else{
         y = add(converter(getDue()), -31 );
        y1 = add(converter(getDue()), -23 );
        y2 = add(converter(getDue()), -15 );
        y3 = add(converter(getDue()), -7 );
        y4 = add(converter(getDue()), -1 );
        this.study1 = y; 
        this.study2 = y1;
        this.study3 = y2; 
        this.study4 = y3;
        this.study5 = y4; 
    
        }
    } 

    
    
    
    
    
    
    
  
    
    public static void main(String [] arg) throws IOException{
       
       TimeHandler tt = new TimeHandler("02/09/2002","05/09/2002"); 
        try { 
            tt.assortment();
        } catch (ParseException ex) {
            Logger.getLogger(TimeHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(tt.study1+"       "+ tt.study2);
            
       
    }
}
    
    
    


    
    
    

