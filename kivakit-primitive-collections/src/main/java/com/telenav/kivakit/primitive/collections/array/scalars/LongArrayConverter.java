package com.telenav.kivakit.primitive.collections.array.scalars;

import com.telenav.kivakit.conversion.BaseStringConverter;
import com.telenav.kivakit.core.collections.list.StringList;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.core.string.Separators;
import com.telenav.kivakit.core.value.count.Maximum;
import com.telenav.lexakai.annotations.LexakaiJavadoc;

/**
 * Converts to and from a {@link LongArray}
 *
 * @author jonathanl (shibo)
 */
@LexakaiJavadoc(complete = true)
public class LongArrayConverter extends BaseStringConverter<LongArray>
{
    private final Separators separators;

    public LongArrayConverter(Listener listener, Separators separators)
    {
        super(listener, LongArray.class);
        this.separators = separators;
    }

    @Override
    protected String onToString(LongArray array)
    {
        var strings = new StringList(Maximum.maximum(array.size()));
        var values = array.iterator();
        while (values.hasNext())
        {
            strings.add(Long.toString(values.next()));
        }
        return strings.join(separators.current());
    }

    @Override
    protected LongArray onToValue(String value)
    {
        var elements = StringList.split(value, separators.current());
        var array = new LongArray("converted");
        array.initialize();
        for (var element : elements)
        {
            array.add(Long.parseLong(element));
        }
        return array;
    }
}
