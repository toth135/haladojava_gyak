package hu.me;

public class EmptyValidator implements Checker {

    ValidatorResponse validatorResponse = new ValidatorResponse();

    @Override
    public ValidatorResponse valid(User user) {
        if (user.getUsername().isEmpty()) {
            validatorResponse.setMessage("Ures felhasznalonev");
            validatorResponse.setValid(false);
        } else {
            validatorResponse.setValid(true);
        }
        return validatorResponse;
    }
}
