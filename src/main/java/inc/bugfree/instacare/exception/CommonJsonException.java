package inc.bugfree.instacare.exception;

public class CommonJsonException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    // 异常编码
    private Integer code;
    // 异常自定义信息
    private String customMsg;

    public CommonJsonException() {
    }

    public CommonJsonException(Integer code, String customMsg) {
        super();
        this.code = code;
        this.customMsg = customMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }

}