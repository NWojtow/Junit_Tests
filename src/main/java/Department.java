import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private DepartmentType departmentType;
    private ArrayList<Person> personList;
    private int counter=0;


    public Department(String name, DepartmentType type){
        this.name=name;
        this.departmentType=type;
        this.personList=new ArrayList<Person>();

    }

    public void addPerson(Person temp){
        if(departmentType==DepartmentType.DEVELOPMENT){
            if(temp.getPosition()!=Position.CPP_DEVELOPER&&temp.getPosition()!=Position.JAVA_DEVELOPER){
                throw new WrongDepartment("Wrong department");
            }
        }
        if(departmentType==DepartmentType.MARKETING){
            if(temp.getPosition()!=Position.MARKETING_CONSULTANT&&temp.getPosition()!=Position.MARKETING_RESEARCH_SPECIALIST){
                throw new WrongDepartment("Wrong department");
            }
        }
        if(departmentType==DepartmentType.HR){
            if(temp.getPosition()!=Position.HR_ANALYST&&temp.getPosition()!=Position.TRAINING_MANAGER){
                throw new WrongDepartment("Wrong department");
            }
        }



        this.personList.add(temp);
        counter++;
    }

    public void changeDepartment(Person tempPerson, Department tempDepartment){

            if(tempDepartment.departmentType==DepartmentType.DEVELOPMENT){
                if(tempPerson.getPosition()!=Position.CPP_DEVELOPER&&tempPerson.getPosition()!=Position.JAVA_DEVELOPER){
                    throw new WrongDepartment("Wrong department");
                }
            }
            if(tempDepartment.departmentType==DepartmentType.MARKETING){
                if(tempPerson.getPosition()!=Position.MARKETING_CONSULTANT&&tempPerson.getPosition()!=Position.MARKETING_RESEARCH_SPECIALIST){
                    throw new WrongDepartment("Wrong department");
                }
            }
            if(tempDepartment.departmentType==DepartmentType.HR){
                if(tempPerson.getPosition()!=Position.HR_ANALYST&&tempPerson.getPosition()!=Position.TRAINING_MANAGER){
                    throw new WrongDepartment("Wrong department");
                }
        }
        for(int i=0;i<this.personList.size();i++){
            if(this.personList.get(i).getPesel()== tempPerson.getPesel()){
                Person temp = this.personList.get(i);
                tempDepartment.addPerson(temp);
                this.personList.remove(i);
                this.counter--;
            }
        }

    }


    public void removePerson(Person temp){
        for(int i=0;i<personList.size();i++){
            if(this.personList.get(i).getPesel()==temp.getPesel()){
                this.personList.remove(i);
            }
        }
        this.counter--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public  int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return this.name+" "+this.departmentType;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Department place = (Department) obj;
        return (place.name == this.name && place.departmentType == this.departmentType && place.personList == this.personList);
    }


}

