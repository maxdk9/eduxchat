package and.mazzy.chat.mvp;

public interface LoginModel {
    interface  onLoginFinishedListener{
        void onCancelled();

        void onPasswordError();

        void onSuccess();

    }

    void onLogin(String userName, String userPassword, onLoginFinishedListener listener);
}
