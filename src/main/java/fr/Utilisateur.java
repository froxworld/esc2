package fr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Utilisateur {

    Logger logger = LoggerFactory.getLogger(Utilisateur.class);

    // a chaque fois qu'on mettra un persist on va faire un log
    @PrePersist
    public void logDebut(){
        logger.info("creation de l'utilisateur en cours " + this.nom);
    }

    @PostPersist
    public void logFin(){
        logger.info("creation faite de " + this.nom);
    }

    Long Id;
    String nom;
    String prenom;
    Date date_de_naissance;

    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
    @Basic
    @Temporal(value = TemporalType.DATE)
    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "Id=" + Id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_de_naissance=" + date_de_naissance +
                '}';
    }
}
