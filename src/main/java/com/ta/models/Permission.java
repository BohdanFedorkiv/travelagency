package com.ta.models;

public enum Permission {
    PERM_ONE("perm:one"),
    PERM_TWO("perm:two");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
