import java.util.HashMap;
import java.util.Scanner;

public class myMain {
    private HashMap<String, UserSession> sessionTable;

    public myMain() {
        sessionTable = new HashMap<>();
    }

    // Method to add or update a session
    public void addOrUpdateSession(String sessionId, UserSession session) {
        sessionTable.put(sessionId, session);
    }

    // Method to get a session by ID
    public UserSession getSession(String sessionId) {
        return sessionTable.get(sessionId);
    }

    // Method to print all sessions (for demonstration purposes)
    public void printSessions() {
        for (String id : sessionTable.keySet()) {
            System.out.println("Session ID: " + id + " -> " + sessionTable.get(id));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        myMain sessionManager = new myMain();

        System.out.println("Please enter a session ID:");
        String sessionId = input.nextLine();

        // Creating a new UserSession object (you can modify this part to include more data)
        UserSession userSession = new UserSession();
        userSession.setSessionId(sessionId);

        // Adding or updating the session
        sessionManager.addOrUpdateSession(sessionId, userSession);

        // Retrieving and printing the session
        UserSession retrievedSession = sessionManager.getSession(sessionId);
        System.out.println("Retrieved Session: " + retrievedSession);

        // Optionally, print all sessions
        sessionManager.printSessions();

        input.close();
    }
}

class UserSession {
    private String sessionId;

    // Constructor, getters, setters, and toString method
    public UserSession() {
        // Constructor
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String toString() {
        return "UserSession{" +
                "sessionId='" + sessionId + '\'' +
                '}';
    }
}
