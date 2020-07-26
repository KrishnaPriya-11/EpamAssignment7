package Creational.builder_pattern_demo;

public class UserBuilder {
	public static void main(String[] args) {
	    UserDetails user1 = new UserDetails.UserBuilder("Lokesh")
	    .age(30)
	    .phone("1234567")
	    .address("Fake address 1234")
	    .build();
	 
	    System.out.println(user1);
	 
	    UserDetails user2 = new UserDetails.UserBuilder("Jack")
	    .age(40)
	    .phone("5655")
	    //no address
	    .build();
	 
	    System.out.println(user2);
	 
	    UserDetails user3 = new UserDetails.UserBuilder("Johnson")
	    //No age
	    //No phone
	    //no address
	    .build();
	 
	    System.out.println(user3);
	}
	 

}
