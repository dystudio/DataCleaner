/**
 * eobjects.org DataCleaner
 * Copyright (C) 2010 eobjects.org
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.eobjects.datacleaner.extension.networktools;

import org.eobjects.analyzer.data.MockInputColumn;
import org.eobjects.analyzer.data.MockInputRow;

import junit.framework.TestCase;

public class ResolveHostnameTransformerTest extends TestCase {

	public void testTransform() throws Exception {
		ResolveHostnameTransformer t = new ResolveHostnameTransformer();
		MockInputColumn<String> col = new MockInputColumn<String>("host",
				String.class);
		t.hostnameColumn = col;

		assertEquals("OutputColumns[host (ip address)]", t.getOutputColumns()
				.toString());

		assertEquals("127.0.0.1",
				t.transform(new MockInputRow().put(col, "localhost"))[0]);

		assertEquals("127.0.0.1",
				t.transform(new MockInputRow().put(col, "127.0.0.1"))[0]);

		assertEquals("173.45.233.40",
				t.transform(new MockInputRow().put(col, "eobjects.org"))[0]);
		
		assertEquals(null,
				t.transform(new MockInputRow().put(col, ""))[0]);
		
		assertEquals(null,
				t.transform(new MockInputRow().put(col, null))[0]);
		
		assertEquals(null,
				t.transform(new MockInputRow().put(col, "lmdslfsm flskmf lskmfls kmslf kdmlfsk mflsk fmsl kfdmsl"))[0]);
	}
}
