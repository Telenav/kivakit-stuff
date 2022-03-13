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

import com.telenav.kivakit.core.path.PackagePath;
import com.telenav.kivakit.core.test.UnitTest;
import com.telenav.kivakit.core.time.Duration;
import com.telenav.kivakit.settings.Settings;
import com.telenav.kivakit.settings.stores.PackageSettingsStore;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static com.telenav.kivakit.core.project.Project.resolveProject;

public class SettingsTest extends UnitTest
{
    @Test
    public void testYaml()
    {
        var settings = settings();

        resolveProject(YamlSerializationProject.class).initialize();

        // Configure
        {
            // Add all properties files in this package to the global set
            settings.registerSettingsIn(PackageSettingsStore.of(this, PackagePath.packagePath(getClass())));
        }

        // Get configuration
        {
            // Client code can then retrieve both settings
            var server1 = settings.requireSettings(ClientSettings.class, "banana");
            ensureEqual(Duration.seconds(6), server1.timeout());
            ensureEqual(9999, server1.port());
        }
    }

    @NotNull
    private Settings settings()
    {
        var global = Settings.of(this);
        global.unload();
        global.clearListeners();
        global.addListener(this);
        return global;
    }
}
