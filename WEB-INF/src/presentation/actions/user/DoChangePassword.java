package presentation.actions.user;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussineslogic.objects.Usuario;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import utils.actions.NavigationFunctions;
import utils.userUtils.UserUtils;
import bussineslogic.controlers.UseCaseFacade;
import presentation.formbeans.user.ChangePasswordForm;

public class DoChangePassword extends Action {

    @Override
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
           	
    	//Load data
    	String usercode = UserUtils.getCurrentUsuarioId(request); 
    	Locale locale = UserUtils.getCurrentLocale(request);   	
    	
    	ChangePasswordForm passwordForm = (ChangePasswordForm)form;
                                           
    	if(passwordForm.getPassword().equalsIgnoreCase(passwordForm.getPassword2())){
	    	//Use case execution    		
	   		Usuario usuario = UseCaseFacade.ModificarPassword(usercode,passwordForm.getUsuariocode(),passwordForm.getPassword());
        	ActionErrors errors=new ActionErrors();
        	ActionMessages messages=new ActionMessages();
        	messages.add("info.password-cambiado-correctamente", new ActionMessage("info.password-cambiado-correctamente"));
        	errors.add(messages);
        	request.setAttribute(Globals.ERROR_KEY, errors);		   		
    		return NavigationFunctions.findForward(request, mapping, "success");
    	}
        
        else {
        	ActionErrors errors=new ActionErrors();
        	ActionMessages messages=new ActionMessages();
        	messages.add("errors.password-no-coincide", new ActionMessage("errors.password-no-coincide"));
        	errors.add(messages);
        	request.setAttribute(Globals.ERROR_KEY, errors);        	
        	        	
        	return mapping.findForward("error");
        }                
    }
    
    
    
    

}