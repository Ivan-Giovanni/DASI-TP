/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.service;
import dao.ClientDao;
import dao.JpaUtil;
import metier.modele.Client;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igzanguengu
 */
public class Service {
    
    
    public boolean inscrireClient(Client client) {
        System.out.println("Inscription du client...");
        
        ClientDao clientDao = new ClientDao();
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            clientDao.create(client);
            JpaUtil.validerTransaction();
            
            return true;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            JpaUtil.annulerTransaction();
            client = null;
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return false;
    }
    
    
    public List<Client> listerClients() {
        System.out.println("Affichage de la liste des clients...");
        
        ClientDao clientDao = new ClientDao();
        List<Client> maListeClient;
        
        try {
           JpaUtil.creerContextePersistance();
           JpaUtil.ouvrirTransaction();
           maListeClient = clientDao.findAll();
           JpaUtil.validerTransaction();
           
           return maListeClient;
           
        }
        catch(Exception ex){
            ex.printStackTrace();
            JpaUtil.annulerTransaction();
        }
            finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return new ArrayList<Client>();
    }
}
