open module kivakit.service.registry
{
    // KivaKit
    requires transitive kivakit.microservice;
    requires transitive kivakit.network.core;

    // Jackson
    requires com.fasterxml.jackson.annotation;

    // JSON
    requires gson;

    // Module exports
    exports com.telenav.kivakit.service.registry;
    exports com.telenav.kivakit.service.registry.project;
    exports com.telenav.kivakit.service.registry.project.lexakai;
    exports com.telenav.kivakit.service.registry.protocol;
    exports com.telenav.kivakit.service.registry.registries;
    exports com.telenav.kivakit.service.registry.store;
    exports com.telenav.kivakit.service.registry.protocol.discover;
    exports com.telenav.kivakit.service.registry.protocol.update;
    exports com.telenav.kivakit.service.registry.protocol.register;
    exports com.telenav.kivakit.service.registry.protocol.renew;
    exports com.telenav.kivakit.service.registry.serialization;
}
