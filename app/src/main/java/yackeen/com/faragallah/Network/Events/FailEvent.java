package yackeen.com.faragallah.Network.Events;

/**
 * Created by Abdelrhman Walid on 4/25/2017.
 */

public class FailEvent {
    private String message;

    public FailEvent() {
    }

    public FailEvent(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message == null ? "Error" : message;
    }
}
