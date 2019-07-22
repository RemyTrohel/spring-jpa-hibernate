package com.wildcodeschool.mySpringHibernateProject.repositories;

import com.wildcodeschool.mySpringHibernateProject.entities.Wilder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WilderDao extends JpaRepository<Wilder, Integer> {
}