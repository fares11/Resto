/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package resto.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import resto.entities.Restaurateur;
import resto.util.MyConnection;


/**
 *
 * @author Labidi
 */
public class RestaurateurDAO {

    public void ajouterRestaurateur(Restaurateur r){

        String requete = "insert into restaurateur () values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, r.getId_restaurateur_pk());
            ps.setString(2, r.getNom());
            ps.setString(3, r.getPrenom());
            ps.setDate(4, (Date) r.getDate_naissance());
            ps.setInt(5, r.getTel());
            ps.setString(6, r.getAdresse());
            ps.setString(7, r.getSexe());
            ps.setInt(8, r.getCin());
            ps.executeUpdate();
            System.out.println("Succès d'ajout");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }

    }

    public void updateDepot(Restaurateur r){
        String requete = "update restaurateur set nom,prenom,date_naissance,tel,adresse,sexe,cin=? where id_restaurateur_pk=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, r.getId_restaurateur_pk());
            ps.setString(2, r.getNom());
            ps.setString(3, r.getPrenom());
            ps.setDate(4, (Date) r.getDate_naissance());
            ps.setInt(5, r.getTel());
            ps.setString(6, r.getAdresse());
            ps.setString(7, r.getSexe());
            ps.setInt(8, r.getCin());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }


    public void deleteRestaurateur(int id){
        String requete = "delete from restaurateur where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Restaurateur supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Restaurateur findRestaurateurById(int id){
    Restaurateur res = new Restaurateur();
     String requete = "select * from restaurateur where id_restaurateur_pk=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                res.setId_restaurateur_pk(resultat.getInt(1));
                res.setAdresse(resultat.getString(2));
            }
            return res;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche d'un restaurateur "+ex.getMessage());
            return null;
        }
    }

    public Restaurateur findRestaurateurByAdresse(String adr){
    Restaurateur res = new Restaurateur();
     String requete = "select * from restaurateur where adresse= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, adr);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                res.setId_restaurateur_pk(resultat.getInt(1));
                System.out.println("Im here"+res.getId_restaurateur_pk());
                res.setAdresse(resultat.getString(2));
                System.out.println(resultat.getString(2));
            }
            return res;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche d'un restaurateur "+ex.getMessage());
            return null;
        }
    }


    public List<Restaurateur> DisplayAllRestaurateurs (){


        List<Restaurateur> listerestaurateur = new ArrayList<Restaurateur>();

        String requete = "select * from restaurateur";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Restaurateur res =new Restaurateur();
                res.setId_restaurateur_pk(resultat.getInt(1));
                res.setAdresse(resultat.getString(2));

                listerestaurateur.add(res);
            }
            return listerestaurateur;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des restaurateurs "+ex.getMessage());
            return null;
        }
    }




}
