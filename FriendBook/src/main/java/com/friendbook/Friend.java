package com.friendbook;

public class Friend {
    private String firstName;
    private String lastName;
    private String birthday;
    private String phoneNumber;
    private String address;

    public Friend(String firstName, String lastName, String birthday, String phoneNumber, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;



    }

    //for the ListView
    public String toString(){
        return firstName+" "+lastName;
    }


    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
