# Keycloak BCrypt

Add a password hash provider to handle Md5Crypt passwords inside Keycloak.

## Build
```bash
./gradlew jar
```

## How to use
Go to `Authentication` / `Password policy` and add hashing algorithm policy with value `md5crypt`.

To test if installation works, create new user and set its credentials.

## Authors

[Paolo Campanelli](paolo.campanelli@cngei.it) - Initial implementation

Based on the work by [leroyguillaume](https://github.com/leroyguillaume/keycloak-bcrypt)