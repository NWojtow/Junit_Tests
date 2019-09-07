import org.junit.Test;
import static org.junit.Assert.assertTrue;



public class CompanyTests {
    @Test
    public void ifCounterDoesntChange(){
        Company temp = new Company();
        Localisation tempLocalisation1 = new Localisation("Local1", "Kraków");
        Localisation templocalisation2 = new Localisation("Local2","Warsaw");
        Department tempDepartment = new Department("Dep1",DepartmentType.DEVELOPMENT);
//        Department tempDepartment2 = new Department("Dep2", DepartmentType.DEVELOPMENT);


        tempLocalisation1.addDepartment(tempDepartment);
        temp.addLocalisation(tempLocalisation1);
        temp.addLocalisation(templocalisation2);

        int buff1 = temp.getCounter();

        tempLocalisation1.changeLocalisation(tempDepartment,templocalisation2);
        int buff2 = temp.getCounter();


        boolean completed = false;
        if(buff1==buff2){
            completed = true;
        }
        assertTrue("Counter is correct",completed);

    }

}
