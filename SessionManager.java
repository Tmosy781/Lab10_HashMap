
import java.util.HashMap;
import java.util.Scanner;

public class SessionManager {

    private HashMap<String, UserSession> sessionTable;
    private boolean oneUser = false;

    public SessionManager() {
        sessionTable = new HashMap<>();
    }

    public void addOrUpdateSession(String sessionId, UserSession session) {
        if (!sessionTable.containsKey(sessionId)) {
            sessionTable.put(sessionId, session);
            System.out.println("Successfully logged into session: " + getSession(sessionId));
            oneUser = true;
        } else {
            System.out.println("Cannot add/update session with the same session ID. Please try again.");
        }
    }

    public UserSession getSession(String sessionId) {
        return sessionTable.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (sessionTable.containsKey(sessionId)) {
            sessionTable.remove(sessionId);
            System.out.println("User logged out successfully.");
            if (sessionTable.isEmpty()) {
                oneUser = false;
            }
        } else {
            System.out.println("Session not found. Please try again.");
        }
    }

    public void printSessions() {
        for (String id : sessionTable.keySet()) {
            System.out.println("Session ID: " + id + " -> " + sessionTable.get(id));
        }
        if (!oneUser) {
            System.out.println("\nThere are no sessions currently logged in.");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SessionManager sessionManager = new SessionManager();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add or Update Session");
            System.out.println("2. Get Session by ID");
            System.out.println("3. Log User Out (Remove Session)");
            System.out.println("4. Print All Sessions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Please enter a session ID:");
                    String sessionId = input.nextLine();

                    // Creating a new UserSession object (you can modify this part to include more data)
                    UserSession userSession = new UserSession();
                    userSession.setSessionId(sessionId);

                    // Adding or updating the session
                    sessionManager.addOrUpdateSession(sessionId, userSession);
                    break;
                case 2:
                    System.out.println("Please enter a session ID to look up:");
                    String lookupSessionId = input.nextLine();

                    // Retrieving and printing the session
                    UserSession retrievedSession = sessionManager.getSession(lookupSessionId);
                    System.out.println("Retrieved Session: " + retrievedSession);
                    break;
                case 3:
                    System.out.println("Please enter a session ID to log out:");
                    String logoutSessionId = input.nextLine();

                    // Logging the user out (removing the session)
                    sessionManager.removeSession(logoutSessionId);
                    break;
                case 4:
                    // Optionally, print all sessions
                    sessionManager.printSessions();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        input.close();
    }
}

class UserSession {

    private String sessionId;

    public UserSession() {
        // Empty constructor
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String toString() {
        return "UserSession{"
                + "sessionId='" + sessionId + '\''
                + '}';
    }
}
