package com.followexample.service;

import com.followexample.dto.Specimen;

import java.util.List;

public interface ISpecimenService {
    void delete(int id) throws Exception;

    /**
     * Fetch a specimen with a given ID.
     * @param id a unique Identifier for a specimen.
     * @return the matching specimen, or null if no matches found.
     */
    Specimen fetchById(int id);

    Specimen save(Specimen specimen) throws Exception;

    List<Specimen> fetchAll();
}
