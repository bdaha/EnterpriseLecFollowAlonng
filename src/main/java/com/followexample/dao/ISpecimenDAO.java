package com.followexample.dao;

import com.followexample.dto.Specimen;

import java.util.List;

public interface ISpecimenDAO {
    Specimen save(Specimen specimen) throws Exception;

    List<Specimen> fetchAll();

    Specimen fetch(int id);

    void delete(int id);
}
