package com.telenav.kivakit.primitive.collections.array.scalars;

import com.telenav.kivakit.conversion.BaseStringConverter;
import com.telenav.kivakit.core.collections.list.StringList;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.core.string.Separators;
import com.telenav.kivakit.core.value.count.Maximum;
import com.telenav.lexakai.annotations.LexakaiJavadoc;

/**
 * Converts to and from an {@link IntArray}
 *
 * @author jonathanl (shibo)
 */
@LexakaiJavadoc(complete = true)
public class IntArrayConverter extends BaseStringConverter<IntArray>
{
    private final Separators separators;

    public IntArrayConverter(Listener listener, Separators separators)
    {
        super(listener, IntArray.class);
        this.separators = separators;
    }

    @Override
    protected String onToString(IntArray array)
    {
        var strings = new StringList(Maximum.maximum(array.size()));
        var values = array.iterator();
        while (values.hasNext())
        {
            strings.add(Integer.toString(values.next()));
        }
        return strings.join(separators.current());
    }

    @Override
    protected IntArray onToValue(String value)
    {
        var elements = StringList.split(value, separators.current());
        var array = new IntArray("converted");
        array.initialize();
        for (var element : elements)
        {
            array.add(Integer.parseInt(element));
        }
        return array;
    }
}
