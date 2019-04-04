import java.util.ArrayList;
import java.lang.IllegalArgumentException;

/**
 * Guest class models a customer of a hotel. The guest is a person with a name and various 
 * personal information. Guests might have discounts applied based on membership to the 
 * hotel or status as a veteran or government employee so we have fields for those data.
 *
 * @author Dale Berg, Nick Coyle, Megan Laine, Steven Liu
 * @version 7 March 2019
 */
public class Guest implements Comparable<Guest>
{
    /* INSTANCE VARIABLES */
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isMilitary;
    private boolean isGovernment;
    private boolean isMember;
    private String roomPref;

    /**
     * Guest Constructor 1/1: The full Guest constructor that takes into account all 
     * parameters about a Guest.
     *
     * @param first (String) guest's first name
     * @param last (String) guest's last name
     * @param phoneNum (String) guest's phone number
     * @param partySize (int) how many people in the group, including reserving guest.
     * @param nights (int) how many nights the guest+party will stay at hotel
     * @param isMil (boolean) true if the guest qualifies for military discount
     * @param isGov (boolean) true if the guest qualifies for government discount
     * @param member (boolean) true if the guest qualifies for membership discount
     * @param roomPref (String) the room number that the guest most recently made a reservation for.
     */
    public Guest( String first, String last, String phoneNum,                    
                    boolean isMil, boolean isGov, boolean member, String roomPref )
    {
        setFirstName( first );
        setLastName( last );
        setPhoneNum( phoneNum );   
        setMil( isMil );
        setGovt( isGov );
        setMembership( member );
        setRoomPref( roomPref );
    }
    
    /* ACCESSOR METHODS */
    
    /**
     * Method getFirstName returns the Person's first name
     *
     * @return (String) Person's first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Method getLastName returns the Person's last name
     *
     * @return (String) Person's last name
     */
    public String getLastName() 
    {
        return lastName;
    }

    /**
     * Method getPhoneNum returns the Person's phone number
     *
     * @return (String) Person's phone number
     */
    public String getPhoneNum() 
    {
        return phoneNumber;
    }
    
    /**
     * Method getFullName returns guest's first and last name combined in one string
     *
     * @return (String) guest's first and last name combined in one string
     */
    public String getFullName() 
    {
        return this.getFirstName() + " " + this.getLastName();
    }
    
    /**
     * Method isMilitary returns true if the guest qualifies for military discount
     *
     * @return true if the guest qualifies for military discount
     */
    public boolean isMilitary() 
    {
        return isMilitary;
    }

    /**
     * Method isGovernment returns true if the guest qualifies for government discount
     *
     * @return true if the guest qualifies for government discount
     */
    public boolean isGovernment() 
    {
        return isGovernment;
    }

    /**
     * Method isMember returns true if the guest qualifies for membership discount
     *
     * @return true if the guest qualifies for membership discount
     */
    public boolean isMember() 
    {
        return isMember;
    }
    
    /**
     * Method getRoomPref returns a String for the most recently reserved Room
     *
     * @return (String) the room number that the guest most recently reserved
     */
    public String getRoomPref()
    {
        return roomPref;
    }
    
    /* MUTATOR METHODS */
    
    /**
     * Method setFirstName sets the Person's first name. An empty string is an invalid name.
     *
     * @param first (String) representing Person's first name
     * @throw IllegalArgumentException if an empty string is passed
     */
    public void setFirstName(String first) 
    {
        if ( first.isEmpty() )
        {
            throw new IllegalArgumentException("First Name can't be an Empty String");
        }
        
        firstName = first;
    }
    
    /**
     * Method setLastName sets the Person's last name. An empty string is an invalid name.
     *
     * @param last (String) representing Person's last name
     * @throw IllegalArgumentException if an empty string is passed
     */
    public void setLastName(String last) 
    {
        if ( last.isEmpty() )
        {
            throw new IllegalArgumentException("Last Name can't be an Empty String");
        }
        
        lastName = last;
    }
    
