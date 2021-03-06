/*

    hml-service-jdbi  JDBI HML service.
    Copyright (c) 2015 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.gnu.org/licenses/lgpl.html

*/
package org.nmdp.service.hml.service.jdbi;

import static org.junit.Assert.assertNotNull;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Guice;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.nmdp.service.hml.service.HmlService;

/**
 * Unit test for JdbiHmlServiceModule.
 */
public final class JdbiHmlServiceModuleTest {
    private JdbiHmlServiceModule module;

    @Mock
    private HmlDao hmlDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        module = new JdbiHmlServiceModule();
    }

    @Test
    public void testConstructor() {
        assertNotNull(module);
    }

    @Test
    public void testHmlServiceModule() {
        Injector injector = Guice.createInjector(module, new AbstractModule() {
                @Override
                protected void configure() {
                    bind(HmlDao.class).toInstance(hmlDao);
                }
            });
        assertNotNull(injector.getInstance(HmlService.class));
    }
}
