# CSC143 Project 2  - Hotel Software :hotel:

_PROJECT TITLE_: Burger Inn 
_PURPOSE OF PROJECT_: (Part II) of a hotel reservation software program.  
_VERSION or DATE_: 3/7/2019, CSC 143 Winter 2019  
_AUTHOR_: Megan Laine (built upon prior work created with: Dale Berg, Nick Coyle, and Steven Liu)
_GITHUB LINK_: <https://github.com/meganlaine/BurgerInn/> :octocat:


## Welcome!
* Project 2 is a continuation of the work from "Hotel Burger", a software program created to help with hotel operations (such as room reservations and invoice recording). It was an independent project.

#### Please note:
* The hotel has pre-existing reservations and members to work with!

#### What's new (compared to Project 1)?
* (NEW) Guest class: compareTo() compares guests by their last name, then first name, then phoneNumber.
* (ADDITIONAL) user input validation. anywhere a lowercase or uppercase letter could throw off a search, I've implemented the equalsIgnoreCase() OR compareToIgnoreCase() method.
* (NEW) Main class: Express check in method for returning Hotel members.
* (NEW) GuestTree class: a binary search tree for Guest objects;
    * (USE CASE): in this project the use case is for Hotel member storage.
    * Guests can be added if they 'sign up for membership'.
    * At this moment, there are no main menu options to remove members from the tree.
    * NEW method to fill the member GuestTree from a pre-existing .txt file.
    * NEW method to save the member GuestTree to the pre-existing .txt file.
* (NEW) GuestTreeNode class to support GuestTree class.
* (NEW) LinkedRoomList class (doubly linked)
    * (USE CASE): replaced every instance of ArrayList<Room> with the relevant LinkedRoomList methods and iterator.
    * NEW private subclass: ListRoomNodeIterator
* (NEW) ListRoomNode class to support LinkedRoomList class.

#### What's different from the poster session (Thursday 7 Mar 2019)?
* instead of GuestTree method 'toStringInorder', the method is actually 'toStringPreorder'
* (FIXED BUG): In project 1, our method payBill() in class Reservation was not being called. This led to many reservations being made, but the hotel was not getting paid! This has been fixed.
    
#### Things that could still be improved
* implement temporal aspect (Time/Day)
* implement more methods of the GuestTree and LinkedRoomList (in Main class, offer option for a Guest to opt-out of the membership program)
* Main and Hotel class are a bit bloated; it would be good to think more about what methods should really go back into the other classes (Reservation, Room, Guest)
* Ideas I liked from other (classmates)'s projects: 
    * implement 2 different LinkedRoomList or 2 different Tree for AVAILABLE and OCCUPIED rooms
    * learn more about the width() and height() methods for Trees
 
#### To run the command line interface:
* Run the main method in the Main class
* To exit: (enter '10') from the main menu. (This also saves the state of our hotel on every exit by overwriting the reservations and member text files we use to populate the hotel on start-up)

#### Text files needed:
-------------------------------------------------------------------------------
- [x] *HotelBurgerRooms.txt*: stores hotel information and room information
- [x] *HotelBurgerReservations.txt*: stores existing reservations
- [x] *HotelBurgerMembers.txt*: stores hotel member information


### That's a wrap! :bowtie:
