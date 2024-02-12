
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpsit.server;
import java.io*;
import.java.net*;
import java.util*;
/**
 *
 * @author Studente
 */
public class ServerStr 
{
    ServerSocket server = null; 
    Socket client = null; 
    String stringaRicevuta= null;
    String stringaModificata= null;
    BufferedReader inDalClient; 
    DataOutputStream outVersoClient; 
    
    public Socket attendi ()
    {
        try 
        {
            System.out.println ("1 SERVER partito in esecuzione...");
            //creo un server sulla porta 6789
            server = new ServerSocket (6789);
            // rimane in attesa di un client
            client= server.accept ();
            //chiudo il server per iniziare altri client 
            server.close (); 
            //associo due oggetti al socket del client per effettuare la scrittura e la lettura
            inDalClient= new BufferedReader (new InputStreamReader (client.getInputStream()));
            outVersoClient= new DataOutputStream (client.getOutputStream());
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
            System.out.println ("Errore durante l'istanza del server !");
            System.exit (1);
        }
        return client ;
    }
}
public void comunica ()
{
try {
//rimango in attesa della riga trasmessa dal client
System.out.println ("3 benvenuto il client, scrivi una frase e la traformo in maiuscolo. Attendo...");
stringaRicevuta= inDalClient.readLine ();
System.out.println ("6 ricevuta la stringa dal cliente:" +stringsRicevuta);
//la modifico e la rispedisco al client
stringaModificata= stringaRicevuta.toUpperCase ();
System.out.println ("7 invio la strings modificata al client ...");
outVersoClient.writeBytes (stringaMoficata+ '\n');
//termina elaborazione sul server: chiudo la connessione dal client
System.out.println ("9 SERVER: fine elaborazione... buona notte!");
client.close ();
}
}

public class TpsitServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