    /**
     * Method setPhoneNum sets the Person's phone number, if valid. a valid phone number is
     * 10 digits, like 2061234567.
     *
     * @param phoneNum (String) representing Person's phone number 
     */
    public void setPhoneNum(String phoneNum) 
    {
        if ( isValidPhone(phoneNum) )
        {          
            phoneNumber = phoneNum; 
        }
    }
    
    /**
     * Method isValidPhone checks if the Person's phone number is valid. 
     * A valid phone number is 10 digits, like 2061234567.
     *
     * @param phoneNum (String) representing Person's phone number
     * @throw IllegalArgumentException if the phone number does not match a 10 digit int.
     */
    public static boolean isValidPhone(String phoneNum)
    {
        if ( !phoneNum.matches("^[0-9]*$") )
        {
            throw new IllegalArgumentException("The phone number entered is not numeric");
        }
               
        int length = phoneNum.length();
        
        if ( length != 10 )
        {
            throw new IllegalArgumentException("The phone number entered must be 10 digits."
                + " You entered " + length + " digits.");
        }  
        
        return true;
    }
    
    /**
     * Method setMil sets the military discount status of the guest.
     *
     * @param m (boolean) representing military discount status of guest.
     */
    public void setMil(boolean m) 
    {
        isMilitary = m;
    }

    /**
     * Method setGovt sets the government discount status of the guest.
     *
     * @param g (boolean) representing government discount status of guest.
     */
    public void setGovt(boolean g) 
    {
        isGovernment = g;
    }

    /**
     * Method setMembership sets the membership discount status of the guest.
     *
     * @param m (boolean) representing membership discount status of guest.
     */
    public void setMembership(boolean m) 
    {
        isMember = m;
    }
    
    /**
     * Method setRoomPref sets the guest's most recently reserved room number.
     *
     * @param roomNum (String) representing guest's most recently reserved room.
     */
    public void setRoomPref(String roomNum) 
    {
        roomPref = roomNum;
    }
    
    /* OTHER METHODS */
    
    /**
     * Method toString overrides Class Object's toString() method. it returns information 
     * about this Guest, including their name, phone number, party size, nights stayed, 
     * and discount status(es).
     *
     * @return (String) with information about the guest.
     */
    @Override
    public String toString() 
    {
        return this.getFullName() + " , Phone: " + this.getPhoneNum() + "\n" +            
            "Military: " + isMilitary + ", " + 
                "Government: " + isGovernment + ", " +
                    "Member: " + isMember;        
    }
    
    /**
     * Returns true if this Guest has the same full name and phone number as other Guest. 
     * It is case insensitive.
     * 
     * @param guest (Guest) the other guest to compare with
     * @return (boolean) true if the guests have the same full name and phone num.
     */
    public boolean equals(Guest guest)
    {        
        return (this.getFirstName().equalsIgnoreCase(guest.getFirstName())
            && 
            this.getLastName().equalsIgnoreCase(guest.getLastName())
            &&
            this.getPhoneNum().equals(guest.getPhoneNum()) );
    }
    
    /**
     * compareTo method overrides Object's compareTo method; it compares Guests by last name,
     * then first name, then phone number. it is case insensitive; returns 0 if the other 
     * Guest and this Guest's information are equal.
     * 
     * @param other (Guest) a guest to compare against
     * @return result (int) the mathematical difference between the two Guest objects.
     */
    @Override
    public int compareTo( Guest other )
    {
        int result = 0;
        
        // if this Guest is not the same as other Guest,...
        if (! this.equals(other) )
        {
            // compare by last name
            if ( ! this.getLastName().equalsIgnoreCase(other.getLastName()) )
            {
                result = this.getLastName().compareToIgnoreCase(other.getLastName());
            }
            // compare by first name
            else if ( ! this.getFirstName().equalsIgnoreCase(other.getFirstName()) )
            {
                result = this.getFirstName().compareToIgnoreCase(other.getFirstName());
            }
            // compare by phone num
            else if ( ! this.getPhoneNum().equals(other.getPhoneNum()) )
            {
                result = this.getPhoneNum().compareTo(other.getPhoneNum());
            }
        }
        return result;
    }
}
