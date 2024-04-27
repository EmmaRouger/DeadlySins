public class Account {
    private String username;
    private char [] password;

    Account(String sentUser, String sentPass){
        // Ignore the lack of checking, it's irrelevant for what is being tested
        username = sentUser;
        password = sentPass.toCharArray();
    }

    boolean Login(String user, String pass){
        boolean valid = false;

        char [] tempPass = pass.toCharArray();
        if (user.equals(username)){
            valid = true;
            for (int i = 0; i < tempPass.length; i++) {
                if (tempPass[i] != password[i]) {
                    valid = false;
                    break;
                }
            }   
        }

        return valid;

    }

}
