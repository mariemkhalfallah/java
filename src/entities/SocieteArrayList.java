package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {
    private ArrayList<Employe> listeEmployes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        listeEmployes.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : listeEmployes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return listeEmployes.contains(e);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        listeEmployes.remove(e);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : listeEmployes) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(listeEmployes, Comparator.comparingInt(Employe::getId));
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        listeEmployes.sort(Comparator
                .comparing(Employe::getNomDepartement)
                .thenComparingInt(Employe::getGrade));
    }
}
