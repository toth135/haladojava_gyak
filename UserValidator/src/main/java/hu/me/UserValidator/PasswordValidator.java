package hu.me.UserValidator;

public class PasswordValidator implements Checker {

    ValidatorResponse validatorResponse = new ValidatorResponse();

    @Override
    public ValidatorResponse valid(User user) {
        validatorResponse.setValid(true);
        if (user.getPassword().isEmpty() || user.getPassword().length() <= 5 || user.getPassword() == null) {
            validatorResponse.setValid(false);
            validatorResponse.setMessage(ErrorList.PASSWORD_IS_TOO_SHORT.toString());
        }
        if (user.getPassword().contains(" ")) {
            validatorResponse.setValid(false);
            validatorResponse.setMessage(ErrorList.PASSWORD_CONTAINS_WHITESPACE.toString());
        }
        return validatorResponse;
    }
}
