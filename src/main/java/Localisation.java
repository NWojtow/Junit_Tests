import java.util.ArrayList;
import java.util.List;

public class Localisation {
    private String name;
    private String city;
    private ArrayList<Department> departmentList;
    public  int counter=0;

    public int getCounter() {
        return counter;
    }

    public Localisation(String name, String city){
        this.name = name;
        this.city=city;
        this.departmentList=new ArrayList<Department>();
    }


    public void addDepartment(Department temp){
        this.departmentList.add(temp);
        counter+=temp.getCounter();
    }

    public void removeDepartment(Department temp){
        for(int i=0;i<departmentList.size();i++){
            if(this.departmentList.get(i).equals(temp)){
                this.counter-=temp.getCounter();
                this.departmentList.remove(i);

            }
        }
    }

    public void changeLocalisation(Department tempDepartment, Localisation tempLocalisation){


        for(int i=0;i<tempLocalisation.getDepartmentList().size();i++){
            if(tempLocalisation.getDepartmentList().get(i).getDepartmentType()==tempDepartment.getDepartmentType()){
                throw(new DepartmentExists("Departament tego typu juz istnieje w tej lokalizacji"));

        }
        }
        for(int i=0;i<this.departmentList.size();i++){
            if(this.departmentList.get(i).getName()==tempDepartment.getName()){
                Department temp = this.departmentList.get(i);
                tempLocalisation.addDepartment(temp);
                this.departmentList.remove(i);
                this.counter-=temp.getCounter();
            }
        }

    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Localisation place = (Localisation) obj;
        return (place.name == this.name && place.city == this.city && place.departmentList == this.departmentList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return this.name+" "+this.city;
    }
    public boolean equals(Localisation temp){
        if(this.name==temp.name&&this.city==temp.city&&this.departmentList==temp.departmentList){
            return true;
        }
        else{
            return false;
        }
    }
}
