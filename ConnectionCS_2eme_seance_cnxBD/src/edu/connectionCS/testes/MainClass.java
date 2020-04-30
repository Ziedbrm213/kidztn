/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connectionCS.testes;

import edu.connectionCS.entities.Personne;
import edu.connectionCS.services.PersonneCRUD;
import edu.connectionCS.utiles.Myconnection;

/**
 *
 * @author zied
 */
public class MainClass {
    
    public static void main (String[]args) {
        Myconnection mc = new Myconnection();
        PersonneCRUD pc=new PersonneCRUD();
        //pc.AjouterPersonne();
        
        Personne p = new Personne(0, "Slim", "Berrima");
        pc.ajouterPersonne2(p);
    }
    
}
