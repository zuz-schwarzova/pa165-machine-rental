/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.machrent.dao;

import cz.muni.fi.pa165.machrent.entities.Rent;
import java.util.List;

/**
 *
 * @author Peter Benus
 */
public interface RentDao {
    
    /**
     * Save created rent entity given by parameter into database.
     * 
     * @throws IllegalArgumentException when parameter is null
     * 
     * @param r rent to create
     */
    public void create(Rent r);

    /**
     * Remove given rent from database.
     * 
     * @throws IllegalArgumentException when parameter is null
     * 
     * @param r rent to delete
     */
    public void delete(Rent r); 

    /**
     * Update entry in database with new values given by rent entity in parameter.
     * 
     * @throws IllegalArgumentException when parameter is null
     * 
     * @param r rent to update
     */
    public void update(Rent r); 

    /**
     * Find rent with given ID in database.
     * 
     * @throws IllegalArgumentException when parameter is null
     * 
     * @param id ID to find
     * @return rent with given ID
     */
    public Rent findById (Long id);

    /**
     * Select all rents saved in database.
     * 
     * @return List of Rent entities.
     */
    public List<Rent> findAll(); 
}
