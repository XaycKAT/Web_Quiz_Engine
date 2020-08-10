package engine.component;

import lombok.Data;

@Data
public class Response {

    private Boolean success;
    private String feedback;

    public Response(Boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public static Response getSuccessFeedback() {
        return new Response(
                true,
                "Congratulations, you're right!");
    }

    public static Response getFailedFeedback() {
        return new Response(
                false,
                "Wrong answer! Please, try again.");
    }

}
