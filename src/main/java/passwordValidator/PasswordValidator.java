package passwordValidator;

public class PasswordValidator {
    private int MINIMAL_LENGTH = 8;
    private String MINIMAL_NUMBER_REGEX = ".*\\d.*";
    public boolean isValid(String password) {
        return hasMinimalLength(password)
               && containsAtLeastACapitalLetter(password)
               && containsAtLeastALowerCaseLetter(password)
               && containsAtLeastANumber(password)
               && containsRequiredSpecialCharacters(password)
               && containsNoSpace(password);
    }

    private boolean hasMinimalLength(String password) {
        return password.length() >= MINIMAL_LENGTH;
    }

    private boolean containsAtLeastACapitalLetter(String password) {
        String lowerCasePassword = password.toLowerCase();
        return !lowerCasePassword.equals(password);
    }

    private boolean containsAtLeastALowerCaseLetter(String password) {
        String upperCasePassword = password.toUpperCase();
        return !upperCasePassword.equals(password);
    }

    private boolean containsAtLeastANumber(String password) {
        return password.matches(MINIMAL_NUMBER_REGEX);
    }

    private boolean containsRequiredSpecialCharacters(String password) {
        return password.contains("!") || password.contains("&") || password.contains("$");
    }

    private boolean containsNoSpace(String password) {
        return !password.contains(" ");
    }
}
