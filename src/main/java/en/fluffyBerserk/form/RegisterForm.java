package en.fluffyBerserk.form;

import org.jetbrains.annotations.Nullable;

import java.util.*;

public class RegisterForm {

    @Nullable
    private String username = null;

    @Nullable
    private String password = null;

    @Nullable
    private String passwordConfirm = null;

    private final Map<String, List<String>> errors = new HashMap<>();

    public @Nullable String getUsername() {
        return username;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    public @Nullable String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    public @Nullable String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(@Nullable String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void addError(String field, String... error) {
        List<String> currentErrors = errors.containsKey(field) ? errors.get(field) : new ArrayList<>();

        currentErrors.addAll(Arrays.asList(error));

        errors.put(field, currentErrors);
    }

    public void clearErrors() {
        errors.clear();
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public List<String> getErrorsForField(String field) {
        return errors.containsKey(field) ? errors.get(field) : new ArrayList<>();
    }

    public boolean validate() {
        if (username == null || username.isEmpty()) {
            addError("username", "Username must not be empty!");
            return false;
        }

        if (password == null || password.isEmpty()) {
            addError("password", "Password must not be empty!");
            return false;
        }

        if (passwordConfirm == null || passwordConfirm.isEmpty()) {
            addError("passwordConfirm", "Password confirmation must not be empty!");
            return false;
        }

        if (!password.equals(passwordConfirm)) {
            addError("passwordConfirm", "Password confirmation does not match the given password.");
            return false;
        }

        return true;
    }
}
