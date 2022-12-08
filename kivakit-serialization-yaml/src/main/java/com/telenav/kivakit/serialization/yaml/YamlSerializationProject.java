package com.telenav.kivakit.serialization.yaml;

import com.telenav.kivakit.core.BaseKivaKitProject;
import com.telenav.kivakit.core.project.Project;
import com.telenav.kivakit.resource.Extension;
import com.telenav.kivakit.resource.serialization.ObjectSerializerRegistry;

/**
 * This class defines a KivaKit {@link Project}. It cannot be constructed with the new operator since it has a private
 * constructor. To access the singleton instance of this class, call {@link Project#resolveProject(Class)}, or use
 * {@link com.telenav.kivakit.core.project.ProjectTrait#project(Class)}.
 *
 * <p>
 * Project initialization associates a {@link YamlObjectSerializer} with the <i>.yaml</i> extension in
 * {@link ObjectSerializerRegistry}.
 * </p>
 *
 * @author jonathanl (shibo)
 * @see YamlObjectSerializer
 * @see ObjectSerializerRegistry
 */
public class YamlSerializationProject extends BaseKivaKitProject
{
    @Override
    public void onInitialize()
    {
        // Associate YAML object serializer with .yaml resources
        require(ObjectSerializerRegistry.class, ObjectSerializerRegistry::new)
                .add(Extension.YAML, listenTo(new YamlObjectSerializer()))
                .add(Extension.YML, listenTo(new YamlObjectSerializer()));
    }
}
