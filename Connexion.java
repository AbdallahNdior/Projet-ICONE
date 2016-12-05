package testmongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connexion {
    
    private DB db;
    
    public Connexion()
    {
         // Connexion a la base de donnee
        MongoClient mongoClient = null;
       
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException ex) {
            Logger.getLogger(TestMongodb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        db = mongoClient.getDB( "testbd" ); // Declaration de la base donnée
        
        // Fin connexion        
    }
    
    
     // Medthode de récupération des données d'une collection
    public List<DBObject> selection(String name_collection)
    {
        DBCollection collection = db.getCollection(name_collection); 
        List<DBObject> lst= collection.find().toArray(); // Stocker toutes les resultats dans une liste
        return lst; // retourne une liste d'enregistrement de la collection indiquée
    }
    
    // Methode "insertion" prend en paramètre la collection et l'objet document a inseré
    public void insertion(String name_collection,DBObject docObject)
    {
        DBCollection collection = db.getCollection(name_collection); 
        collection.insert(docObject);
        System.out.println("Insertion reuissi !");
    }
    
    //  Methode "update"
    
   
    
    
    
    
}
