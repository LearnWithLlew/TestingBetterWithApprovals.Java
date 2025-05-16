package org.learnwithllew;

import java.util.List;
import java.util.UUID;

public class TestUtils {
    private static final String DONT_CARE_CONVERSATION_ID = "100";

    public static EventNotification.Builder eventNotification() {
        return new EventNotification.Builder()
            .conversationId(DONT_CARE_CONVERSATION_ID)
            .userId(userId().build())
            .events(List.of())
            .properties(List.of());
    }

    public static EventNotification.Builder messageFromCustomer(int conversationId, String messageId, String message) {
        return eventNotification()
            .events(List.of(new MessageEvent(System.currentTimeMillis(), messageId, message)))
            .conversationId(String.valueOf(conversationId));
    }

    public static EventNotification.Builder messageFromCustomer(String messageId, String message) {
        return eventNotification()
            .events(List.of(new MessageEvent(System.currentTimeMillis(), messageId, message)));
    }

    public static UserId.Builder userId() {
        return new UserId.Builder()
            .id(UUID.randomUUID().toString())
            .channel(Channel.TEXT);
    }

}
