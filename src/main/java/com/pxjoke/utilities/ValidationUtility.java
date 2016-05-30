package com.pxjoke.utilities;

import com.pxjoke.enums.UserRole;

public final class ValidationUtility {
    private ValidationUtility() {

    }

    public static boolean isValidID(final Long ID) {
        return ID != null && ID > 0;
    }

    public static boolean isValidUserRole(final UserRole role) {
        return role != null;
    }

    public static boolean isEmpty(final Object object) {
        return object == null;
    }

    public static boolean isEmpty(final String string) {
        return string == null || string.isEmpty();
    }
}
