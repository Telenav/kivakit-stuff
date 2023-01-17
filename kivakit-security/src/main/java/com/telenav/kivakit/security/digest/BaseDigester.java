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

package com.telenav.kivakit.security.digest;

import com.telenav.kivakit.core.io.IO;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.resource.Resource;
import com.telenav.kivakit.security.internal.lexakai.DiagramSecurityDigest;
import com.telenav.lexakai.annotations.LexakaiJavadoc;
import com.telenav.lexakai.annotations.UmlClassDiagram;

import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.telenav.kivakit.core.ensure.Ensure.illegalState;

/**
 * Base class for message digesters. The method {@link #digest(byte[])} creates the digest.
 *
 * @author jonathanl (shibo)
 */
@UmlClassDiagram(diagram = DiagramSecurityDigest.class)
@LexakaiJavadoc(complete = true)
public abstract class BaseDigester implements Digester
{
    private final String algorithmName;

    protected BaseDigester(String algorithmName)
    {
        this.algorithmName = algorithmName;
    }

    @Override
    public byte[] digest(byte[] value)
    {
        return digester().digest(value);
    }

    public byte[] digest(Listener listener, Resource resource)
    {
        var digester = digester();
        try (var in = resource.openForReading())
        {
            IO.readBytes(listener, new DigestInputStream(in, digester));
        }
        catch (Exception e)
        {
            return illegalState("Cannot create $ digest for: $", algorithmName, resource);
        }
        return digester.digest();
    }

    public MessageDigest digester()
    {
        try
        {
            return MessageDigest.getInstance(algorithmName);
        }
        catch (NoSuchAlgorithmException e)
        {
            return illegalState("Can't find digest algorithm: $", algorithmName);
        }
    }
}
