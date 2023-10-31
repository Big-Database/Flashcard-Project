/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project101;
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*; 
/**
 *
 * @author timomichaelis
 */
public class Read_write {
    
    private String path; 
    private Boolean old;
    Scanner x; 
    LinkedList <String> list = new <String>LinkedList();
    LinkedList <String> tList = new <String>LinkedList(); 
    
    public Read_write(String location, Boolean exist){
    path = location; 
    old = exist; 
    }
    
    
    public String[] OpenFile() throws IOException{
    
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        
        int nlines = readlines(); 
        String [] textcontent = new String[nlines]; 
        
        for(int i = 0; i < nlines; i++){
        textcontent [i] = textReader.readLine(); 
        }
        textReader.close(); 
        return textcontent; 
    }
    
    public int readlines() throws IOException { 
        FileReader file_to_read = new FileReader(path); 
        BufferedReader bf = new BufferedReader(file_to_read); 
        
        String aline; 
        int numberofLines = 0; 
        
        while((aline = bf.readLine()) != null){
            numberofLines++; 
        }
        bf.close();    
    return numberofLines; 
    }
    
    public void writeLine(String text) throws IOException{
        FileWriter fw = new FileWriter(path, old);
        PrintWriter print = new PrintWriter(fw); 
        
        print.printf("%s"+"%n", text); 
        print.close(); 
    }
    public void readtimeTable() throws IOException{
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int n = 0;
    while ((row = csvReader.readLine()) != null) {
        String[] data = row.split("//");
        tList.add(data[n]);
        tList.add(data[n+1]);
        tList.add(data[n+2]);
        tList.add(data[n+3]);
        tList.add(data[n+4]);
        tList.add(data[n+5]);
        tList.add(data[n+6]);
        tList.add(data[n+7]);
    }
        csvReader.close();
    
    
    }
    
    public void getScoreNDates() throws FileNotFoundException, IOException{
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int n = 0;
    while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        list.add(data[n]);
        list.add(data[n+1]);
    }
        csvReader.close();
   
    }
    public void readScoreDate() throws FileNotFoundException, IOException{
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int n = 0;
    while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        list.add(data[n]);
        list.add(data[n+1]);
 
    // do something with the data
    }
        csvReader.close();
    }
    
    public void readCSV() throws FileNotFoundException, IOException{
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int n = 0;
    while ((row = csvReader.readLine()) != null) {
        String[] data = row.split("//");
        list.add(data[n]);
        list.add(data[n+1]);
        list.add(data[n+2]);
        list.add(data[n+3]); 
    // do something with the data
    }
        csvReader.close();
       /* 
        for(int i =0; i < list.size(); i++){
        if(i%4 == 0){
            System.out.println(); 
        }
        System.out.print("//" + list.get(i));
        } */ 
       
    /*
    File pd = new File(path); 
    String s = ""; 
    
    try{
    
        pd.createNewFile(); 
        FileReader fr = new FileReader(pd); 
        BufferedReader buffer = new BufferedReader(fr); 
        
        while((s = buffer.readLine()) != null){
        
            //String content = s.split(",")[0]); 
        }
        }catch(IOException e){
                
                System.out.print(e); 
                
                }
        return null; */
    
    }
    public void findCSV(String searchTerm){
        String que, ans, ht, diff;
        Boolean found = false; 
        try{
            x = new Scanner(new File(path)); 
            x.useDelimiter("[//\n");
            
            while(x.hasNext() && !found){
            que = x.next(); 
            ans = x.next();
            ht = x.next();
            diff = x.next(); 
            if(que.equals(searchTerm)){
            
                found = true; 
            } 
            
            if (found == true){
                
                System.out.print(que+ans+ht+diff);
            } 
            }
        }catch(IOException e){
        System.out.print(e.getMessage());
        }
        
    }
    
    //public CardObj smh(String path){
    //    CardObj co = new CardObj
    
   // return CardObj; 
   // }
    
    


    
    
    
    
    
    public static void main(String [] args) throws IOException {
    
     
       
    /*
        try{
            ll.writeLine("something 1"); 
            
             
            String [] arrayline = ll.OpenFile(); 
            
            for(int i = 0; i < arrayline.length; i++){
                System.out.println(arrayline[i]);
            }
        }catch(IOException t){
        
        System.out.println(t.getMessage());
        
        
        
        }
    
        */
    }
}
