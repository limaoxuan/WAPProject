package model;

public class AdminUser {

    private String loginName;
    private String adminPwd;

    public AdminUser(String loginName, String adminPwd) {
        this.loginName = loginName;
        this.adminPwd = adminPwd;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
}
