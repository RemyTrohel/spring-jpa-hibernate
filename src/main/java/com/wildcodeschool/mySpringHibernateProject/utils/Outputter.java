package com.wildcodeschool.mySpringHibernateProject.utils;

import com.wildcodeschool.mySpringHibernateProject.entities.Wilder;
import com.wildcodeschool.mySpringHibernateProject.repositories.WilderDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");
    
    @Autowired
    private WilderDao wilderDao;

    @Override
    public void run(String... args) throws Exception {

        LOG.info("----------- COUNT OBJECTS -----------");
        LOG.info("Objects in DB : " + wilderDao.count());

        LOG.info("----------- INSERT FIRST -----------");
        Wilder wilder1 = new Wilder("Rémy", "Trohel", 28);
        LOG.info(wilder1 + " has been created ! ");
        wilderDao.save(wilder1);
        LOG.info(wilder1 + " has been saved !");

        LOG.info("----------- INSERT SECOND -----------");
        Wilder wilder2 = new Wilder("James", "Bond", 40);
        LOG.info(wilder2 + " has been created ! ");
        wilderDao.save(wilder2);
        LOG.info(wilder2 + " has been saved !");
        
        LOG.info("----------- READ ONE -----------");
        Wilder tempWilder = wilderDao.findById(1).get();
        LOG.info("First name = " + tempWilder.getFirstName());
        LOG.info("Last name = " + tempWilder.getLastName());
        LOG.info("Age = " + tempWilder.getAge());

        LOG.info("----------- UPDATE FIRST -----------");
        tempWilder.setAge(30);
        wilderDao.save(tempWilder);
        LOG.info(tempWilder + " has been updated !");

        LOG.info("----------- READ ALL -----------");
        LOG.info("Wilders in list are ");
        for(Wilder myWilder : wilderDao.findAll()) {
            LOG.info(myWilder.toString());
        };

        LOG.info("----------- DELETE SECOND -----------");
        wilderDao.deleteById(2);
        LOG.info("Wilders in list are ");
        for(Wilder myWilder : wilderDao.findAll()) {
            LOG.info(myWilder.toString());
        };

        LOG.info("----------- READ ALL -----------");
        LOG.info("Wilders in list are ");
        for(Wilder myWilder : wilderDao.findAll()) {
            LOG.info(myWilder.toString());
        };
    }
}