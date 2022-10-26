////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// © 2011-2021 Telenav, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.telenav.kivakit.service.registry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.telenav.kivakit.application.Application;
import com.telenav.kivakit.component.BaseComponent;
import com.telenav.kivakit.core.string.ObjectFormatter;
import com.telenav.kivakit.core.language.reflection.property.IncludeProperty;
import com.telenav.kivakit.core.time.Time;
import com.telenav.kivakit.core.vm.JavaVirtualMachineHealth;
import com.telenav.kivakit.interfaces.string.StringFormattable;
import com.telenav.kivakit.microservice.protocols.rest.openapi.OpenApiIncludeMember;
import com.telenav.kivakit.microservice.protocols.rest.openapi.OpenApiIncludeType;
import com.telenav.kivakit.network.core.LocalHost;
import com.telenav.kivakit.network.core.Port;
import com.telenav.kivakit.service.registry.internal.lexakai.DiagramRegistry;
import com.telenav.lexakai.annotations.LexakaiJavadoc;
import com.telenav.lexakai.annotations.UmlClassDiagram;
import com.telenav.lexakai.annotations.associations.UmlAggregation;
import com.telenav.lexakai.annotations.visibility.UmlExcludeSuperTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.telenav.kivakit.core.string.ObjectFormatter.ObjectFormat.SINGLE_LINE;

/**
 * A logical service of a particular type that can be registered by an application with a local or network service
 * registry, and subsequently discovered by client registry searches.
 *
 * <p><b>Service Registration and Expiration</b></p>
 *
 * <p>
 * A service of some {@link ServiceType}, with {@link ServiceMetadata} describing its function, may be registered by an
 * {@link Application} in order to bind it to an unused port on the local host and make it discoverable by clients. When
 * registered and bound, a service is visible within a particular {@link Scope} so long as the service renews its lease
 * with the registry. If the lease expires, the service is removed from the registry. Lease renewal is handled
 * automatically for applications that register a service using the service registration client.
 * </p>
 *
 * <p><b>Service Discovery</b></p>
 *
 * <p>
 * Registered services can be discovered using a service registration client, which communicates using a REST protocol
 * with the registry. The criteria that are used for service discovery is detailed in ServiceRegistryClient.
 * </p>
 *
 * <p><b>Service Properties</b></p>
 *
 * <p>
 * A service has the following properties:
 * </p>
 * <ul>
 *     <li>{@link #application()} - Identifies the application registering the service</li>
 *     <li>{@link #scope()} - The scope where the service is visible</li>
 *     <li>{@link #metadata()} - Metadata describing the service</li>
 *     <li>{@link #type()} - Service type identifier for use in searching for services</li>
 *     <li>{@link #port()} - The port that the service is bound to or {@link #UNBOUND}</li>
 *     <li>{@link #renewedAt()} - The most recent service lease renewal time</li>
 *     <li>{@link #health()} - Information about the health of the server running the service</li>
 * </ul>
 *
 * @author jonathanl (shibo)
 */
@SuppressWarnings("unused") @OpenApiIncludeType(
        description = "A particular type of service belonging to an application and running on a TCP/IP port on a host. "
                + "There can be multiple services running on a network, on a cluster, on a host and within an application. "
                + "Each service has metadata describing itself and declares a scope within which it should be visible. ")
@UmlClassDiagram(diagram = DiagramRegistry.class)
@UmlExcludeSuperTypes
@LexakaiJavadoc(complete = true)
public class Service extends BaseComponent implements Comparable<Service>, StringFormattable
{
    public static final Port UNBOUND = LocalHost.localhost().port(0);

    @JsonProperty
    @OpenApiIncludeMember(description = "The application that is running the service")
    @UmlAggregation
    private Application.Identifier application;

    @UmlAggregation(label = "health status")
    private JavaVirtualMachineHealth health;

