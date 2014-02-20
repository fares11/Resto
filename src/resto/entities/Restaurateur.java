/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package resto.entities;

import java.util.Date;

/**
 *
 * @author Labidi
 */
public class Restaurateur {

  private int id_restaurateur_pk;
  private String nom;
  private String prenom;
  private Date date_naissance;
  private int tel;
  private String adresse;
  private String sexe;
  private int cin;

    public Restaurateur() {
    }

    public Restaurateur(int id_restaurateur_pk, String nom, String prenom, Date date_naissance, int tel, String adresse, String sexe, int cin) {
        this.id_restaurateur_pk = id_restaurateur_pk;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.tel = tel;
        this.adresse = adresse;
        this.sexe = sexe;
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getId_restaurateur_pk() {
        return id_restaurateur_pk;
    }

    public void setId_restaurateur_pk(int id_restaurateur_pk) {
        this.id_restaurateur_pk = id_restaurateur_pk;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Restaurateur{" + "id_restaurateur_pk=" + id_restaurateur_pk + "nom=" + nom + "prenom=" + prenom + "date_naissance=" + date_naissance + "tel=" + tel + "adresse=" + adresse + "sexe=" + sexe + "cin=" + cin + '}';
    }




}
