package engine.model;

import lombok.Data;

@Data
public class Feedback {
    private boolean success;
    private String feedback;

    public Feedback(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public static Feedback getSuccessFeedback() {
        return new Feedback(
                true,
                "Congratulations, you're right!");
    }

    public static Feedback getFailedFeedback() {
        return new Feedback(
                false,
                "Wrong answer! Please, try again.");
    }

}
