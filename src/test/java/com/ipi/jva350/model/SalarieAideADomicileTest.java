package com.ipi.jva350.model;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class SalarieAideADomicileTest {
    @Test
    public void testALegalementDroitADesCongesPayesTrue(){
    SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
    //Given
       salarieAideADomicile.setJoursTravaillesAnneeNMoins1(10);
    //When
        Boolean pasAssezDeJoursPourAvoirDroitAuCongesPayes = salarieAideADomicile.aLegalementDroitADesCongesPayes();
    //Then
        Assertions.assertEquals(true, pasAssezDeJoursPourAvoirDroitAuCongesPayes, "Le nombre minimum de jours est de 10");
    }
    @Test
    public void testALegalementDroitADesCongesPayesFalse(){
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        //Given
        salarieAideADomicile.setJoursTravaillesAnneeNMoins1(9);
        //When
        Boolean pasAssezDeJoursPourAvoirDroitAuCongesPayes = salarieAideADomicile.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false, pasAssezDeJoursPourAvoirDroitAuCongesPayes, "Le nombre minimum de jours est de 10");
    }



    @Test
    public void testEstHabituellementTravailleTrue(){
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
    //Given
    LocalDate jour = LocalDate.of(2024,10,23);
    //When
    Boolean estCeUnJourTravaille = salarieAideADomicile.estHabituellementTravaille(jour);
    //Then
    Assertions.assertEquals(true, estCeUnJourTravaille);
    }

    @Test
    public void testEstHabituellementTravailleFalse(){
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
        //Given
        LocalDate jour = LocalDate.of(2024,10,5);
        //When
        Boolean estCeUnJourTravaille = salarieAideADomicile.estHabituellementTravaille(jour);
        //Then
        Assertions.assertEquals(false, estCeUnJourTravaille,"le 5 oct est un samedi, il n'est pas habituellement travaillé");
    }
    @Test
    public void testcalculeJoursDeCongeDecomptesPourPlage(){
    SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile();
    //Given
        LocalDate dateDebut = LocalDate.of(2024,5,6);

        LocalDate dateFin = LocalDate.of(2024,5,14);
    //When
        LinkedHashSet<LocalDate> nbDeJourPris = salarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage(dateDebut,dateFin);
    //Then
        Assertions.assertEquals(6, nbDeJourPris.size(), "le nombre de jours doit être de 6");
    }


}

