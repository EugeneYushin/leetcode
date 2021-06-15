package algo;

import java.util.*;

class Tuple2<X,Y> {
    X first;
    Y second;

    Tuple2(X first, Y second) {
        this.first = first;
        this.second = second;
    }
}

class Logger {
    private Map<String, Integer> timings = new HashMap<>();
    private Queue<Tuple2<Integer, String>> slidingWindow = new LinkedList<>();
    private Set<String> uniqueMessages = new HashSet<>();

    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        return shouldPrintMessage_basedOnQueueAndSet(timestamp, message);
    }

    public boolean shouldPrintMessage_basedOnQueueAndSet(int timestamp, String message) {
        while (slidingWindow.peek() != null && slidingWindow.peek().first + 10 < timestamp) {
            // remove obsolete mappings
            Tuple2<Integer, String> pair = slidingWindow.poll();
            uniqueMessages.remove(pair.second);
        }

        if (uniqueMessages.contains(message)) {
            return false;
        } else {
            // add new unique message
            uniqueMessages.add(message);
            slidingWindow.add(new Tuple2<>(timestamp, message));
            return true;
        }
    }

    public boolean shouldPrintMessage_basedOnMap(int timestamp, String message) {
        Integer storedTs = timings.getOrDefault(message, -10);
        if (timestamp - storedTs >= 10) {
            timings.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */