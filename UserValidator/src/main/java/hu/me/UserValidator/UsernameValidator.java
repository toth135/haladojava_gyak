package hu.me.UserValidator;

public class UsernameValidator implements Checker {

    ValidatorResponse validatorResponse = new ValidatorResponse();

    @Override
    public ValidatorResponse valid(User user) {
        validatorResponse.setValid(true);
        if (user.getUsername().isEmpty() || user.getUsername().length() <= 5 || user.getUsername() == null) {
            validatorResponse.setValid(false);
            validatorResponse.setMessage(ErrorList.USERNAME_IS_TOO_SHORT.toString());
        }
        if (user.getUsername().contains(" ")) {
            validatorResponse.setValid(false);
            validatorResponse.setMessage(ErrorList.USERNAME_CONTAINS_WHITESPACE.toString());
        }
        return validatorResponse;
    }
}
