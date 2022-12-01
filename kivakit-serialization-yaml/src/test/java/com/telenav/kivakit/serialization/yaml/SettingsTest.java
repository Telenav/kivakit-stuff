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

import com.telenav.kivakit.core.time.Duration;
import com.telenav.kivakit.settings.SettingsRegistry;
import com.telenav.kivakit.settings.SettingsTrait;
import com.telenav.kivakit.testing.UnitTest;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static com.telenav.kivakit.core.project.Project.resolveProject;
import static com.telenav.kivakit.core.registry.InstanceIdentifier.instanceIdentifier;

public class SettingsTest extends UnitTest
        implements SettingsTrait
{
    @Test
    public void testYaml()
    {
        var settings = listenToGlobalSettings();

        listenTo(resolveProject(YamlSerializationProject.class)).initialize();

        // Add all properties files in this package to the global set
        registerSettingsIn(packageForThis());

        // Get configuration
        {
            // Client code can then retrieve both settings
            var server1 = settings.requireSettings(ClientSettings.class, instanceIdentifier("banana"));
            ensureEqual("6 seconds", server1.timeout());
            ensureEqual(9999, server1.port());
        }
    }

    @NotNull
    private SettingsRegistry listenToGlobalSettings()
    {
        var global = settingsForThis();
        global.unload();
        global.clearListeners();
        global.addListener(this);
        return global;
    }
}
