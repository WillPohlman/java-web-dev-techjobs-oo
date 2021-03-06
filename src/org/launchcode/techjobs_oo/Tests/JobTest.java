package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest
{

    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertTrue(testJob2.getId()-testJob1.getId()==1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(allFields.getName() instanceof String);
        assertTrue(allFields.getEmployer() instanceof Employer);
        assertTrue(allFields.getLocation() instanceof Location);
        assertTrue(allFields.getPositionType() instanceof PositionType);
        assertTrue(allFields.getCoreCompetency() instanceof CoreCompetency);


        assertTrue(allFields.getName()=="Product tester");
        assertTrue(allFields.getEmployer().getValue()=="ACME");
        assertTrue(allFields.getLocation().getValue()=="Desert");
        assertTrue(allFields.getPositionType().getValue()=="Quality control");
        assertTrue(allFields.getCoreCompetency().getValue()=="Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job equalJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job equalJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(equalJob1.equals(equalJob2));
    }

    @Test
    public void testJobToStringMethod(){
        Job toStringJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        String expectedResult = "\nID: " + toStringJob.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Data not available\n";
        assertTrue(toStringJob.toString().equals(expectedResult));

        Job emptyJob = new Job();
        assertTrue(emptyJob.toString().equals("OOPS! This job does not seem to exist."));
    }
}
