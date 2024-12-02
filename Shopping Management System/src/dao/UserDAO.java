package dao;

import java.io.Serializable;

public class UserDAO implements Serializable {

    private static final long serialVersionUID = 1L;  // Add a version UID for serialization compatibility
    public static int idCounter = 1;
    private String userID;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String securityQuestion;
    private String securityQuestionAns;
    private String address;

    public UserDAO() {
        this.userID = String.valueOf(idCounter++);
    }

    public UserDAO(String username, String email, String password, String phoneNumber, String securityQuestion, String securityQuestionAns, String address) {
        this.userID = String.valueOf(idCounter++);
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAns = securityQuestionAns;
        this.address = address;
    }

    public UserDAO(String userID, String username, String email, String password, String phoneNumber, String securityQuestion, String securityQuestionAns, String address) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.securityQuestion = securityQuestion;
        this.securityQuestionAns = securityQuestionAns;
        this.address = address;
    }

    // Getter and Setter methods
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAns() {
        return securityQuestionAns;
    }

    public void setSecurityQuestionAns(String securityQuestionAns) {
        this.securityQuestionAns = securityQuestionAns;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
