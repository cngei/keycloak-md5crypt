# Keycloak BCrypt

Add a password hash provider to handle Md5Crypt passwords inside Keycloak.
It also supports raw md5 hash.

It's *obviously* discouraged to use this: please use a better hash.

## Build
```bash
./gradlew jar
```

## How to use
Copy the produced jar from `build/libs` to your Keycloak deployment.  
Go to `Authentication` / `Password policy` and add an hashing algorithm policy with value `md5crypt`.

To test if installation works, create new user and set its credentials.

## Authors

[Paolo Campanelli](paolo.campanelli@cngei.it) - Initial implementation

Based on the work by [leroyguillaume](https://github.com/leroyguillaume/keycloak-bcrypt)