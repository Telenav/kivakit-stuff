package com.telenav.kivakit.ui.desktop.component.health;

import com.telenav.kivakit.core.time.Duration;
import com.telenav.kivakit.core.vm.JavaVirtualMachineHealth;
import com.telenav.kivakit.ui.desktop.component.panel.stack.FlashCardPanel;
import com.telenav.kivakit.ui.desktop.component.version.KivaKitBuild;

import java.awt.FlowLayout;

/**
 * @author jonathanl (shibo)
 */
public class HealthPanel extends FlashCardPanel
{
    private MemoryUse memoryUse;

    private CpuUse cpuUse;

    private int updates;

    public HealthPanel()
    {
        setOpaque(false);

        add(new KivaKitBuild());
    }

    public void update(JavaVirtualMachineHealth health)
    {
        if (updates == 0)
        {
            memoryUse = new MemoryUse();
            memoryUse.setLayout(new FlowLayout(FlowLayout.RIGHT));

            cpuUse = new CpuUse();
            cpuUse.setLayout(new FlowLayout(FlowLayout.RIGHT));

            add(memoryUse);
            start(Duration.seconds(5));
        }

        if (updates == 1)
        {
            add(cpuUse);
        }

        memoryUse.update(health);
        cpuUse.update(health);

        updates++;
    }
}
