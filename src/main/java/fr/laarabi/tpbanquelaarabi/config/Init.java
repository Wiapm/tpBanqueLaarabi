/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.laarabi.tpbanquelaarabi.config;

import fr.laarabi.tpbanquelaarabi.entities.CompteBancaire;
import fr.laarabi.tpbanquelaarabi.service.GestionnaireCompte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class Init {

    @Inject
    private GestionnaireCompte gc;

    @Transactional
    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        if (gc.nbComptes() == 0) {
            gc.creerCompte(new CompteBancaire("John Lennon", 150000));
            gc.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gc.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gc.creerCompte(new CompteBancaire("Georges Harrison", 100000));
        }
    }
}
