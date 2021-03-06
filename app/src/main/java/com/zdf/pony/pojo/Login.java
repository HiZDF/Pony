package com.zdf.pony.pojo;

import java.io.Serializable;
import java.util.List;

public class Login {

    /**
     * code : 200
     * datas : [{"subCpyName":"兰考加气站","loginAccount":"zdf","mainCpyId":"71a373b7-0a06-4a3d-9952-d963851e8a90","subCpyId":"908b4924-43a1-48c1-93f9-f61cf6f8c1de","roleName":"员工","loginUserId":"01cfcd4d-0d88-410e-aef3-1b408c48a8e5","mainCpyName":"绿能集团","userName":"\u0000高飞","loginStatus":10}]
     * message : 成功
     */

    private int code;
    private String message;
    private List<DatasBean> datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements Serializable {
        /**
         * subCpyName : 兰考加气站
         * loginAccount : zdf
         * mainCpyId : 71a373b7-0a06-4a3d-9952-d963851e8a90
         * subCpyId : 908b4924-43a1-48c1-93f9-f61cf6f8c1de
         * roleName : 员工
         * loginUserId : 01cfcd4d-0d88-410e-aef3-1b408c48a8e5
         * mainCpyName : 绿能集团
         * userName :  高飞
         * loginStatus : 10
         */

        private String subCpyName;
        private String loginAccount;
        private String mainCpyId;
        private String subCpyId;
        private String roleName;
        private String loginUserId;
        private String mainCpyName;
        private String userName;
        private int loginStatus;

        public String getSubCpyName() {
            return subCpyName;
        }

        public void setSubCpyName(String subCpyName) {
            this.subCpyName = subCpyName;
        }

        public String getLoginAccount() {
            return loginAccount;
        }

        public void setLoginAccount(String loginAccount) {
            this.loginAccount = loginAccount;
        }

        public String getMainCpyId() {
            return mainCpyId;
        }

        public void setMainCpyId(String mainCpyId) {
            this.mainCpyId = mainCpyId;
        }

        public String getSubCpyId() {
            return subCpyId;
        }

        public void setSubCpyId(String subCpyId) {
            this.subCpyId = subCpyId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getLoginUserId() {
            return loginUserId;
        }

        public void setLoginUserId(String loginUserId) {
            this.loginUserId = loginUserId;
        }

        public String getMainCpyName() {
            return mainCpyName;
        }

        public void setMainCpyName(String mainCpyName) {
            this.mainCpyName = mainCpyName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getLoginStatus() {
            return loginStatus;
        }

        public void setLoginStatus(int loginStatus) {
            this.loginStatus = loginStatus;
        }
    }
}
