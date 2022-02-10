package com.followexample.service;

import com.followexample.dao.ISpecimenDAO;
import com.followexample.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecimenServiceStub implements ISpecimenService{

    @Autowired
    private ISpecimenDAO specimenDAO;

    public SpecimenServiceStub() {

    }

    public SpecimenServiceStub(ISpecimenDAO specimenDAO) {

        this.specimenDAO = specimenDAO;
    }

    @Override
    public void delete(int id) throws Exception{
        specimenDAO.delete(id);
    }

    @Override
    public Specimen fetchById(int id) {
        Specimen foundSpecimen = specimenDAO.fetch(id);
        return foundSpecimen;
    }

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        return specimenDAO.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return specimenDAO.fetchAll();
    }
}
