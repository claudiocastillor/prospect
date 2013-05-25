package cl.crm.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 6915338313011172928L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String resultado;
		Map session = invocation.getInvocationContext().getSession();
		Object usr = (Object) session.get("usuario");
		
		if(usr == null){
			resultado = "no_login";
		}else{
			resultado = invocation.invoke();
		}
		
		return resultado;
	}
}