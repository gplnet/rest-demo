package com.avalith.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avalith.model.Tecnologia;

@Repository
public interface ITecnologiaDAO extends JpaRepository<Tecnologia, Integer> {

}
