import org.junit.Test;


public class LocalizationTests {


    @Test
    public void loccalizationChangeTest(){
        Localisation temp1 = new Localisation("Localization1","Krakow");
        Localisation temp2 = new Localisation("Localization2","Wrswa");
        Department tempDepartment = new Department("Development",DepartmentType.DEVELOPMENT);

        temp1.addDepartment(tempDepartment);
        temp1.changeLocalisation(tempDepartment,temp2);

        temp2.getDepartmentList().get(0).getName();

    }


    @Test(expected = DepartmentExists.class)
    public void departmentThisTypeExistsException(){
        Localisation temp1 = new Localisation("Localization1","Krakow");
        Localisation temp2 = new Localisation("Localization2","Wrswa");

        Department tempDepartment = new Department("Development",DepartmentType.DEVELOPMENT);
        Department tempDepartment2 = new Department("Development2", DepartmentType.DEVELOPMENT);

        temp1.addDepartment(tempDepartment);
        temp2.addDepartment(tempDepartment2);

        temp1.changeLocalisation(tempDepartment,temp2);

    }
}
