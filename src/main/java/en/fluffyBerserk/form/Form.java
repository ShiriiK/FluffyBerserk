package en.fluffyBerserk.form;

import org.jetbrains.annotations.NotNull;

import java.util.*;

abstract public class Form {

    @NotNull
    protected final Map<String, List<String>> errors = new HashMap<>();

    /**
     * Add errors for specific field
     *
     * @param field     name of a field
     * @param newErrors array of new errors
     */
    public void addError(@NotNull String field, @NotNull String... newErrors) {
        List<String> currentErrors = errors.containsKey(field) ? errors.get(field) : new ArrayList<>();

        currentErrors.addAll(Arrays.asList(newErrors));

        errors.put(field, currentErrors);
    }

    public void clearErrors() {
        errors.clear();
    }

    /**
     * Gets errors list for specific field
     *
     * @param field name of a field
     * @return list of all errors for a field, empty list otherwise
     */
    public @NotNull List<String> getErrorsForField(String field) {
        return errors.containsKey(field) ? errors.get(field) : new ArrayList<>();
    }

    /**
     * Method validates all field in the form, sets the
     * errors and returns the validation result
     *
     * @return true if the form is valid, false otherwise
     */
    public abstract boolean validate();
}
