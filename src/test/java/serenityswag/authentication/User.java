package serenityswag.authentication;

import lombok.Getter;

@Getter
public enum User {

    STANDARD_USER("standard_user", "secret_sauce", "a standard user"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce", "a user locked-out of their account"),
    PROBLEM_USER("problem_user", "secret_sauce", "a problem user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", "a performance-glitch user");

    private final String username;
    private final String password;
    private final String description;

    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
