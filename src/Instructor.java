
public class Instructor {
    String name;
    String surname;
    boolean isPrimary;

    public Instructor (String name, String surname, boolean isPrimary){
        this.name = name;
        this.surname = surname;
        this.isPrimary = isPrimary;
    }

    public String instructorName(){return name + " " + surname;}
    public String toString(){
        return " Name : " + name + " Surname: " + surname + " isPrimary: " + isPrimary;
    }
}
