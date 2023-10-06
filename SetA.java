// User-defined exception for invalid username
class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

// User-defined exception for invalid password
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

// EmailID class with username and password
class EmailID {
    private String username;
    private String password;

    // Default constructor
    public EmailID() {
        this.username = "";
        this.password = "";
    }

    // Parameterized constructor
    public EmailID(String username, String password) throws InvalidUsernameException, InvalidPasswordException {
        if (isValidUsername(username)) {
            this.username = username;
        } else {
            throw new InvalidUsernameException("Invalid username!");
        }

        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new InvalidPasswordException("Invalid password!");
        }
    }

    // Check if the username is valid (e.g., contains only letters and numbers)
    private boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9]+$");
    }

    // Check if the password is valid (e.g., at least 8 characters long)
    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    // Getter methods for username and password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Accept username and password from command line arguments
            if (args.length != 2) {
                System.out.println("Usage: java Main <username> <password>");
                return;
            }

            String username = args[0];
            String password = args[1];

            // Create an EmailID object with the provided values
            EmailID email = new EmailID(username, password);

            // Print the username and password
            System.out.println("Username: " + email.getUsername());
            System.out.println("Password: " + email.getPassword());
        } catch (InvalidUsernameException | InvalidPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
