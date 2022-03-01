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

package com.telenav.kivakit.service.registry.protocol.renew;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telenav.kivakit.interfaces.string.Stringable;
import com.telenav.kivakit.core.language.reflection.property.KivaKitIncludeProperty;
import com.telenav.kivakit.core.language.strings.formatting.KivaKitFormatProperty;
import com.telenav.kivakit.core.language.strings.formatting.ObjectFormatter;
import com.telenav.kivakit.microservice.protocols.rest.openapi.OpenApiIncludeMember;
import com.telenav.kivakit.microservice.protocols.rest.openapi.OpenApiIncludeType;
import com.telenav.kivakit.service.registry.Service;
import com.telenav.kivakit.service.registry.project.lexakai.DiagramRest;
import com.telenav.kivakit.service.registry.protocol.BaseResponse;
import com.telenav.lexakai.annotations.LexakaiJavadoc;
import com.telenav.lexakai.annotations.UmlClassDiagram;

import static com.telenav.kivakit.core.language.strings.formatting.ObjectFormatter.Format.MULTILINE;

/**
 * The service with its renewedAt time updated.
 *
 * @author jonathanl (shibo)
 */
@OpenApiIncludeType(description = "Response to a renew service request")
@UmlClassDiagram(diagram = DiagramRest.class)
@LexakaiJavadoc(complete = true)
public class RenewServiceResponse extends BaseResponse<Service>
{
    @JsonProperty
    @OpenApiIncludeMember(description = "The service that was renewed")
    private Service service;

    @KivaKitIncludeProperty
    @KivaKitFormatProperty(format = Stringable.Format.LOG)
    public Service service()
    {
        return service;
    }

    public RenewServiceResponse service(Service service)
    {
        this.service = service;
        return this;
    }

    @Override
    public String toString()
    {
        return new ObjectFormatter(this).toString(MULTILINE);
    }

    @Override
    protected void value(Service value)
    {
        service = value;
    }

    @Override
    protected Service value()
    {
        return service;
    }
}
