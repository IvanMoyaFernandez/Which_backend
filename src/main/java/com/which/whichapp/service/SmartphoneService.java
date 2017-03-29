package com.which.whichapp.service;

import com.which.whichapp.domain.Smartphone;

import java.util.List;

/**
 * Service Interface for managing Smartphone.
 */
public interface SmartphoneService {

    /**
     * Save a smartphone.
     *
     * @param smartphone the entity to save
     * @return the persisted entity
     */
    Smartphone save(Smartphone smartphone);

    /**
     *  Get all the smartphones.
     *  
     *  @return the list of entities
     */
    List<Smartphone> findAll();

    /**
     *  Get the "id" smartphone.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Smartphone findOne(Long id);

    /**
     *  Delete the "id" smartphone.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
