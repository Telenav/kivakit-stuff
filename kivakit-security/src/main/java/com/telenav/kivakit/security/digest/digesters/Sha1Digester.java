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

package com.telenav.kivakit.security.digest.digesters;

import com.telenav.kivakit.security.digest.BaseDigester;
import com.telenav.kivakit.security.internal.lexakai.DiagramSecurityDigest;
import com.telenav.lexakai.annotations.LexakaiJavadoc;
import com.telenav.lexakai.annotations.UmlClassDiagram;

/**
 * An SHA-1 message digester.
 *
 * @author jonathanl (shibo)
 */
@UmlClassDiagram(diagram = DiagramSecurityDigest.class)
@LexakaiJavadoc(complete = true)
public class Sha1Digester extends BaseDigester
{
    public Sha1Digester()
    {
        super("SHA-1");
    }
}
