import org.junit.Test;
import java.util.Date;


import static org.junit.Assert.assertTrue;


public class PersonTests {


    @Test(expected = WrongArgument.class)
    public void IlegalArgumentThrownWrongPesel() {

        Person temp = new Person("", "", new Date(), "9", Position.CPP_DEVELOPER);

    }

    @Test(expected = WrongArgument.class)
    public void IllegalArgumentWrongName(){
        Person temp = new Person(null, "Kowalski", new Date(), "98071903290", Position.CPP_DEVELOPER);
    }
    @Test(expected = WrongArgument.class)
    public void IllegalArgumentWrongSurname(){
        Person temp = new Person("Jan", null, new Date(), "98071903290", Position.CPP_DEVELOPER);
    }

    @Test
    public void IfObjectCreated(){
        Person temp = new Person("name","surname",new Date(),"98071903290",Position.CPP_DEVELOPER);

        boolean right =false;
        if(temp.getName()=="name"){
            right=true;
        }
        assertTrue("Objec created succesfully", right);
    }


}



