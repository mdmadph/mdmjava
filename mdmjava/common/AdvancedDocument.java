package common;

import lotus.domino.Document;
import lotus.domino.Item;
import lotus.domino.NotesException;

/**
 * @author mdm-adph
 * @alias AdvancedDocument
 */
public class AdvancedDocument {

	/**
	 * The underlying lotus.domino.Document
	 */
	private Document doc;
	
	/**
	 * Default constructor
	 */
	public AdvancedDocument() {	
	}
	
	/**
	 * Create new AdvancedDocument from passed lotus.domino.Document
	 * @param document {lotus.domino.Document}
	 * The lotus.domino.Document
	 */
	public AdvancedDocument(Document document) {
		doc = document;
	}
	
	/**
	 * Set Document fields in bulk by passing a 2D array of field names and values;
	 * field names should be strings, values are variable depending upon type of Notes item
	 * @memberOf AdvancedDocument
	 * @param values {Object[][]}
	 * A 2D array of field names and values
	 * @throws NotesException
	 */
	public void setDocValues(Object[][] values) throws NotesException {
		for (int x = 0; x < values.length; x++) {
			this.doc.replaceItemValue((String)values[x][0], values[x][1]);
		}	
	}
	
	/**
	 * Same as lotus.domino.Document
	 * @param fieldName {String}
	 * @param value {Object}
	 * @return lotus.domino.Item
	 * @throws NotesException
	 */
	public Item replaceItemValue(String fieldName, Object value) throws NotesException {
		return this.doc.replaceItemValue(fieldName, value);
	}
	
	/**
	 * Same as lotus.domino.Document
	 * @param ignoreThisVar {boolean}
	 * @param raiseerror {boolean}
	 * @return boolean
	 * @throws NotesException
	 */
	public boolean computeWithForm(boolean ignoreThisVar, boolean raiseerror) throws NotesException {
		return this.doc.computeWithForm(ignoreThisVar, raiseerror);
	}
	
	/**
	 * Same as lotus.domino.Document;
	 * @return boolean
	 * @throws NotesException
	 */
	public boolean save() throws NotesException {
		return this.doc.save();
	}
	
	/**
	 * Same as lotus.domino.Document
	 * @param force {boolean}
	 * @param makeresponse {boolean}
	 * @param makeread {boolean}
	 * @return boolean
	 * @throws NotesException
	 */
	public boolean save(boolean force, boolean makeresponse, boolean makeread) throws NotesException {
		return this.save(force, makeresponse, makeread);
	}
}
