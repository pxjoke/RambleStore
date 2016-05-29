package com.pxjoke.requests.filtration.restrictions;

import java.io.Serializable;

public final class Range<T extends Serializable>{
    public T min;
    public T max;
}
