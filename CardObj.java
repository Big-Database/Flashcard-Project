package project101;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author timomichaelis
 */
public class CardObj {
    
    public String path, question, answer, hint, rating;
    LinkedList <CardObj> cardList = new LinkedList<CardObj>();
    
    public CardObj(String path){
        this.path = "/Users/timomichaelis/Desktop/NewFolder.1/Files/Folder/" + path + "/FlashCards.txt";
    }
    
    public CardObj(String question, String answer, String hint, String rating){
        this.answer = answer;
        this.question = question; 
        this.hint = hint; 
        this.rating = rating; 
    }
    
    
    public void createList() throws IOException{
        
        Read_write rw = new Read_write(path, true); 
        rw.readCSV();
       
            CardObj cd; 
            
            for(int i = 0; i < rw.list.size();){  
                cd = new CardObj
                       (rw.list.get(i),
                        rw.list.get(i+1),
                        rw.list.get(i+2), 
                        rw.list.get(i+3));
                i = i+4; 
                cardList.add(cd);
               
            }
        
        }
    
    public void updateNsaveRate(String question, int difficulty) throws IOException{
        int pos = 0;
        Read_write rw2 = new Read_write(path, true); 
        rw2.readCSV();
        
        Read_write rw = new Read_write(path, false); 
        rw.readCSV();
        
        for(int ii = 0; ii < rw2.list.size();ii++){
            if (question.equals(rw.list.get(ii))){
                pos = ii+3; 
                System.out.print(rw2.list.get(1));
                System.out.println("the loop has been broken");
                break;
            }else{System.out.print(" no,");}
        }

        String g = Integer.toString(difficulty);
        if(pos == 3){
            rw.writeLine(rw.list.get(0)+"//"+ rw.list.get(1) +"//"+ rw.list.get(2)+"//"+ g);
        }
        else{
            rw.writeLine(rw.list.get(0)+"//"+ rw.list.get(1) +"//"+ rw.list.get(2)+"//"+rw.list.get(3));
        }
        
        rw2.list.set(pos, g); 
        System.out.println("?????????????"+rw2.list.get(pos)+"!!!!!!!!!"); 
        
        for(int i = 4; i < rw.list.size();){
           System.out.println("rewriting: " + i/4);
        rw2.writeLine(rw.list.get(i) +"//"+ rw2.list.get(i+1) +"//"+rw2.list.get(i+2)+"//"+rw2.list.get(i+3));
        i = i+4;
        }
    }
    
    
    public void updateNsaveCard(String question, String newQuestion, String answer, String hint){
        Read_write rw = new Read_write(path, false);
        Read_write rw2 = new Read_write(path, true);
        
        try {
            rw.readCSV();
            rw2.readCSV(); 
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        
        for(int i = 0; i < rw.list.size(); i++){
            if(question.equals(rw.list.get(i))){
                
                rw2.list.set(i, newQuestion); 
                rw2.list.set(i+1, answer); 
                rw2.list.set(i+2, hint); 
                rw2.list.set(i+3, "1"); 
            }
        }
        
        try {
            rw.writeLine(rw2.list.get(0) +"//"+rw2.list.get(1)+"//"+rw2.list.get(2)+"//"+rw2.list.get(3));
        } catch (IOException ex) {
            Logger.getLogger(CardObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 4; i < rw2.list.size();){
            try {
                rw2.writeLine(rw2.list.get(i) + "//"+rw2.list.get(i+1)+"//"+rw2.list.get(i+2)+"//"+rw2.list.get(i+3));
            } catch (IOException ex) {
                System.out.print("adding on problem");
            }
            i = i+4; 
        }
    }
}
    
    
    
    
    
    
    
    
    

