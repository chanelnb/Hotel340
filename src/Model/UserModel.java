package Model;

/**
 *model for users 
 * 
 * last update 11/15/20
 * 
 * @author sogol
 */
public class UserModel{
        private String firstName;
        private String lastName;
        private String address;
        private int phoneNumber;
        private String email;
        private String username;
        private String password;
        private String passwordConfirmation;

//===================GETTERS=====================

        /**
         * gets first name
         * 
         * @return the firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * gets last name
         * 
         * @return the lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * gets the address
         * 
         * @return the address
         */
        public String getAddress() {
            return address;
        }

        /**
         * gets the phone number
         * 
         * @return the phoneNumber
         */
        public int getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * gets the email
         * 
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * gets the username
         * 
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * gets password
         * 
         * @return the password
         */
        public String getPassword() {
            return password;
        }

        /**
         * gets password confirmation
         * 
         * @return the passwordConfirmation
         */
        public String getPasswordConfirmation() {
            return passwordConfirmation;
        }

//===================SETTERS=====================

        /**
         * sets first name
         * 
         * @param firstName the _firstName to set
         */
        public void setFirstName(String _firstName) {
            this.firstName = _firstName;
        }


        /**
         * sets last name
         * 
         * @param lastName the _lastName to set
         */
        public void setLastName(String _lastName) {
            this.lastName = _lastName;
        }

        /**
         * sets address
         * 
         * @param address the _address to set
         */
        public void setAddress(String _address) {
            this.address = _address;
        }

        /**
         * sets phone number
         * 
         * @param phoneNumber the _phoneNumber to set
         */
        public void setPhoneNumber(int _phoneNumber) {
            this.phoneNumber = _phoneNumber;
        }

        /**
         * sets email
         * 
         * @param email the _email to set
         */
        public void setEmail(String _email) {
            this.email = _email;
        }

        /**
         * sets username
         * 
         * @param username the _username to set
         */
        public void setUsername(String _username) {
            this.username = _username;
        }

        /**
         * sets password
         * 
         * @param password the _password to set
         */
        public void setPassword(String _password) {
            this.password = _password;
        }

        /**
         * sets password confirmation
         * 
         * @param passwordConfirmation the _passwordConfirmation to set
         */
        public void setPasswordConfirmation(String _passwordConfirmation) {
            this.passwordConfirmation = _passwordConfirmation;
        }
    }

