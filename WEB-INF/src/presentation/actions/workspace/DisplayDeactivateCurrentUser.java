package presentation.actions.workspace;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussineslogic.objects.Usuario;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import utils.actions.NavigationFunctions;
import utils.formbeans.FormBeanManager;
import utils.userUtils.UserUtils;
import bussineslogic.controlers.UseCaseFacade;
import presentation.formbeans.objects.UsuarioForm;
import presentation.formbeans.user.UsuarioContainerForm;

public class DisplayDeactivateCurrentUser extends Action {

    @Override
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
    	NavigationFunctions.setInputPoint(request, mapping.getPath());
    	//Load data
    	String usercode = UserUtils.getCurrentUsuarioId(request); 
    	Locale locale = UserUtils.getCurrentLocale(request);              
    	
    	UsuarioContainerForm usuarioForm = (UsuarioContainerForm) form;
    	FormBeanManager formBeanManager=new FormBeanManager(request, usuarioForm);
    	//use case execution
    	Usuario usuario = UseCaseFacade.ObtenerUsuario(usercode, usercode);
    	
    	//clear
    	formBeanManager.cleanContainer();
    	
    	//write data
        formBeanManager=new FormBeanManager(request, UsuarioContainerForm.class);
        /*if(usuarioForm.getUsuarioForm().getPassword()==null){
        	
        }*/
        formBeanManager.setAttribute(usuario, "usuarioForm", UsuarioForm.class,usuarioForm.getUsuarioForm());
        usuarioForm=(UsuarioContainerForm) formBeanManager.getContainer();
        usuarioForm.getUsuarioForm().setPassword("");
        request.setAttribute("usuarioContainerForm", usuarioForm);       
        
		return NavigationFunctions.findForward(request, mapping, "success");
    }
    
    
    
    

}