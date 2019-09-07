import java.util.ArrayList;


public class Company {
    private Person CEO;
    private Person CTO;
    private Person CFO;
    private ArrayList<Localisation> localisationList;
    private int counter=0;



    public Company(){
        this.localisationList = new ArrayList<Localisation>();
    }



    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Company place = (Company) obj;
        return (place.CEO == this.CEO && place.CFO == this.CFO && place.CTO == this.CTO && place.localisationList == this.localisationList);
    }



public void addLocalisation(Localisation temp){
        this.localisationList.add(temp);
        this.counter+=temp.getCounter();
}

public void removeLocalisation(Localisation temp){
        for(int i=0;i<this.localisationList.size();i++){
            if(this.localisationList.get(i).equals(temp)){
                this.counter-=this.localisationList.get(i).getCounter();
                this.localisationList.remove(i);
            }
        }

}

    @Override
    public String toString() {
        return("CEO: " + this.CEO + '\n'+"CTO: "+this.CTO+'\n'+"CFO: "+this.CFO+'\n');
    }

    public Person getCEO() {
        return CEO;
    }

    public void setCEO(Person CEO) {
        this.CEO = CEO;
    }

    public Person getCFO() {
        return CFO;
    }

    public void setCFO(Person CFO) {
        this.CFO = CFO;
    }

    public Person getCTO() {
        return CTO;
    }

    public void setCTO(Person CTO) {
        this.CTO = CTO;
    }


    public ArrayList<Localisation> getLocalisationList() {
        return localisationList;
    }

    public void setLocalisationList(ArrayList<Localisation> localisationList) {
        this.localisationList = localisationList;
    }

    public int getCounter() {
        return counter;
    }
}
