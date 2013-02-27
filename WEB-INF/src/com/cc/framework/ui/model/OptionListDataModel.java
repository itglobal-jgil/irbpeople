/*
 * $Header: d:/repository/cvs/cc-framework/source/com/cc/framework/ui/model/OptionListDataModel.java,v 1.6 2005/02/16 18:13:33 P001001 Exp $
 * $Revision: 1.6 $
 * $Date: 2005/02/16 18:13:33 $
 *
 * ====================================================================
 *
 * Copyright (c) 2000 - 2005 SCC Informationssysteme GmbH. All rights
 * reserved.
 * Vendor URL : http://www.scc-gmbh.com
 * Product URL: http://www.common-controls.com
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL SCC INFORMATIONSSYSTEME GMBH OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 */

package com.cc.framework.ui.model;

/**
 * This interface specifies the meothods which are neccessary
 * for the elements of an option list. An Option list is used
 * within the select tag to display the available values.
 *
 * @author   <a href="mailto:hschulz@scc-gmbh.com">Harald Schulz</a>
 * @version  $Revision: 1.6 $
 * @since    1.0
 */
public interface OptionListDataModel extends DataModel {

	/**
	 * Returns the key for the speciefied index
	 * 
	 * @param	index	The index
	 * @return	Object
	 */
	public Object getKey(int index);

	/**
	 * Returns the value for the speciefied index
	 * 
	 * @param	index	The index
	 * @return	String	
	 */
	public Object getValue(int index);

	/**
	 * Returns the tooltip for the speciefied index
	 * 
	 * @param	index	The index
	 * @return	String
	 */
	public String getTooltip(int index);

	/**
	 * Returns the Numer of Itmes in the OptionList
	 * 
	 * @return The Numer of Itmes
	 */
	public int size();
}
