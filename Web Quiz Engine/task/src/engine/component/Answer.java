package engine.component;

import lombok.Data;

@Data
public class Answer {

    private Boolean success;
    private String feedback;

    public Answer(Boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public static Answer getSuccessFeedback() {
        return new Answer(
                true,
                "Congratulations, you're right!");
    }

    public static Answer getFailedFeedback() {
        return new Answer(
                false,
                "Wrong answer! Please, try again.");
    }

}
