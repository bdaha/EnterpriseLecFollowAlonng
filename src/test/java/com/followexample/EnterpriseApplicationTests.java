package com.followexample;

import com.followexample.dao.ISpecimenDAO;
import com.followexample.dto.Specimen;
import com.followexample.service.ISpecimenService;
import com.followexample.service.SpecimenServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EnterpriseApplicationTests {


    private ISpecimenService specimenService;
    private Specimen specimen = new Specimen();

    @MockBean
    private ISpecimenDAO specimenDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchSpecimenByID_returnsRedbudforID83() throws Exception {
        givenSpecimenDataAreAvailable();
        whenSpecimen83AddedIsRedbud();
        whenSearchSpecimenWithID83();
        thenReturnOneEasternRedbudSpecimenForID83();
    }

    private void whenSpecimen83AddedIsRedbud() {
        Specimen redbud = new Specimen();
        redbud.setSpecimenId("83");
        redbud.setDescription("Eastern Redbud");
        Mockito.when(specimenDAO.fetch(83)).thenReturn(redbud);
    }

    private void givenSpecimenDataAreAvailable() throws Exception{
        Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
        specimenService = new SpecimenServiceStub(specimenDAO);
    }

    private void whenSearchSpecimenWithID83() throws Exception {
        specimen = specimenService.fetchById(83);
    }

    private void thenReturnOneEasternRedbudSpecimenForID83() throws Exception{
        String description = specimen.getDescription();
        assertEquals("Eastern Redbud", description);
    }

    @Test
    void saveSpecimen_validateReturnSpecimenWithLatitudeAndLongitude() throws Exception{
        givenSpecimenDataAreAvailable();
        whenUserCreatesANewSpecimenAndSaves();
        thenCreateNewSpecimenRecordAndReturnIt();
    }


    private void whenUserCreatesANewSpecimenAndSaves() {
        specimen.setLatitude("39.74");
        specimen.setLongitude("-84.51");
    }

    private void thenCreateNewSpecimenRecordAndReturnIt() throws Exception{
        Specimen createdSpecimen = specimenService.save(specimen);
        assertEquals(specimen, createdSpecimen);
        verify(specimenDAO, atLeastOnce()).save(specimen);
    }
}
