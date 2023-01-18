package com.telenav.kivakit.primitive.collections.array.scalars;

import com.telenav.kivakit.conversion.BaseStringConverter;
import com.telenav.kivakit.core.collections.list.StringList;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.core.string.Separators;
import com.telenav.kivakit.core.value.count.Maximum;
import com.telenav.lexakai.annotations.LexakaiJavadoc;

/**
 * Converts to and from {@link ShortArray}
 *
 * @author jonathanl (shibo)
 */
@LexakaiJavadoc(complete = true)
public class ShortArrayConverter extends BaseStringConverter<ShortArray>
{
    private final Separators separators;

    public ShortArrayConverter(Listener listener, Separators separators)
    {
        super(listener, ShortArray.class);
        this.separators = separators;
    }

    @Override
    protected String onToString(ShortArray array)
    {
        var strings = new StringList(Maximum.maximum(array.size()));
        var values = array.iterator();
        while (values.hasNext())
        {
            strings.add(Short.toString(values.next()));
        }
        return strings.join(separators.current());
    }

    @Override
    protected ShortArray onToValue(String value)
    {
        var elements = StringList.split(value, separators.current());
        var array = new ShortArray("converted");
        array.initialize();
        for (var element : elements)
        {
            array.add(Short.parseShort(element));
        }
        return array;
    }
}
