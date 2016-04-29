
/*
 * Copyright 2015 The original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vaadin.guice.access;;

import com.vaadin.ui.UI;

/**
 * Implementations of this interface will be consulted before the
 * {@link com.vaadin.guice.server.GuiceViewProvider} creates a view
 * instance. If any of the view access controls deny access, the view provider
 * will act like no such view ever existed, or show an
 * {@link com.vaadin.guice.annotation.GuiceView#isAccessDeniedView()
 * * access denied view}.
 *
 * Access control beans implementing this interface are called before a view
 * instance is created but can access the annotations on the view bean class
 * through the application context. Unless contextual information from the view
 * instance is needed, this interface should be used instead of a
 * {@link ViewInstanceAccessControl}.
 *
 * @author Petter Holmström (petter@vaadin.com)
 * @author Henri Sara (hesara@vaadin.com)
 */
public interface ViewAccessControl {

    /**
     * Checks if the current user has access to the specified view and UI.
     *
     * @param ui
     *            the UI, never {@code null}.
     * @param beanName
     *            the bean name of the view, never {@code null}.
     * @return true if access is granted, false if access is denied.
     */
    boolean isAccessGranted(UI ui, String beanName);

}