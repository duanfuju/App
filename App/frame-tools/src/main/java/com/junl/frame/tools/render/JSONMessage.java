package com.junl.frame.tools.render;

/**
 * 
 * @author chenmaolong
 * @date 2016年3月29日 下午3:22:39
 * @description 
 *		响应json信息
 */
public class JSONMessage {
    private String code;
    private String message;
    private boolean result;
    private boolean success;
    private Object data;
    public JSONMessage(boolean result,String message) {
        this.message = message;
        this.result = result;
        this.success=result;
    }
    public JSONMessage( boolean result,String code, String message) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.success=result;
    }
    public JSONMessage( boolean result,Object data) {
        this.data = data;
        this.result = result;
        this.success=result;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public boolean isResult() {
        return result;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
