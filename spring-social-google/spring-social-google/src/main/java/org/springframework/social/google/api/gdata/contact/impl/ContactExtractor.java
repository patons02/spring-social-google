/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.google.api.gdata.contact.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nu.xom.Element;

import org.springframework.social.google.api.gdata.contact.Contact;
import org.springframework.social.google.api.gdata.contact.Email;
import org.springframework.social.google.api.gdata.contact.Phone;
import org.springframework.social.google.api.gdata.impl.EntryExtractor;

/**
 * {@link EntryExtractor} for {@link Contact}.
 * @author Gabriel Axel
 */
public class ContactExtractor extends EntryExtractor<Contact> {

	@Override
	public Contact extractEntry(Element element) {
		String id = getId(element);
		String pictureUrl = getLinkHref(element, "http://schemas.google.com/contacts/2008/rel#photo");
		String self = getSelf(element);
		Date updated = getUpdated(element);
		
		String namePrefix = getNestedGDataValue(element, "name", "namePrefix");
		String firstName = getNestedGDataValue(element, "name", "givenName");
		String middleName = getNestedGDataValue(element, "name", "additionalName");
		String lastName = getNestedGDataValue(element, "name", "familyName");
		String nameSuffix = getNestedGDataValue(element, "name", "nameSuffix");
		
		List<String> groupIds = getValues(element, "gContact:groupMembershipInfo", "deleted", "false", "href");
		
		List<Element> emailElements = getGDataElements(element, "email");
		List<Email> emails = new ArrayList<Email>();
		for(Element emailElement : emailElements) {
			String rel = emailElement.getAttributeValue("rel");
			String label = emailElement.getAttributeValue("label");
			String address = emailElement.getAttributeValue("address");
			boolean primary = Boolean.valueOf(emailElement.getAttributeValue("primary"));
			emails.add(new Email(rel, label, address, primary));
		}

		List<Element> phoneElements = getGDataElements(element, "phoneNumber");
		List<Phone> phones = new ArrayList<Phone>();
		for(Element phoneElement : phoneElements) {
			String rel = phoneElement.getAttributeValue("rel");
			String label = phoneElement.getAttributeValue("label");
			String number = phoneElement.getValue();
			boolean primary = Boolean.valueOf(phoneElement.getAttributeValue("primary"));
			phones.add(new Phone(rel, label, number, primary));
		}
		
		return new Contact(id, self, updated, namePrefix, firstName, middleName, lastName, nameSuffix, pictureUrl, groupIds, emails, phones);
	}

}
