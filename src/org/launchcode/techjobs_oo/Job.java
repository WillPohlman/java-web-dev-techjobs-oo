package org.launchcode.techjobs_oo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Done: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency)
    {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString(){
        if(name==null&&employer==null&&location==null&&positionType==null&&coreCompetency==null){
            return "OOPS! This job does not seem to exist.";
        }else
        {
            LinkedHashMap<String, Object> fields = new LinkedHashMap<>();
            fields.put("Name: ", name);
            fields.put("Employer: ", employer);
            fields.put("Location: ", location);
            fields.put("Position Type: ", positionType);
            fields.put("Core Competency: ", coreCompetency);

            String result = "\nID: ";
            result += id;
            for (Map.Entry<String, Object> field : fields.entrySet())
            {
                result += "\n" + field.getKey();
                if(field.getValue().toString().equals("")){
                    result += "Data not available";
                }else{
                    result += field.getValue();
                }
            }
            result += "\n";
            return result;
        }
    }

    // Done: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId());
    }


    // Done: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Employer getEmployer()
    {
        return employer;
    }

    public void setEmployer(Employer employer)
    {
        this.employer = employer;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public PositionType getPositionType()
    {
        return positionType;
    }

    public void setPositionType(PositionType positionType)
    {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency()
    {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency)
    {
        this.coreCompetency = coreCompetency;
    }
}
