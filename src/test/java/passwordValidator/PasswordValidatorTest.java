package passwordValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordValidator.PasswordValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    public void createPasswordValidator(){
        passwordValidator = new PasswordValidator();
    }

//    @Test
//    public void givenEmptyPassword_whenValidate_thenFalse(){
//        String emptyPassword = "";
//
//        boolean isValid = passwordValidator.isValid(emptyPassword);
//
//        assertFalse(isValid);
//    }

    @Test
    public void givenPasswordWithLessThan8Characters_whenValidate_thenFalse(){
        String passwordWithLessThan8Characters = "1234567";

        boolean isValid = passwordValidator.isValid(passwordWithLessThan8Characters);

        assertFalse(isValid);
    }

    @Test
    public void givenValidPassword_whenValidate_thenTrue(){
        String validPassword = "Ab1!5678";

        boolean isValid = passwordValidator.isValid(validPassword);

        assertTrue(isValid);
    }

    @Test
    public void givenPasswordWithNoCapitalLetter_whenValidate_thenFalse(){
        String passwordWithNoCapitalLetter = "ab1!5678";

        boolean isValid = passwordValidator.isValid(passwordWithNoCapitalLetter);

        assertFalse(isValid);
    }

    @Test
    public void givenPasswordWithNoLowerCaseLetter_whenValidate_thenFalse(){
        String passwordWithNoLowerCaseLetter = "AB1!5678";

        boolean isValid = passwordValidator.isValid(passwordWithNoLowerCaseLetter);

        assertFalse(isValid);
    }

    @Test
    public void givenPasswordWithNoNumber_whenValidate_thenFalse(){
        String passwordWithNoNumber = "Abc!defg";

        boolean isValid = passwordValidator.isValid(passwordWithNoNumber);

        assertFalse(isValid);
    }

    @Test
    public void givenPasswordWithNoSpecialCharacter_whenValidate_thenFalse(){
        String passwordWithNoSpecialCharacter = "Ab1B5678";

        boolean isValid = passwordValidator.isValid(passwordWithNoSpecialCharacter);

        assertFalse(isValid);
    }

//    @Test
//    public void givenValidPasswordWithPermittedSpecialCharacters_whenValidate_thenTrue(){
//        String validPasswordWithPermittedSpecialCharacters = "Ab1&$678";
//
//        boolean isValid = passwordValidator.isValid(validPasswordWithPermittedSpecialCharacters);
//
//        assertTrue(isValid);
//    }

    @Test
    public void givenPasswordWithASpace_whenValidate_thenFalse(){
        String passwordWithASpace = "Ab1&$ 678";

        boolean isValid = passwordValidator.isValid(passwordWithASpace);

        assertFalse(isValid);
    }
}
