package Creational.builder_pattern_demo;

public class UserDetails {
	 //All final attributes
    private final String Name; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
 
    private UserDetails(UserBuilder builder) {
        this.Name = builder.Name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
 
 
    public String getName() {
        return Name;
    }
    
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
 
    @Override
    public String toString() {
        return "User: "+this.Name+", "+this.age+", "+this.phone+", "+this.address;
    }
 
    public static class UserBuilder 
    {
        private final String Name;
        private int age;
        private String phone;
        private String address;
 
        public UserBuilder(String Name) {
            this.Name = Name;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
       
        public UserDetails build() {
        	UserDetails user =  new UserDetails(this);
            return user;
        }
           }

}
