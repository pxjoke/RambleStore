package com.pxjoke.requests.filtration;

import com.pxjoke.requests.AbstractRequestArguments;
import com.pxjoke.requests.filtration.restrictions.Limitation;
import com.pxjoke.requests.filtration.restrictions.Sorting;

public abstract class AbstractFilter extends AbstractRequestArguments {
    public Limitation limitation;
    public Sorting sorting;
}
