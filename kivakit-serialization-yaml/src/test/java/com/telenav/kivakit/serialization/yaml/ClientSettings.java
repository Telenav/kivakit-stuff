package com.telenav.kivakit.serialization.yaml;////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

import com.telenav.kivakit.conversion.core.language.object.ConvertedProperty;
import com.telenav.kivakit.conversion.core.language.primitive.IntegerConverter;
import com.telenav.kivakit.conversion.core.time.DurationConverter;

/**
 * Configuration Java Bean with string conversion methods for each property to allow storage of this configuration in a
 * property file.
 *
 * @author jonathanl (shibo)
 */
@SuppressWarnings("unused")
public class ClientSettings
{
    private int port;

    private String timeout;

    public int getPort()
    {
        return port;
    }

    public String getTimeout()
    {
        return timeout;
    }

    public int port()
    {
        return port;
    }

    @ConvertedProperty(IntegerConverter.class)
    public void port(int port)
    {
        this.port = port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setTimeout(String timeout)
    {
        this.timeout = timeout;
    }

    public String timeout()
    {
        return timeout;
    }

    @ConvertedProperty(DurationConverter.class)
    public void timeout(String timeout)
    {
        this.timeout = timeout;
    }

    @Override
    public String toString()
    {
        return "[ClientSettings timeout = " + timeout + ", port = " + port + "]";
    }
}
