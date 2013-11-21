package presentation.actions.oAlumni_personalSys;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import presentation.formbeans.oAlumni_personalSys.Action_delete_page_alumni_personal_Form;
import presentation.formbeans.objects.Alumni_personal_Form;
import presentation.formbeans.objects.Alumni_titles_Form;
import presentation.formbeans.objects.Gender_Form;
import presentation.formbeans.objects.Nationality_Form;
import utils.Pair;
import utils.actions.NavigationFunctions;
import utils.beanUtils.ExtendedBeanUtils;
import utils.filter.ListConfigurator;
import utils.formbeans.FormBeanManager;
import utils.formbeans.ToStringComparator;
import utils.userUtils.UserUtils;
import bussineslogic.controlers.UseCaseFacade;
import bussineslogic.objects.Alumni_personal;
import bussineslogic.objects.Alumni_titles;
import bussineslogic.objects.Gender;
import bussineslogic.objects.Nationality;

/**
 * 
 * @author Automatika - JustInMind SL
 * 
 */
public class Action_delete_page_alumni_personal extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		/** 1. We obtain the user Information */
		String usercode = UserUtils.getCurrentUsuarioId(request);
		Locale locale = UserUtils.getCurrentLocale(request);

		/**
		 * 2. We set this page as a input point (see
		 * NavigationFunctions.setInputPoint function for more info).
		 */
		NavigationFunctions.setInputPoint(request, mapping.getPath());

		/**
		 * 3. We obtain the initial form bean and we put it to a new
		 * FormBeanManager.
		 */

		Action_delete_page_alumni_personal_Form action_delete_page_alumni_personal_Form = (Action_delete_page_alumni_personal_Form) form;

		FormBeanManager fbManager = new FormBeanManager(request, action_delete_page_alumni_personal_Form);

		/** 4. We obtain the initial POJO. */

		Alumni_personal alumni_personal = UseCaseFacade.ObtainAlumni_personal(usercode, action_delete_page_alumni_personal_Form.getAlumni_personalcode());

		/**
		 * 5. In case a BOAdder exists in the following page, we reed the info
		 * from the BOAdder.
		 */

		/** 6. We Prepare the values that will be used in the next jsp */
		/** 6.1. We create a new FormBeanManager (and delete the old one) */

		fbManager.cleanContainer();

		fbManager = new FormBeanManager(request, Action_delete_page_alumni_personal_Form.class);

		/**
		 * 6.2. We add the current POJO merged with the nested-pojo-form-bean to
		 * the manager.
		 */
		Alumni_personal_Form alumni_personal_Form = action_delete_page_alumni_personal_Form.getAlumni_personal_Form();
		alumni_personal_Form.setAlumni_communications(alumni_personal.getIalumni_communicationsdescription_array());
		fbManager.setAttribute(alumni_personal, "alumni_personal_Form", Alumni_personal_Form.class, alumni_personal_Form);

		/** 6.3. We add the container of the manager to the request. */

		request.setAttribute("oAlumniPersonalSys__action_delete_page_alumni_personal_Form", fbManager.getContainer());

		/**
		 * 6.4. We add the values of all (if any) of the support tables which
		 * will be used in the jsp (for selectables) to the request.
		 */

		Pair<Integer, List<Gender>> _selec_gender = UseCaseFacade.ObtainAllGender(usercode, new ListConfigurator());
		List<Gender_Form> _selec_gender_Form = ExtendedBeanUtils.copyPropertiesToFormBean(_selec_gender.getSecond(), locale, Gender_Form.class);
		Collections.sort(_selec_gender_Form, new ToStringComparator());
		request.setAttribute("_selec_gender", _selec_gender_Form);

		Pair<Integer, List<Nationality>> _selec_nationality = UseCaseFacade.ObtainAllNationality(usercode, new ListConfigurator());
		List<Nationality_Form> _selec_nationality_Form = ExtendedBeanUtils.copyPropertiesToFormBean(_selec_nationality.getSecond(), locale, Nationality_Form.class);
		Collections.sort(_selec_nationality_Form, new ToStringComparator());
		request.setAttribute("_selec_nationality", _selec_nationality_Form);

		Pair<Integer, List<Alumni_titles>> _selec_alumni_titles = UseCaseFacade.ObtainAllAlumni_titles(usercode, new ListConfigurator());
		List<Alumni_titles_Form> _selec_alumni_titles_Form = ExtendedBeanUtils.copyPropertiesToFormBean(_selec_alumni_titles.getSecond(), locale, Alumni_titles_Form.class);
		request.setAttribute("_selec_alumni_titles", _selec_nationality_Form);

		return NavigationFunctions.findForward(request, mapping, "success");

	}
}