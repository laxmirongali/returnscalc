package com.company.fingoals.service;

import java.util.List;

import junit.framework.TestCase;

import com.company.fingoals.dto.Company;

public class SymbolLookupTest extends TestCase {

	public void testLookup() throws Exception {
		SymbolLookup s = new SymbolLookup();
		List<Company> l = s.lookup("apple");
		assertNotNull("it cannot be null", l );
	}

}
