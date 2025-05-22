/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.modele;
import static console.Main.printlnConsoleIHM;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author igzanguengu
 */
public class ConsulterListeClientsAction extends Action {

    public ConsulterListeClientsAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Client> clients = this.service.listerClients();
        
        request.setAttribute("maListeClients", clients);

        if (clients == null) {
            System.out.println("ERREUR du Service listerClients");
        } else {
            System.out.println("Liste des Clients (" + clients.size() + ")");
            for (Client c : clients) {
                System.out.println("#" + c.getId() + " " + c.getNom().toUpperCase() + " " + c.getPrenom());
            }
            System.out.println("----");
        }
    }}
    
    
    
