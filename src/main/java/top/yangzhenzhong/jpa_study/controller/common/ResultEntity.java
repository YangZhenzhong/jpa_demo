package top.yangzhenzhong.jpa_study.controller.common;

import top.yangzhenzhong.jpa_study.exception.constants.ResultEnum;

import java.io.Serializable;

/**
 * @author guoyk8@chinaunicom.cn
 * @date 2018/6/14 15:34
 * @description 响应实体
 */
public class ResultEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code = ResultEnum.SUCCESS.code;
	private String msg = ResultEnum.SUCCESS.msg;

	private String txid;

	private T data;

	public ResultEntity() {
	}

	public ResultEntity( T data ) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg( String msg ) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData( T data ) {
		this.data = data;
	}

	public String getTxid() {
		String localTxId = LocalData.TXID.get();
		if (localTxId != null) {
			return localTxId;
		}
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"code\":\"")
				.append(code).append('\"');
		sb.append(",\"msg\":\"")
				.append(msg).append('\"');
		sb.append(",\"txid\":\"")
				.append(LocalData.TXID.get()).append('\"');
		sb.append(",\"data\":")
				.append(data);
		sb.append('}');
		return sb.toString();
	}
}