    @JsonProperty
    @OpenApiIncludeMember(description = "Metadata describing the service")
    @UmlAggregation
    private ServiceMetadata metadata;

    @JsonProperty
    @OpenApiIncludeMember(
            description = "The port that has been allocated for use by the service on the local host by the local KivaKit registry")
    @UmlAggregation(label = "allocated port")
    private Port port;

    private long renewedAt;

    @JsonProperty
    @OpenApiIncludeMember(description = "The scope that the service is visible to")
    @UmlAggregation(label = "visibility")
    private Scope scope;

    @JsonProperty
    @OpenApiIncludeMember(description = "The type of service")
    @UmlAggregation(label = "provided service")
    private ServiceType type;

    public Service()
    {
    }

    public Service application(Application.Identifier application)
    {
        this.application = application;
        return this;
    }

    @IncludeProperty
    public Application.Identifier application()
    {
        return application;
    }

    @Override
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public String asString(@NotNull Format format)
    {
        switch (format)
        {
            case LOG:
                return new ObjectFormatter(this).asString(SINGLE_LINE);

            default:
                return toString();
        }
    }

    @Override
    public int compareTo(@NotNull Service that)
    {
        return Long.compare(port.portNumber(), that.port.portNumber());
    }

    public String descriptor()
    {
        return port + "-" + type;
    }

    @Override
    public boolean equals(Object object)
    {
        if (object instanceof Service that)
        {
            return application.equals(that.application) && type.equals(that.type) && port.equals(that.port());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(application, type, port);
    }

    @IncludeProperty
    public JavaVirtualMachineHealth health()
    {
        return health;
    }

    @SuppressWarnings("UnusedReturnValue")
    public Service health(JavaVirtualMachineHealth health)
    {
        this.health = health;
        return this;
    }

    public String hostAndApplication()
    {
        var host = port().host();
        var hostName = host.isLocal()
                ? ""
                : host.name() + ":";

        return hostName + application();
    }

    @NotNull
    public String hostApplicationAndPort()
    {
        return hostAndApplication() + ":" + port.portNumber();
    }

    @JsonIgnore
    public boolean isBound()
    {
        return !isUnbound();
    }

    public boolean isSame(Service that)
    {
        return application.equals(that.application) && type.equals(that.type);
    }

    /**
     * Returns true if it has been too long since this service was renewed, and it is in danger of being expired "soon"
     */
    @JsonIgnore
    public boolean isStale()
    {
        return renewedAt().elapsedSince().isGreaterThan(require(ServiceRegistrySettings.class)
                .serviceLeaseRenewalFrequency().cycleLength().times(1.5));
    }

    @JsonIgnore
    public boolean isUnbound()
    {
        return UNBOUND.equals(port);
    }

    public ServiceMetadata metadata()
    {
        if (metadata == null)
        {
            metadata = new ServiceMetadata();
        }
        return metadata;
    }

    public Service metadata(ServiceMetadata metadata)
    {
        this.metadata = metadata;
        return this;
    }

    public Service port(Port port)
    {
        this.port = port;
        return this;
    }

    /**
     * Returns the port that this service is bound to
     */
    @IncludeProperty
    public Port port()
    {
        return port;
    }

    @SuppressWarnings("UnusedReturnValue")
    public Service renewedAt(Time renewedAt)
    {
        this.renewedAt = renewedAt.milliseconds();
        return this;
    }

    @IncludeProperty
    public Time renewedAt()
    {
        return Time.epochMilliseconds(renewedAt);
    }

    public Scope scope()
    {
        return scope;
    }

    public Service scope(Scope scope)
    {
        this.scope = scope;
        return this;
    }

    @Override
    public String toString()
    {
        return new ObjectFormatter(this).asString(SINGLE_LINE);
    }

    public Service type(ServiceType type)
    {
        this.type = type;
        return this;
    }

    /**
     * Returns the type of service
     */
    @IncludeProperty
    public ServiceType type()
    {
        return type;
    }
}
