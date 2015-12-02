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
package com.vaadin.guice.server;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

abstract class AbstractScope implements Scope, SessionDestroyListener, SessionInitListener {

    private final Map<VaadinSession, Map<Key, Object>> sessionToScopedObjectsMap = new ConcurrentHashMap<VaadinSession, Map<Key, Object>>();

    @Override
    public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscoped) {
        return new Provider<T>() {
            @Override
            @SuppressWarnings("unchecked")
            public T get() {
                Map<Key, Object> map = sessionToScopedObjectsMap.get(VaadinSession.getCurrent());

                T t = (T) map.get(key);

                if (t == null) {
                    t = unscoped.get();
                    map.put(key, t);
                }

                return t;
            }
        };
    }

    @Override
    public void sessionDestroy(SessionDestroyEvent event) {
        sessionToScopedObjectsMap.remove(event.getSession());
    }

    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        sessionToScopedObjectsMap.put(event.getSession(), new ConcurrentHashMap<Key, Object>());
    }
}