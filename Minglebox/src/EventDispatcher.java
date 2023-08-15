import java.util.*;

class EventDispatcher {
    private Map<String, EventHandler> eventHandlers;

    public EventDispatcher() {
        eventHandlers = new HashMap<>();
    }

    public void addHandler(String eventName, EventHandler handler) {
        eventHandlers.put(eventName, handler);
    }

    public void dispatchEvent(String eventName, Object data) {
        EventHandler handler = eventHandlers.get(eventName);
        if (handler != null) {
            handler.handleEvent(data);
        }
   }
}