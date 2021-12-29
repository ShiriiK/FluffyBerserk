package en.fluffyBerserk.form;

import org.jetbrains.annotations.Nullable;

public final class RegisterForm extends Form {

    @Nullable
    private String username = null;

    @Nullable
    private String password = null;

    @Nullable
    private String passwordConfirm = null;

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
