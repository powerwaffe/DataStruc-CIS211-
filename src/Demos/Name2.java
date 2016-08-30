package Demos;

/**
 * Created by Sean on 8/27/2016.
 */
public class Name2 {
    private String first; //First name
    private String last; //Last name

    public Name2()
    {
        first = "";
        last = "";
    } //end default constructor

    /** ""this" can be used to create same results
     public Name2()
        {
            this("", "");
        } //end default constructor
     */
    public Name2(String firstName, String lastName)
    {
        first = firstName;
        last = lastName;
    } //end constructor
    public Name2 setName(String firstName, String lastName)
    {
        setFirst(firstName);
        setLast(lastName);
        return this;
    } //end setName
    public String getName()
    {
        return toString();
    } //end getName
    public void setFirst(String firstName)
    {
        first = firstName;
    }
    public String getFirst()
    {
        return first;
    } //end getFirst
    public void setLast(String lastName)
    {
        last = lastName;
    } //end setLast
    public String getLast()
    {
        return last;
    } //end getLast
    public void giveLastNameTo(Name aName)
    {
        aName.setLast(last);
    } //end giveLastNameTo
    public String toString()
    {
        return first + " " + last;
    } //end toString

    public static void main(String[] farts)
    {
        //using setters to mutate jill object
        Name2 jill = new Name2("Jill", "Jones");
        System.out.println(jill);
        jill.setLast("Jibble");
        System.out.println("Jill after marrying\n" + jill);
        jill.setFirst("Jibble");
        jill.setLast("Sandwich");
        System.out.println("After becoming a sandwich\n" + jill);

        //using setName
        Name2 jill2 = new Name2();
        jill2.setName("Jill", "Greene");
        System.out.println(jill2.getName());
        Name2 myFriend = jill2.setName("Jill", "Greener");
        System.out.println(myFriend);

        //name changed with constructor, new object
        jill = new Name2("jill", "Smith");
        System.out.println(jill);
    }
} //end Name
