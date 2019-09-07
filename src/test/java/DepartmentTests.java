import org.junit.Test;
import java.util.Date;



public class DepartmentTests {

    @Test
    public void addWorkerGood(){
        Department temp = new Department("DevDep",DepartmentType.DEVELOPMENT);
        Person dev = new Person("Jan","Kowalski",new Date(),"98071903290",Position.CPP_DEVELOPER);
        temp.addPerson(dev);
        temp.getPersonList().get(0).toString();

    }

    @Test (expected = WrongDepartment.class)
    public void AddToWrongDepartmentException(){
        Department temp = new Department("HumanResources",DepartmentType.HR);
        Person dev = new Person("Jan","Kowalski",new Date(),"98071903290",Position.CPP_DEVELOPER);

        temp.addPerson(dev);

    }

    @Test
    public void workerTransferToAnotherDepartmentSameType(){
        Department temp = new Department("HumanResources",DepartmentType.HR);
        Person dev = new Person("Jan","Kowalski",new Date(),"98071903290",Position.HR_ANALYST);
        temp.addPerson(dev);
        Department temp2 = new Department("HumanResources2",DepartmentType.HR);

        temp.changeDepartment(dev, temp2);
//        temp.getPersonList().get(0).getName();

        temp2.getPersonList().get(0).getName();

    }

    @Test(expected = WrongDepartment.class)
    public void workerTransferToDepartmentOfAnotherType(){
        Department temp = new Department("HumanResources",DepartmentType.HR);
        Person dev = new Person("Jan","Kowalski",new Date(),"98071903290",Position.HR_ANALYST);
        temp.addPerson(dev);

        Department temp2 = new Department("Development",DepartmentType.DEVELOPMENT);
        temp.changeDepartment(dev,temp2);

    }
}
