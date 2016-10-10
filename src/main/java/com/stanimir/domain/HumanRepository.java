/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Stanimir Donchev
 */

public interface HumanRepository extends CrudRepository<Human, Long>
{
    @Query("select u from Human u order by lastName")
    List<Human> sortByLastName();
    
    @Query("select u from Human u order by dob")
    List<Human> sortByDob();
}
