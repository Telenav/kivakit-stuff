package com.telenav.kivakit.primitive.collections.array.scalars;

import com.telenav.kivakit.conversion.BaseStringConverter;
import com.telenav.kivakit.core.collections.list.StringList;
import com.telenav.kivakit.core.messaging.Listener;
import com.telenav.kivakit.core.string.Separators;
import com.telenav.kivakit.core.value.count.Maximum;
import com.telenav.lexakai.annotations.LexakaiJavadoc;

/**
 * Converts to and from a {@link CharArray}
 *
 * @author jonathanl (shibo)
 */
@LexakaiJavadoc(complete = true)
public class CharArrayConverter extends BaseStringConverter<CharArray>
{
    private final Separators separators;

    public CharArrayConverter(Listener listener, Separators separators)
    {
        super(listener, CharArray.class);
        this.separators = separators;
    }

    @Override
    protected String onToString(CharArray array)
    {
        var strings = new StringList(Maximum.maximum(array.size()));
        var values = array.iterator();
        while (values.hasNext())
        {
            strings.add(Character.toString(values.next()));
        }
        return strings.join(separators.current());
    }

    @Override
    protected CharArray onToValue(String value)
    {
        var array = new CharArray("converted");
        array.initialize();
        for (var index = 0; index < value.length(); index++)
        {
            array.add(value.charAt(index));
        }
        return array;
    }
}
