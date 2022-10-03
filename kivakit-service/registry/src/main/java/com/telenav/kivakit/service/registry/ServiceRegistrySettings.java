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

import com.telenav.kivakit.conversion.core.language.object.KivaKitConverted;
import com.telenav.kivakit.conversion.core.language.primitive.IntegerConverter;
import com.telenav.kivakit.conversion.core.time.DurationConverter;
import com.telenav.kivakit.conversion.core.time.FrequencyConverter;
import com.telenav.kivakit.conversion.core.value.VersionConverter;
import com.telenav.kivakit.core.language.reflection.property.KivaKitIncludeProperty;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.core.string.ObjectFormatter;
import com.telenav.kivakit.core.time.Duration;
import com.telenav.kivakit.core.time.Frequency;
import com.telenav.kivakit.core.version.Version;
import com.telenav.kivakit.core.vm.Properties;
import com.telenav.kivakit.network.core.Host;
import com.telenav.kivakit.network.core.Port;

import static com.telenav.kivakit.network.core.Loopback.loopback;

/**
 * Service registry settings. For defaults, see ServiceRegistrySettings.properties below:
 *
 * <ul>
 *     <li>{@link #localServiceRegistryPort(int)}</li>
 *     <li>{@link #networkServiceRegistryPort(Port)}</li>
 *     <li>{@link #portReservationExpirationTime(Duration)}</li>
 *     <li>{@link #restApiPath(String)}</li>
 *     <li>{@link #serviceLeaseRenewalFrequency(Frequency)}</li>
 *     <li>{@link #serviceRegistrationExpirationTime(Duration)}</li>
 *     <li>{@link #serviceRegistryStoreExpirationTime(Duration)}</li>
 *     <li>{@link #version(Version)}</li>
 * </ul>
 *
 * <p><b>ServiceRegistrySettings.properties</b></p>
 *
 * <pre>
 * class = com.telenav.kivakit.service.registry.ServiceRegistrySettings
 *
 * version = 0.8.9-SNAPSHOT
 * rest-api-path = api/v8
 * local-service-registry-port = 23573
 * network-service-registry-port = kivakit.service.registry:23575
 * service-lease-renewal-frequency = 30 seconds
 * service-registration-expiration-time = 2 minutes
 * service-registry-store-expiration-time = 2 hours
 * port-reservation-expiration-time = 2 hours
 * </pre>
 *
 * @author jonathanl (shibo)
 */
@SuppressWarnings("unused")
public class ServiceRegistrySettings
{
    /** The port used by the local service registry */
    private int localServiceRegistryPort;

    /** The host and port used by the network service registry */
    private Port networkServiceRegistryPort;

    /**
     * Ports will not be re-allocated after expiring for this amount of time. This allows a server to lose contact with
     * the registry, losing its registration entry, but when it comes back in contact with the registry it will be able
     * to reclaim its expired port and continue so long as it wasn't out of contact for more than this duration.
     */
    private Duration portReservationExpirationTime;

    /** Path to REST API */
    private String restApiPath;

    /** The frequency at which clients should renew leases */
    private Frequency serviceLeaseRenewalFrequency;

    /** Registry bindings expire after this amount of time */
    private Duration serviceRegistrationExpirationTime;

    /** The time-to-live of stored data before it is discarded */
    private Duration serviceRegistryStoreExpirationTime;

    /** The version of this build of service registry code */
    private Version version;

    /**
     * <b>Not public API</b>
     */
    public Port local()
    {
        return port(loopback());
    }

    @KivaKitConverted(IntegerConverter.class)
    public ServiceRegistrySettings localServiceRegistryPort(int localServiceRegistryPort)
    {
        this.localServiceRegistryPort = localServiceRegistryPort;
        return this;
    }

    @KivaKitIncludeProperty
    public int localServiceRegistryPort()
    {
        return localServiceRegistryPort;
    }

    /**
     * <b>Not public API</b>
     * <p>
     * Returns the service registry for the network (normally some kind of intranet)
     */
    public Port network()
    {
        @SuppressWarnings("SpellCheckingInspection")
        var port = Properties.systemPropertyOrEnvironmentVariable
                (
                        "KIVAKIT_NETWORK_SERVICE_REGISTRY_PORT",
                        "kivakit-network-service-registry.mypna.com:23575"
                );

        if (port != null)
        {
            return Port.parsePort(Listener.consoleListener(), port);
        }

        return networkServiceRegistryPort();
    }

    @KivaKitIncludeProperty
    public Port networkServiceRegistryPort()
    {
        return networkServiceRegistryPort;
    }

    @KivaKitConverted(Port.Converter.class)
    public ServiceRegistrySettings networkServiceRegistryPort(Port networkServiceRegistryPort)
    {
        this.networkServiceRegistryPort = networkServiceRegistryPort;
        return this;
    }

    @KivaKitIncludeProperty
    public Duration portReservationExpirationTime()
    {
        return portReservationExpirationTime;
    }

    @KivaKitConverted(DurationConverter.class)
    public ServiceRegistrySettings portReservationExpirationTime(Duration portReservationExpirationTime)
    {
        this.portReservationExpirationTime = portReservationExpirationTime;
        return this;
    }

    @KivaKitIncludeProperty
    public String restApiPath()
    {
        return restApiPath;
    }

    @KivaKitConverted
    public ServiceRegistrySettings restApiPath(String restApiPath)
    {
        this.restApiPath = restApiPath;
        return this;
    }

    @KivaKitIncludeProperty
    public Frequency serviceLeaseRenewalFrequency()
    {
        return serviceLeaseRenewalFrequency;
    }

    @KivaKitConverted(FrequencyConverter.class)
    public ServiceRegistrySettings serviceLeaseRenewalFrequency(Frequency serviceRenewalFrequency)
    {
        serviceLeaseRenewalFrequency = serviceRenewalFrequency;
        return this;
    }

    @KivaKitIncludeProperty
    public Duration serviceRegistrationExpirationTime()
    {
        return serviceRegistrationExpirationTime;
    }

    @KivaKitConverted(DurationConverter.class)
    public ServiceRegistrySettings serviceRegistrationExpirationTime(Duration registrationExpirationTime)
    {
        serviceRegistrationExpirationTime = registrationExpirationTime;
        return this;
    }

    @KivaKitIncludeProperty
    public Duration serviceRegistryStoreExpirationTime()
    {
        return serviceRegistryStoreExpirationTime;
    }

    @KivaKitConverted(DurationConverter.class)
    public ServiceRegistrySettings serviceRegistryStoreExpirationTime(Duration serviceRegistryStoreExpirationTime)
    {
        this.serviceRegistryStoreExpirationTime = serviceRegistryStoreExpirationTime;
        return this;
    }

    @Override
    public String toString()
    {
        return new ObjectFormatter(this).toString();
    }

    @KivaKitIncludeProperty
    public Version version()
    {
        return version;
    }

    @KivaKitConverted(VersionConverter.class)
    public void version(Version version)
    {
        this.version = version;
    }

    /**
     * <b>Not public API</b>
     */
    Port port(Host host)
    {
        return host.http(localServiceRegistryPort());
    }
}
