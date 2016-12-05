/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmongodb;

import com.mongodb.DBObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestMongodb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String chaine="";
        String fichier ="fichier.json";
       
      //lecture du fichier texte
     try{
         InputStream ips=new FileInputStream(fichier);
         InputStreamReader ipsr=new InputStreamReader(ips);
         BufferedReader br=new BufferedReader(ipsr);
         String ligne;
         while ((ligne=br.readLine())!=null){
            //System.out.println(ligne);
            chaine+=ligne+"\n";
         }
         br.close();
      }    
      catch (Exception e){
         System.out.println(e.toString());
      }
        
        Object o = com.mongodb.util.JSON.parse(chaine);
        DBObject dbObj = (DBObject) o;
        
        //System.out.println(dbObj.keySet());
        
        Connexion conn =new Connexion();
        
       for(int i=1; i<=dbObj.keySet().size(); i++)
       {
           // Insertion
            conn.insertion("utilisateur", (DBObject) dbObj.get("info"+i));
           
       }
       
        
        
        
        // Affichage
        System.out.println(conn.selection("utilisateur"));

        
        
        
        
      
 
       // System.out.println(dbObj.get("info1"));

       
    }
        
}
