/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.machrent;

import org.springframework.stereotype.Service;
import cz.muni.fi.pa165.machrent.entities.Rental;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Peter Benus
 */
@Service
public interface RentalService {

    /**
     * Method that returns {@code Rental} with specified {@code Long id}.
     * @param id to find
     * @return Rental object
     */
    public Rental findById(Long id);

    /**
     * Method that returns all {@code Rental} objects in database.
     * @return List of Rental objects.
     */
    public List<Rental> findAll();

    /**
     * Method that creates {@code Rental} in database.
     * @param r object to create
     * @return Created Rental object.
     */
    public Rental createRental(Rental r);

    /**
     * Method that remove {@code Rental} from database.
     * @param r object to delete
     */
    public void deleteRental(Rental r);

    
}
