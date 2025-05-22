/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.vue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ClientDao;
import dao.JpaUtil;
import java.io.PrintWriter;
import metier.modele.Client;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igzanguengu
 */
public class ListeClientsSerialisation extends Serialisation {

    public ListeClientsSerialisation() {
    }
    
    

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        
        List<Client> maListeClient = (List<Client>) request.getAttribute("maListeClients");
        
        String mySerialisedJson = gson.toJson(maListeClient);
        
        System.out.println("Serialisation...................");
        System.out.println(mySerialisedJson);
        
        
        System.out.println("\nSERIALISATION 2.0 .......................................................................................");
        
        JsonArray maListeClientSerialised = new JsonArray();
        
        for (Client c:maListeClient) {
            JsonObject monClientSerialised = new JsonObject();
            
            monClientSerialised.addProperty("id", c.getId());
            monClientSerialised.addProperty("nom", c.getNom());
            monClientSerialised.addProperty("prenom", c.getPrenom());
            monClientSerialised.addProperty("email", c.getEmail());
            
            maListeClientSerialised.add(monClientSerialised);
        }
        
        String mySerialisedJson2 = gson.toJson(maListeClientSerialised);
        
        System.out.println(maListeClientSerialised);
        
        response.setContentType("application/json;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            out.println(mySerialisedJson2);
        }
    }
    
    
    
}
