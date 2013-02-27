package presentation.actions.oCalendarSys;


import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.formbeans.oCalendarSys.Action_add_calendar_Form;
import presentation.formbeans.oCalendarSys.Action_modify_calendar_Form;
import presentation.formbeans.objects.Irbholiday_Form;
import presentation.formbeans.objects.Irbholidayinfo_Form;
import presentation.formbeans.objects.TypeIrbholiday_Form;
import uicomponents.scheduler.SchedulerFacadeForCommonControlsScheduler;
import utils.actions.NavigationFunctions;
import utils.beanUtils.ExtendedBeanUtils;
import utils.formbeans.FormBeanManager;
import utils.userUtils.UserUtils;
import bussineslogic.controlers.UseCaseFacade;
import bussineslogic.objects.Irbholiday;
import bussineslogic.objects.Irbholidayinfo;


/**
 * 
 * @author Factory - JustInMind SL
 *
 */
public class Action_modify_calendar extends Action {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {    	    	    

    	/** 1.  We obtain the user Information */
    	String usercode = UserUtils.getCurrentUsuarioId(request); 
    	Locale locale = UserUtils.getCurrentLocale(request); 
    	
    	
    	/** 2.  We set this page as a input point (see NavigationFunctions.setInputPoint function for more info). */
    	NavigationFunctions.setInputPoint(request, mapping.getPath());
    	

    	/** 3.  We obtain the initial form bean and we put it to a new FormBeanManager. */
    	
    Action_modify_calendar_Form action_modify_calendar_Form=(Action_modify_calendar_Form) form;
    
    int yearCal = SchedulerFacadeForCommonControlsScheduler.getViewYear(request);

    FormBeanManager fbManager=new FormBeanManager(request, action_modify_calendar_Form);
    
    Irbholiday irbholiday = UseCaseFacade.ObtainIrbholiday(usercode, action_modify_calendar_Form.getIrbholidaycode());
    
    Irbholiday_Form irbholiday_Form = action_modify_calendar_Form.getIrbholiday_Form();
    
    ExtendedBeanUtils.copyPropertiesToFormBean(irbholiday_Form, irbholiday, locale);
    
    Irbholidayinfo irbholidayinfo = UseCaseFacade.ObtainIrbholidayinfoFromPersonal(usercode, 
    		action_modify_calendar_Form.getPersonalcode(), new GregorianCalendar(yearCal, 0, 1));

	fbManager.cleanContainer();
    
    fbManager=new FormBeanManager(request, Action_add_calendar_Form.class);
	
    fbManager.setAttribute(irbholiday, "irbholiday_Form", Irbholiday_Form.class, irbholiday_Form);
    fbManager.setAttribute(irbholidayinfo, "irbholidayinfo_Form", Irbholidayinfo_Form.class);
	
	request.setAttribute("oCalendarSys__action_modify_calendar_Form", fbManager.getContainer());
	
	
	List<TypeIrbholiday_Form> _selec_type = Irbholiday_Form.getTypes(locale);
	
	request.setAttribute("_selec_type", _selec_type);
		

		/** 4.  We navigate to the correct page. */		
		
		return NavigationFunctions.findForward(request, mapping, "success");
		
		
			}

}