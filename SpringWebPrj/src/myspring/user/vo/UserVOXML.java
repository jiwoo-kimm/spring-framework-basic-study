package myspring.user.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
public class UserVOXML {
	private String status;
	private List<UserVO> userList;

	public UserVOXML() {}

	public UserVOXML(String status, List<UserVO> userList) {
		this.status = status;
		this.userList = userList;
	}
	@XmlElement	// name 생략 가능
	public void setStatus(String status) { this.status = status; }
	
	@XmlElement(name="user")
	public void setUserList(List<UserVO> userList) { this.userList = userList; }
	
	public String getStatus() { return status; }
	public List<UserVO> getUserList() { return userList; }
}
