package presentation.actions.oAlumni_irb_job_positionsSys;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Collections;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import utils.formbeans.ToStringComparator;
import utils.actions.NavigationFunctions;
import utils.actions.BOAdderFunctions;
import utils.formbeans.FormBeanManager;
import utils.formbeans.BOAdderFormBean;
import utils.userUtils.UserUtils;
import utils.Pair;
import utils.listFilter.ViewListConfiguration;
import utils.beanUtils.ExtendedBeanUtils;
import utils.filter.ListConfigurator;

import bussineslogic.controlers.UseCaseFacade;

import bussineslogic.objects.*;
import presentation.formbeans.objects.*;

	import presentation.formbeans.oAlumni_irb_job_positionsSys.*;


/**
 * 
 * @author Automatika - JustInMind SL
 *
 */
public class Action_new_new_page_alumni_irb_job_positions extends Action {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {    	    	    

    	/** 1.  We obtain the user Information */
    	String usercode = UserUtils.getCurrentUsuarioId(request); 
    	Locale locale = UserUtils.getCurrentLocale(request); 
    	


	
	/** 2.  We obtain the initial form bean and we put it to a new FormBeanManager. */
	
Action_new_new_page_alumni_irb_job_positions_Form action_new_new_page_alumni_irb_job_positions_Form=(Action_new_new_page_alumni_irb_job_positions_Form) form;

FormBeanManager fbManager=new FormBeanManager(request, action_new_new_page_alumni_irb_job_positions_Form);	
	
	/** 3.  We use the business logic to create the new item */
	
	Alumni_irb_job_positions alumni_irb_job_positions = UseCaseFacade.CreateAlumni_irb_job_positions(usercode,(Alumni_irb_job_positions) fbManager.getPOJO("alumni_irb_job_positions_Form",Alumni_irb_job_positions.class));	
	
	/** 4.  In case that a BOAdder exists in the previous jsp, we update the list of values */
	
	

	/** 5.  We clean the current container */
	fbManager.cleanContainer();

	/** 6.  We return to the correct page (introducing some values to the request if necessary) */
	Pair<Integer, List<Alumni_job_position_types>> _selec_alumni_job_position_types= UseCaseFacade.ObtainAllAlumni_job_position_types(usercode,  new ListConfigurator());
	List<Alumni_job_position_types_Form> _selec_alumni_job_position_types_Form = ExtendedBeanUtils.copyPropertiesToFormBean(_selec_alumni_job_position_types.getSecond(), locale, Alumni_job_position_types_Form.class);
	Collections.sort(_selec_alumni_job_position_types_Form, new ToStringComparator());
	request.setAttribute("_selec_alumni_job_position_types", _selec_alumni_job_position_types_Form);
	
/** 6.1.  We look if the current page is beeing opened in a popup window. */
boolean isPopUp = NavigationFunctions.isPopUpWindow(request);
/** 6.2.  We look for the forward to execute (we put the current object in case it is used in the next page) */

return NavigationFunctions.findForward(request, mapping, "success", "alumni_irb_job_positionscode="+alumni_irb_job_positions.getAlumni_irb_job_positionscode(), isPopUp, alumni_irb_job_positions.getCode(), alumni_irb_job_positions.toString());
	
	
		}
}