/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connectionCS.services;

import edu.connectionCS.entities.Personne;
import edu.connectionCS.utiles.Myconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author zied
 */
public class PersonneCRUD {
    Connection cnx;

    public PersonneCRUD() {
    
    cnx = new Myconnection().getCnx(); // l'appel mta l constructeur bch yaaml appel l get cnx li f classe Myconnection li destiné bch naamlou biha cnx m3al BD
    }
    public void AjouterPersonne(){      //id est est declaré comme auto increment dans la BD donc on a pas besoin de le mettre dans la req Insertion
        try { 
        String rq="insert into personne (nom,prénom) VALUES ('berrima','zied')";
      
       
            //Statement howa l bostaji li bch ywasel req lel BD
            Statement st= cnx.createStatement(); // statement rahi tnjm taaml exception ( ma te5demch )  donc nhotouha bin try w catch
            st.executeUpdate(rq); // pour executer la req
            System.out.println("req tba3thet");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion");
            System.err.println(ex.getMessage());
        }
                
                
    }
    
    public void ajouterPersonne2(Personne p){
      try {  
       //  String req2="insert into personne"+" values ('"+p.getNom()+"','"+p.getPrenom()+"')"; // + bin personne w values juste 9asamt req 3la thnin bch ki nhot les " wl ' ma tod5olch baaadhha ==> dima hethi req ki bch n'inseriw element f BD mn classe f java 
 
    // Sinon 7al e5er bch ma noghlotch fl les " wel ' w syntaxe hethika nwali ne5dem d'une autre façon 
    String req2="insert into personne(nom,prénom) VALUES (?,?)";
    
        
            // fi blaset create statement naaml prepare statement : req dynamique 
            PreparedStatement pst = cnx.prepareStatement(req2);
            pst.setString(1, p.getNom()); // paramtre 1  li howa nom et setString car le nom est une chaine , ken je 3ana entier naamlou setInt
            pst.setString(2, p.getPrenom()); // prametre 2 li howa prenom
            pst.executeUpdate();
            System.out.println(" req type 2 tba3thet");
        } catch (SQLException ex) {
            System.out.println(" ma tba3thetch req type 2 ");
            System.err.println(ex.getMessage());
        }
    }
   
    
    public void supp_personne( int id ) {
        try {
        String req="DELETE FROM personne where id=?";
        
            PreparedStatement pst=cnx.prepareStatement(req);
            
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("personne supprimé");
        } catch (SQLException ex) {
            System.out.println("probleme de supression");
            System.err.println(ex.getMessage());
        }
    }
    
    public void update_pers ( Personne p, int id) { //modifier la personne avec l'id pass en parametres
         try {
        String req ="UPDATE personne SET nom=?,prenom=?"+"WHERE id=?";
       
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setInt(3,id);
            pst.executeUpdate();
            System.out.println("personne modifié");
        } catch (SQLException ex) {
            System.out.println("probleme de modification");
            System.err.println(ex.getMessage());
        }
    }
    
   public List <Personne>  affichage(){
      List<Personne> LP=new ArrayList<>();
       try {
       String req="SELECT * FROM personne";
       Statement st= cnx.createStatement();
    
            ResultSet rs = st.executeQuery(req); // rs heya l 9offa li bch nhotou fiha les elements
            while(rs.next()) {
                Personne p = new Personne();
                p.setId(rs.getInt(1)); // 1 pour dire la premiere colone li f table  elli heya l'id
                p.setNom(rs.getString(2)); //2 pour dire  la deuxueme colone li f table li heya nom 
                p.setPrenom(rs.getString("prénom")); // najmou zeda n3aytou l champs mta table bl esm mch b numero kima li fou9ha
            LP.add(p);
            // au niveau classe main 
            // on fait PersonneCRUD pc =new PersonneCRUD();
            //System.out.println (pc.affichage());
            
            }
            System.out.print("voici la BD ");
        } catch (SQLException ex) {
            System.out.println("probleme d'affichage");
            System.err.print(ex.getMessage());
        }
   return LP;
   }
}
