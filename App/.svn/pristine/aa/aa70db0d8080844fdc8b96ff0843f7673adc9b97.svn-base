package com.junl.apps.service.users;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junl.apps.mapper.UserMapper;
import com.junl.apps.model.UserModel;
import com.junl.apps.service.peizhi.PeizhiImpl;
import com.junl.frame.core.common.page.PageInfo;
import com.junl.frame.tools.ToolPbkdf2;
import com.junl.frame.tools.string.StringUtils;

@Service
public class UsersImpl implements IUsers {
	
	@Autowired
	private UserMapper mapper;
	@Autowired
	private PeizhiImpl peizhiImpl;

	public List<UserModel> doLogin() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		PageInfo pageinfo = new PageInfo();
		pageinfo.setLimit(5);
		pageinfo.setPageNo(2);
		pageinfo.setSort(true);
		pageinfo.setSortName("stopdate");
		pageinfo.setSortType("desc");
		
		params.put("page", pageinfo);
		
		return mapper.queryListPage(params);
	}

	/**
	 * 根据用户名获取数据
	 * @return
	 */
	public Map<String, Object> queryUserByUserName(Map<String, Object> params) throws Exception {
		 Map<String, Object> m= new HashMap<>();
		UserModel user=mapper.queryObject(params);
		if (user!=null) {
			byte[] salt=user.getSalt();
			byte[] password=user.getPassword();
			
			boolean bool = false;
			try {
				//验证密码
				bool = ToolPbkdf2.authenticate(params.get("password").toString(),password, salt);
				if (bool) {
					m.put("state", "登陆成功");
					m.put("user", user);
					//获取权限
					String role=user.getGroupids();
					if (StringUtils.isEmpty(StringUtils.changNull(role))) {
						m.put("roles", -1);
					}else{
						String[] role_s=role.split(",");
						List<Map<String, Object>> roles=peizhiImpl.queryUserRole(role_s);
						//手机的权限字符串
						String phoneRole_s="";
						for (int i = 0; i < roles.size(); i++) {
							Map<String, Object> map=roles.get(i);
							phoneRole_s+=map.get("phoneRole")+",";
						}
						//手机的权限（未去重）
						String[] phoneRole_1=phoneRole_s.split(",");
						String[] phoneRole_2=array_unique(phoneRole_1);
						m.put("roles", phoneRole_2);
					}
				}else{
					m.put("state", "密码错误");
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}else{
			m.put("state", "该用户名不存在");
		}
		return m;
	}
	

	//去除数组中重复的记录  
	public static String[] array_unique(String[] a) {  
	    // array_unique  
	    List<String> list = new LinkedList<String>();  
	    for(int i = 0; i < a.length; i++) { 
	    	if (a[i]==null||a[i].equals("null")||a[i].equals("")) {
				continue;
			}
	        if(!list.contains(a[i])) {  
	            list.add(a[i]);  
	        }  
	       
	    }  
	    return (String[])list.toArray(new String[list.size()]);  
	}

}
