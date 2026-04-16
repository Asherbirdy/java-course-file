# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Security course exercise (lesson-3-2). A Spring Boot 3.1.5 app demonstrating HTTP Basic / form login authentication with in-memory users and role-based authorization.

## Build & Run

```bash
./mvnw spring-boot:run        # Run the app (port 8083)
./mvnw test                   # Run tests
./mvnw package                # Build JAR
```

No Maven wrapper is checked in — use a local `mvn` installation if `./mvnw` is unavailable:

```bash
mvn spring-boot:run
mvn test
```

## Architecture

- **Java 17**, **Spring Boot 3.1.5**, **Spring Security**
- Base package: `com.kucw.security`
- `security/MySecurityConfig` — SecurityFilterChain config: CSRF disabled, HTTP Basic + form login, role-based access (`/hello` requires `ADMIN` role, all other endpoints require authentication). Two in-memory users: `test1`/`111`, `test2`/`222` (no roles assigned).
- `controller/MyController` — Two GET endpoints: `/hello`, `/welcome`
- App runs on **port 8083** (`application.properties`)
