package hu.me;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {


    @Override
    public void saveUser(User user) {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
    }

//    @Override
//    public List<ValidatorResponse> getNumberOfErrors(User user, List<Checker> checkers, ArrayList<ValidatorResponse> errors) {
//
//        ValidatorResponse valid;
//
//        for(Checker checker : checkers) {
//            valid = checker.valid(user);
//            if(!valid.isValid()) {
//                errors.add(valid);
//            }
//        }
//
//        System.out.println("Hibak szama: " + errors.size());
//        for(ValidatorResponse validatorResponse : errors) {
//            System.out.println(validatorResponse.getMessage());
//        }
//        return errors;
//    }


}
