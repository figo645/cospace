package grass.tree.action;

import java.util.Enumeration;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.LoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AjaxLoginAction extends CommonBaseAction {

	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("login");
		LoginForm loginForm = (LoginForm) form;
		Enumeration enumeration  =  request.getParameterNames();
		for(int i=0;enumeration.hasMoreElements();i++){
			Object obj = enumeration.nextElement();
			String param = request.getParameter(String.valueOf(obj));
			System.out.println(param);
		}
		
		return null;
		// if (null != loginForm.getUsername() && null !=
		// loginForm.getPasswords()
		// && loginForm.getUsername().equals("admin")
		// && loginForm.getPasswords().equals("admin")) {
		// request.getSession().setAttribute("user", loginForm);
		// // TODO Auto-generated method stub
		// return mapping.findForward("success");
		// } else {
		// // TODO Auto-generated method stub
		// return mapping.findForward("failure");
		// }

	}

}
