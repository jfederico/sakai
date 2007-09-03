/**********************************************************************************
 * $URL$
 * $Id$
 ***********************************************************************************
 *
 * Copyright (c) 2003, 2004, 2005, 2006, 2007 The Sakai Foundation.
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.search.journal.api;

import org.sakaiproject.search.indexer.api.IndexJournalException;

/**
 * The journal manage manages the state of the journal for the current node
 * @author ieb
 *
 */
public interface JournalManager
{

	/**
	 * @param version
	 * @return
	 * @throws JournalErrorException if there was an error getting the next version 
	 */
	long getNextVersion(long version) throws JournalErrorException;

	/**
	 * @param transactionId
	 * @return
	 * @throws IndexJournalException 
	 */
	JournalManagerState prepareSave(long transactionId) throws IndexJournalException;

	/**
	 * @param jms 
	 * @throws IndexJournalException 
	 * 
	 */
	void commitSave(JournalManagerState jms) throws IndexJournalException;

	/**
	 * @param jms
	 */
	void rollbackSave(JournalManagerState jms);

}
