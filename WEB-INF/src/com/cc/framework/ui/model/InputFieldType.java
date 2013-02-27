/*
 * $Header: d:/repository/cvs/cc-framework/source/com/cc/framework/ui/model/InputFieldType.java,v 1.14 2005/08/08 10:04:36 P001002 Exp $
 * $Revision: 1.14 $
 * $Date: 2005/08/08 10:04:36 $
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

import java.io.Serializable;

import com.cc.framework.common.InvalidEnumType;
import com.cc.framework.common.SimpleEnumType;

/**
 * Enumeration Input-Types
 * 
 * @author <a href="mailto:hschulz@scc-gmbh.com">Harald Schulz</a>
 * @version $Revision: 1.14 $
 */
public final class InputFieldType implements SimpleEnumType, Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6386553398436098246L;

	/** InputFieldType: TEXT */
	public static final InputFieldType TEXT = new InputFieldType("text");

	/** InputFieldType: PASSWORD */
	public static final InputFieldType PASSWORD = new InputFieldType("password");

	/** InputFieldType: FILE */
	public static final InputFieldType FILE = new InputFieldType("file");

	/** InputFieldType: RADIO */
	public static final InputFieldType RADIO = new InputFieldType("radio");

	/** InputFieldType: CHECKBOX */
	public static final InputFieldType CHECKBOX = new InputFieldType("checkbox");

	/** InputFieldType: HIDDEN */
	public static final InputFieldType HIDDEN = new InputFieldType("hidden");

	/**
	 * Internal Type
	 */
	private String type;

	/**
	 * Collection with all Elemenets
	 */
	private static final InputFieldType[] ALL = { TEXT, PASSWORD, FILE, RADIO,
			CHECKBOX, HIDDEN };

	/**
	 * Constructor
	 * 
	 * @param type
	 *            Type
	 */
	private InputFieldType(String type) {
		this.type = type;
	}

	/**
	 * Returns the Type
	 * 
	 * @return String
	 */
	public String toString() {
		return type;
	}

	/**
	 * Compares this type to the specified object.
	 * 
	 * @param obj
	 *            The object to compare this <code>InputFieldType</code>
	 *            object against.
	 * @return <code>true</code> if the internal types are equal;
	 *         <code>false</code> otherwise.
	 */
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		} else if (obj instanceof String) {
			return type.equals(obj);
		} else if (obj instanceof InputFieldType) {
			return type.equals(((InputFieldType) obj).type);
		}

		return false;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return type.hashCode();
	}

	/**
	 * Creates for the argument an Object of Type InputFieldType
	 * 
	 * @param code
	 *            String to parse
	 * @return InputFieldType
	 */
	public static InputFieldType parse(String code) {

		for (int index = 0; index < ALL.length; index++) {
			if (ALL[index].equals(code)) {
				return ALL[index];
			}
		}

		throw new InvalidEnumType("Invalid InputFieldType: " + code);
	}
}