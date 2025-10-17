/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.components;

import java.util.Collections;
import java.util.Set;

/**
 * Represents a Listen Port definition for a {@link PropertyDescriptor} that specifies a listen port
 */
public class StandardListenPortDefinition implements ListenPortDefinition {

    private final TransportProtocol transportProtocol;
    private final Set<String> applicationProtocols;

    /**
     * Create a {@link ListenPortDefinition}.
     *
     * @param transportProtocol - the layer 4 transport protocol used by the listen port
     * @param applicationProtocols - if applicable, one or more application protocols supported by the listen port
     */
    public StandardListenPortDefinition(TransportProtocol transportProtocol, Set<String> applicationProtocols) {
        this.transportProtocol = transportProtocol;
        this.applicationProtocols = applicationProtocols != null ? applicationProtocols : Collections.emptySet();
    }

    /**
     * Create a {@link ListenPortDefinition} without any application protocols.
     *
     * @param transportProtocol - the layer 4 transport protocol used by the listen port
     */
    public StandardListenPortDefinition(final TransportProtocol transportProtocol) {
        this(transportProtocol, Collections.emptySet());
    }

    @Override
    public TransportProtocol getTransportProtocol() {
        return transportProtocol;
    }

    @Override
    public Set<String> getApplicationProtocols() {
        return applicationProtocols;
    }
}
