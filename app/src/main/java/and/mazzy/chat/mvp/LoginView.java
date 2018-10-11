package and.mazzy.chat.mvp;

public interface LoginView {
    void ShowProgress(boolean showProgress);

    void setUserNameError(Integer resId);

    void setUserPasswordError(Integer resId);

    void SuccessAction();
}
