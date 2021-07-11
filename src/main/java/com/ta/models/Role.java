package com.ta.models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;


public enum Role
      // implements GrantedAuthority
{
    USER(Set.of(Permission.PERM_ONE)),
    MANAGER(Set.of(Permission.PERM_TWO));

//    @Override
//    public String getAuthority() {
//        return name();
//    }

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
