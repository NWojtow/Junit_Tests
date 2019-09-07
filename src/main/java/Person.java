import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private PeselValidator pesel;
    private Position position;


    public Person(){
        this.name="Nie podano";
        this.surname="Nie podano";
        this.pesel= new PeselValidator("0000000000");
        this.birthDate=new Date();
        this.position=Position.CPP_DEVELOPER;
    }

    public Person(String name,String surname,Date birthDate,String pesel,Position position){
        Date actual = new Date();
        actual.setYear(2001);
        boolean underaged = false;
        boolean wrongPesel =false;
        boolean personExists=false;
        PeselValidator temp = new PeselValidator(pesel);

        int birthYear = birthDate.getYear();
        if(2019-birthYear<18){
            underaged=true;
        }

//        for(int i=0;i<Main.listOfPersons.size();i++){
////            if(Main.listOfPersons.get(i).getPesel()==pesel){
////                personExists=true;
////            }
//        }
            if (name == null || surname == null||underaged||temp.isValid()==false||personExists) {
                throw new WrongArgument("Nie podałes imienia lub naziwska, osoba nie ma ukończonych 18 lat lub źle podałeś numer pesel");
            }
            this.name=name;
            this.surname=surname;
            this.birthDate=birthDate;
            this.pesel= new PeselValidator(pesel);
            this.position=position;
//            Main.listOfPersons.add(this);

//        }      catch(IllegalArgumentException e){

//        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PeselValidator getPesel() {
        return this.pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = new PeselValidator(pesel);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.name+" "+this.surname+" "+this.pesel+" "+this.birthDate+" "+this.position;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Person geek = (Person) obj;
        return (geek.name == this.name && geek.surname == this.surname && geek.pesel == this.pesel && geek.birthDate == this.birthDate && geek.position == this.position);
    }
}
