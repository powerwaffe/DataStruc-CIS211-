package Demos;

/**
 * Created by Sean on 8/26/2016.
 */
public class Name {
    private String first; //first name
    private String last; //last name
    private String middle; //middle name
    private char initial; //initial

    public static void main(String[] farts) {
        Name jamie = new Name();
        jamie.setFirst("Jamie");
        jamie.setLast("Jones");

        Name jane = new Name();
        jane.setFirst("Jane");
        jane.setLast("Doe");

        //Joe's name editor
        Name joe = new Name();
        char JoesMI = 'T';

        joe.setFirst("Joseph");
        joe.setLast("Farflik");
        //joe.setMiddle("Turducken");
        joe.setMiddleInitial(JoesMI);
        System.out.println(joe.getFirst() + " " + joe.getMiddleInitial() + " " + joe.getLast());
    } //end main
    public String getFirst()
    {
        return first;
    } //end getFirst
    public void setFirst(String firstName)
    {
        first = firstName;
    } //end setFirst
    public String getLast()
    {
        return last;
    } //end getLast
    public void setLast(String lastName)
    {
        last = lastName;
    } //end setLast
    public String getMiddle()
    {
        return middle;
    } //end getMiddle
    public void setMiddle(String middleName)
    {
        middle = middleName;
    } //end setMiddle
    public void setMiddleInitial(char middleInitial)
    {
        initial = middleInitial;
    } //end setMiddleInitial
    public char getMiddleInitial()
    {
        return initial;
    }  //end  getMiddleInitial
    public void giveLastNameTo(Name child)
    {
        child.setLast(last);
    }
    public void giveLastNameTo2(Name child)
    {
        String firstName = child.getFirst();
        child = new Name();
        child.setFirst(firstName);
        child.setLast(last);
    } //end giveLastNameTo2
}

