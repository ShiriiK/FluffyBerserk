package en.fluffyBerserk.form;

import org.jetbrains.annotations.Nullable;

public final class LoginForm extends Form {

    @Nullable
    private String username = null;

    @Nullable
    private String password = null;

    public @Nullable String getUsername() {
        return username;
    }

    public void setUsername(@Nullable final String username) {
        this.username = username;
    }

    public @Nullable String getPassword() {
        return password;
    }

    public void setPassword(@Nullable final String password) {
        this.password = password;
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

        return true;
    }
}
